package com.johnsunday.app.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public interface IPayrollController<Payroll> {

	public ResponseEntity<?> getAllPayrollByEmployeeId(@PathVariable Integer employeeId,													   
													   @RequestParam Integer requestUserId);
	public ResponseEntity<?> getAllPayroll(@RequestParam Integer requestUserId);	
	public ResponseEntity<?> getPayrollById(@PathVariable Integer payrollId,
										    @RequestParam Integer requestUserId);
	public ResponseEntity<?> savePayroll(@RequestBody @Valid Payroll payroll,
			  						     @RequestParam Integer requestUserId);
	public ResponseEntity<?> updatePayroll(@PathVariable Integer payrollId,
										   @RequestBody @Valid Payroll payroll,
										   @RequestParam Integer requestUserId);
	public ResponseEntity<?> deletePayroll(@PathVariable Integer payrollId,
										   @RequestParam Integer requestUserId);
}
