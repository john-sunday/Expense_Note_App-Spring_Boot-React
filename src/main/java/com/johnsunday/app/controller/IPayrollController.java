package com.johnsunday.app.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public interface IPayrollController<Payroll> {

	public ResponseEntity<?> getAllPayrollByEmployeeId(@PathVariable Integer employeeId);
	public ResponseEntity<?> getAllPayroll();	
	public ResponseEntity<?> getPayrollById(@PathVariable Integer payrollId);
	public ResponseEntity<?> savePayroll(@RequestBody @Valid Payroll payroll);
	public ResponseEntity<?> updatePayroll(@RequestBody @Valid Payroll payroll,
										   @PathVariable Integer payrollId);
	public ResponseEntity<?> deletePayroll(@PathVariable Integer payrollId);
}
