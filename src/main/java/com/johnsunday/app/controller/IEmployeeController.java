package com.johnsunday.app.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public interface IEmployeeController<Employee> {

	public ResponseEntity<?> getAllEmployee(@RequestParam Integer requestUserId);	
	public ResponseEntity<?> getOneEmployee(@PathVariable Integer employeeId,
										    @RequestParam Integer requestUserId);
	public ResponseEntity<?> saveEmployee(@RequestBody @Valid Employee employee,
			  						      @RequestParam Integer requestUserId);
	public ResponseEntity<?> updateEmployee(@PathVariable Integer userId,
										   @RequestBody @Valid Employee employee,
										   @RequestParam Integer requestUserId);
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer employeeId,
										    @RequestParam Integer requestUserId);
	
}
