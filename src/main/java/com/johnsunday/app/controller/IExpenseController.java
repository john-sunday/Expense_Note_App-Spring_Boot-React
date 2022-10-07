package com.johnsunday.app.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public interface IExpenseController<Expense> {

	public ResponseEntity<?> getAllExpenseByEmployeeId(@PathVariable Integer employeeId,
													   @RequestParam Integer requestUserId);
	public ResponseEntity<?> getAllExpense(@RequestParam Integer requestUserId);	
	public ResponseEntity<?> getExpenseById(@PathVariable Integer expenseId,
										    @RequestParam Integer requestUserId);
	public ResponseEntity<?> saveExpense(@RequestBody @Valid Expense expense,
			  						     @RequestParam Integer requestUserId);
	public ResponseEntity<?> updateExpense(@PathVariable Integer expenseId,
										   @RequestBody @Valid Expense expense,
										   @RequestParam Integer requestUserId);
	public ResponseEntity<?> deleteExpense(@PathVariable Integer expenseId,
										   @RequestParam Integer requestUserId);	
}
