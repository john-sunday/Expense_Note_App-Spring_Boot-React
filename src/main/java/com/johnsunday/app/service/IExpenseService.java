package com.johnsunday.app.service;

import java.time.LocalDateTime;
import java.util.List;

import com.johnsunday.app.entity.Expense;

public interface IExpenseService {
	
	public List<Expense> findAll() throws Exception;
	public Expense findById(Integer id,String headerAuth) throws Exception;
	public Expense save(Expense expense,String headerAuth) throws Exception;

	public Expense update(/* Integer id, */Expense expense,String headerAuth) throws Exception;
	public Boolean delete(Integer id) throws Exception;
	public List<Expense> findAllByEmployeeId(Integer employeeId,String headerAuth) throws Exception;
	public Expense findByAmountAndDateAndConceptAndEmployeeId(Double amount,
															  LocalDateTime expenseDate,																	 String concept,
															  Integer employeeId,
															  String headerAuth) throws Exception;
}
