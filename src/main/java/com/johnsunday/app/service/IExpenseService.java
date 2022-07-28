package com.johnsunday.app.service;

import java.util.List;

import com.johnsunday.app.entity.Expense;

public interface IExpenseService extends IBaseService<Expense> {

	public List<Expense> findExpenseByEmployeeId(Integer id) throws Exception;
}
