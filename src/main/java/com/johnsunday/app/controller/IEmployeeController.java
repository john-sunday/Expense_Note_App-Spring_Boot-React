package com.johnsunday.app.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsunday.app.entity.Employee;


public interface IEmployeeController {

	public ResponseEntity<?> getAllEmployee(@RequestParam Integer requestUserId);	
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer employeeId,
										    @RequestParam Integer requestUserId);
	public ResponseEntity<?> saveEmployee(@RequestBody @Valid Employee employee,
			  						      @RequestParam Integer requestUserId);
	public ResponseEntity<?> updateEmployee(@PathVariable Integer userId,
										   @RequestBody @Valid Employee employee,
										   @RequestParam Integer requestUserId);
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer employeeId,
										    @RequestParam Integer requestUserId);
	public ResponseEntity<?> getUserByNameAndSurname(@PathVariable String name,
															   @PathVariable String surname,
															   @RequestParam Integer requestUserId);
}
