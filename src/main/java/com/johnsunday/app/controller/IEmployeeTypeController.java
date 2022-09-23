package com.johnsunday.app.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public interface IEmployeeTypeController<EmployeeType> {

	public ResponseEntity<?> getAllEmployeeType(@RequestParam Integer requestUserId);	
	public ResponseEntity<?> getOneEmployeeType(@PathVariable Integer id,
										    	@RequestParam Integer requestUserId);
	public ResponseEntity<?> saveEmployeeType(@RequestBody @Valid EmployeeType employeeType,
			  						      	  @RequestParam Integer requestUserId);
	public ResponseEntity<?> updateEmployeeType(@PathVariable Integer userId,
										        @RequestBody @Valid EmployeeType employeeType,
										        @RequestParam Integer requestUserId);
	public ResponseEntity<?> deleteEmployeeType(@PathVariable Integer id,
										    	@RequestParam Integer requestUserId);
	
}
