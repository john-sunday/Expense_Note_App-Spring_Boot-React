package com.johnsunday.app.service;

import java.time.LocalDateTime;
import java.util.List;

import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.Expense;

public interface IExpenseService {
	
	public List<Expense> findAll() throws Exception;
	public Expense findById(Integer id) throws Exception;
	public Expense save(Expense expense) throws Exception;
	public Expense update(Integer id,Expense expense) throws Exception;
	public Boolean delete(Integer id) throws Exception;
	public List<Expense> findAllExpenseByEmployeeId(Integer employeeId) throws Exception;
	public Boolean findByAmountAndExpenseDateAndConceptAndEmployeeIdFk(Double amount,
																	   LocalDateTime expenseDate,
																	   String concept,
																	   Integer employeeIdFk) throws Exception;
}
