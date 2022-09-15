package com.johnsunday.app.dto;

import com.johnsunday.app.entity.Expense;

public class ExpenseMapper {
	
	public static Expense dtoToExpense(DtoExpense dtoExpense) {
		return new Expense(
				dtoExpense.getDtoExpenseConcept(),
				dtoExpense.getDtoExpenseNote(),
				dtoExpense.getDtoExpenseDate(),
				dtoExpense.getDtoExpenseAmount(),				
				EmployeeMapper.dtoToEmployee(dtoExpense.getDtoEmployee())
				);
	}
	
	public static DtoExpense expenseToDto(Expense expense) {
		return new DtoExpense(
				expense.getConcept(),
				expense.getNote(),
				expense.getExpenseDate(),
				expense.getAmount(),				
				EmployeeMapper.employeeToDto(expense.getEmployee())
				);
	}
}
