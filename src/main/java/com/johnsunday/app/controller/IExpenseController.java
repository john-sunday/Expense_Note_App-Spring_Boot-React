package com.johnsunday.app.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsunday.app.dto.ExpenseDto;

public interface IExpenseController<Expense> {

	public ResponseEntity<?> getAllExpenseByEmployeeId(@PathVariable Integer employeeId,
													   @RequestParam Integer requestUserId);
	public ResponseEntity<?> getAllExpense(@RequestParam Integer requestUserId);	
	public ResponseEntity<?> getOneExpense(@PathVariable Integer id,
										   @RequestParam Integer requestUserId);
	public ResponseEntity<?> saveExpense(@RequestBody @Valid ExpenseDto dtoExpense,
			  						     @RequestParam Integer requestUserId,
			  						     @RequestHeader String token);
	public ResponseEntity<?> updateExpense(@PathVariable Integer id,
										   @RequestBody @Valid ExpenseDto dtoExpense,
										   @RequestParam Integer requestUserId);
	public ResponseEntity<?> deleteExpense(@PathVariable Integer id,
										   @RequestParam Integer requestUserId);	
}
