package com.johnsunday.app.controller;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsunday.app.dto.DtoPayroll;
import com.johnsunday.app.entity.BaseEntity;

public interface IPayrollController<E extends BaseEntity,ID extends Serializable> {

	public ResponseEntity<?> getAllPayrollByEmployeeId(@PathVariable ID employeeId,													   
													   @RequestParam ID requestUserId);
	public ResponseEntity<?> getAllPayroll(@RequestParam Integer requestUserId);	
	public ResponseEntity<?> getOnePayroll(@PathVariable ID payrollId,
										   @RequestParam ID requestUserId);
	public ResponseEntity<?> savePayroll(@RequestBody @Valid DtoPayroll dtoPayroll,
			  						     @RequestParam Integer requestUserId);
	public ResponseEntity<?> updatePayroll(@PathVariable ID userId,
										   @RequestBody @Valid DtoPayroll dtoPayroll,
										   @RequestParam ID requestUserId);
	public ResponseEntity<?> deletePayroll(@PathVariable ID payrollId,
										   @RequestParam ID requestUserId);
}
