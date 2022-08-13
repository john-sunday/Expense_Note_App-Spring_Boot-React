package com.johnsunday.app.service;

import java.util.List;

import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.Expense;

public interface IExpenseService extends IBaseService<Expense,Integer> {

	public List<Expense> findExpenseByEmployeeId(Integer id) throws Exception;
	public Expense saveEmployeeExpense(Expense expense) throws Exception;	
}
