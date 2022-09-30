package com.johnsunday.app.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.service.ExpenseServiceImpl;

public class ExpenseUtil {

	@Autowired private static ExpenseServiceImpl expenseService;
	
	public static Boolean existsExpenseInDb(Expense expense) {
		boolean exists = false;
		if (expenseService.findByAmountAndExpenseDateAndConceptAndEmployeeIdFk(
				expense.getAmount(), 
				expense.getDate(), 
				expense.getConcept(), 
				expense.getEmployee().getId())) {			
			exists = true;
		}		
		return exists;
	}
}
