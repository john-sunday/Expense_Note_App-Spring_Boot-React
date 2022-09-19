package com.johnsunday.app.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnsunday.app.dao.IExpenseDao;
import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.Expense;

@Service
public class ExpenseServiceImpl implements IExpenseService {

	@Autowired private IExpenseDao expenseDao;
		
	@Override	
	public List<Expense> findAllExpenseByEmployeeId(Integer employeeId) throws Exception {
		try {
			//return expenseDao.findAllExpenseByEmployeeId(employeeId);
			return expenseDao.findAllByEmployeeId(employeeId);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public Boolean findByAmountAndExpenseDateAndConceptAndEmployeeIdFk(Double amount, 
																	   LocalDateTime date,
																	   String concept, 
																	   Integer employeeIdFk) {
		return expenseDao.findByAmountAndExpenseDateAndConceptAndEmployeeIdFkAllIgnoreCase(amount, 
																						   date, 
																						   concept, 
																						   employeeIdFk);
	}
	@Override
	public Expense save(Expense expense) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddTHH:mm:00:000",Locale.ROOT);
		String formattedStringDate = formatter.format(expense.getDate());
		//Test.
		System.out.println(formattedStringDate);
		LocalDateTime parsedDate = LocalDateTime.parse(formattedStringDate, formatter);
		expense.setDate(parsedDate);
				
		return expenseDao.save(expense);
	}
	@Override
	public List<Expense> findAll() throws Exception {
		try {
			return expenseDao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public Expense findById(Integer id) throws Exception {
		try {
			Optional<Expense> optionalExpense = expenseDao.findById(id);
			return optionalExpense.get();
		}catch(Exception e) {			
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	@Transactional
	public Expense update(Integer id,Expense expense) throws Exception {
		Expense expenseUpdated = null;
		try {
			Optional<Expense> optionalExpense = expenseDao.findById(id);
			Expense oldExpense = optionalExpense.get();			
			if(oldExpense!=null) {
				expenseUpdated = expenseDao.save(expense);				
			}					
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return expenseUpdated;	
	}
	@Override
	@Transactional
	public Boolean delete(Integer id) throws Exception {
		boolean isDeleted = false;
		try {
			if(expenseDao.existsById(id)) {
				expenseDao.deleteById(id);
				isDeleted = true;
			} else {
				throw new Exception();
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return isDeleted;
	}	
}
