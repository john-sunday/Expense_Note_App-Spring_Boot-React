package com.johnsunday.app.dto;

import com.johnsunday.app.entity.Expense;

public class ExpenseMapper {
	// Without ID.
	public static Expense dtoToExpense(DtoExpense dtoExpense) {
		return new Expense(
				dtoExpense.getConcept(),
				dtoExpense.getNote(),
				dtoExpense.getDate(),
				dtoExpense.getAmount(),				
				EmployeeMapper.dtoToEmployeeWithId(dtoExpense.getDtoEmployee())
				);
	}
	public static DtoExpense expenseToDto(Expense expense) {
		return new DtoExpense(
				expense.getConcept(),
				expense.getNote(),
				expense.getDate(),
				expense.getAmount(),				
				EmployeeMapper.employeeToDtoWithId(expense.getEmployee())
				);
	}
	// With ID.
	public static Expense dtoToExpenseWithId(DtoExpense dtoExpense) {
		return new Expense(
				dtoExpense.getId(),
				dtoExpense.getConcept(),
				dtoExpense.getNote(),
				dtoExpense.getDate(),
				dtoExpense.getAmount(),				
				EmployeeMapper.dtoToEmployeeWithId(dtoExpense.getDtoEmployee())
				);
	}	
	public static DtoExpense expenseToDtoWithId(Expense expense) {
		return new DtoExpense(
				expense.getId(),
				expense.getConcept(),
				expense.getNote(),
				expense.getDate(),
				expense.getAmount(),				
				EmployeeMapper.employeeToDtoWithId(expense.getEmployee())
				);
	}
}
