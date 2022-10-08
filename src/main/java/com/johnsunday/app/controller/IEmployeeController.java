package com.johnsunday.app.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsunday.app.entity.Employee;


public interface IEmployeeController {

	public ResponseEntity<?> getAllEmployee();	
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer employeeId);
	public ResponseEntity<?> saveEmployee(@RequestBody @Valid Employee employee);
	public ResponseEntity<?> updateEmployee(@RequestBody @Valid Employee employee,
											@PathVariable Integer employeeId);
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer employeeId);
	public ResponseEntity<?> getUserByNameAndSurname(@PathVariable String name,
												     @PathVariable String surname);
}
