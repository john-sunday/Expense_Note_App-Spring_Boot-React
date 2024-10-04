package com.johnsunday.app.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IEmployeeTypeController<EmployeeType> {

	public ResponseEntity<?> getAllEmployeeType();

	public ResponseEntity<?> getEmployeeTypeById(@PathVariable Integer employeeTypeId);

	public ResponseEntity<?> saveEmployeeType(@RequestBody @Valid EmployeeType employeeType);

	public ResponseEntity<?> updateEmployeeType(@RequestBody @Valid EmployeeType employeeType,
			@PathVariable Integer employeeTypeId);

	public ResponseEntity<?> deleteEmployeeType(@PathVariable Integer employeeTypeId);
}
