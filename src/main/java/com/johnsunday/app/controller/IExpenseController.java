package com.johnsunday.app.controller;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsunday.app.dto.DtoExpense;
import com.johnsunday.app.entity.BaseEntity;

public interface IExpenseController<E extends BaseEntity,ID extends Serializable> {

	public ResponseEntity<?> getAllExpenseByEmployeeId(@PathVariable ID employeeId,
													   @RequestParam ID requestUserId);
	public ResponseEntity<?> getAllExpense(@RequestParam Integer requestUserId);	
	public ResponseEntity<?> getOneExpense(@PathVariable ID expenseId,
										   @RequestParam ID requestUserId);
	public ResponseEntity<?> saveExpense(@RequestBody @Valid DtoExpense dtoExpense,
			  						     @RequestParam Integer requestUserId);
	public ResponseEntity<?> updateExpense(@PathVariable ID userId,
										   @RequestBody @Valid DtoExpense dtoExpense,
										   @RequestParam ID requestUserId);
	public ResponseEntity<?> deleteExpense(@PathVariable ID expenseId,
										   @RequestParam ID requestUserId);	
}
