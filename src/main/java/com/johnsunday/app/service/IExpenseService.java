package com.johnsunday.app.service;

import java.time.LocalDateTime;
import java.util.List;

import com.johnsunday.app.entity.Expense;

public interface IExpenseService extends IBaseService<Expense,Integer> {

	public List<Expense> findAllExpenseByEmployeeId(Integer employeeId) throws Exception;
	public Boolean findByAmountAndExpenseDateAndConceptAndEmployeeIdFk(Double amount,
																	   LocalDateTime expenseDate,
																	   String concept,
																	   Integer employeeIdFk);
}
