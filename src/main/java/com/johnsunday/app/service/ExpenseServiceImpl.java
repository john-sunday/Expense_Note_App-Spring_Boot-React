package com.johnsunday.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnsunday.app.dao.IExpenseDao;
import com.johnsunday.app.dao.IExpenseEmployeeDao;
import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.entity.ExpenseEmployee;

@Service
public class ExpenseServiceImpl extends BaseServiceImpl<Expense,Integer> 
								implements IExpenseService {

	@Autowired
	private IExpenseDao expenseDao;
	@Autowired
	private IExpenseEmployeeDao expenseEmployeeDao;
	
	@Override	
	public List<Expense> findExpenseByEmployeeId(Integer employeeId) throws Exception {
		try {
			return expenseDao.findAllExpenseByEmployeeId(employeeId);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	@Transactional
	public Expense saveEmployeeExpense(Expense expense) throws Exception {
		Employee employee = expense.getEmployee();
		employee.addExpense(expense);
		System.out.println(employee.getName());
		try {
			expenseEmployeeDao.save(new ExpenseEmployee(expense.getId(),employee.getId()));
			return expenseDao.save(expense);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}		
	}
}
