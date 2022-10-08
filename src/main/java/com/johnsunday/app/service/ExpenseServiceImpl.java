package com.johnsunday.app.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.johnsunday.app.dao.IExpenseDao;
import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.security.entity.Role;
import com.johnsunday.app.security.entity.User;
import com.johnsunday.app.security.jwt.JwtAuthenticationUtil;
import com.johnsunday.app.security.service.UserServiceImpl;
import com.johnsunday.app.util.DateUtil;
import com.johnsunday.app.util.UserUtil;

import io.jsonwebtoken.Claims;

@Service
public class ExpenseServiceImpl implements IExpenseService {

	@Autowired private IExpenseDao expenseDao;
	@Autowired private JwtAuthenticationUtil jwtAuthUtil;
	@Autowired private EmployeeServiceImpl employeeService;
	@Autowired UserServiceImpl userService;
		
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
	@Transactional
	public Expense save(Expense expense,String headerAuth) throws Exception {
		boolean isAdmin = false;
		Expense savedExpense = new Expense();
		
		// We set the Expense's date.
		LocalDateTime parsedDate = DateUtil.formattingDate(expense.getDate());
		expense.setDate(parsedDate);
		// We extract the token from the header.
		String token = headerAuth.split(" ")[1].trim();
		// We extract the user Role(s).
		//isAdmin = UserUtil.isAdminUser(token);
		
//		Claims claims = jwtAuthUtil.parseClaims(token);
//		String claimRoles = (String) claims.get("roles");		
//		claimRoles = claimRoles.replace("[", "").replace("]", "");
//		String[]roleNames =  claimRoles.split(",");
//		for (String role:roleNames) {
//			if (role.equalsIgnoreCase("ROLE_ADMIN")) {
//				isAdmin = true;
//				break;
//			}
//		}
		
		isAdmin = jwtAuthUtil.isAdminTokenUser(token);
		
		if (isAdmin) savedExpense = expenseDao.save(expense);
		else {	
			if (jwtAuthUtil.matchEmail(expense.getEmployee())) savedExpense = expenseDao.save(expense);
			
		}

		//Collection<Role>roles = optRequestUser.get().getRoles();
	 
		
		return savedExpense;
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
				LocalDateTime parsedDate = DateUtil.formattingDate(expense.getDate());
				expense.setDate(parsedDate);
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
