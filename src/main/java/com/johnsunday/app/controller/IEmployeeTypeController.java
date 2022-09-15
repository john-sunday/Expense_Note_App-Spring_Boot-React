package com.johnsunday.app.controller;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsunday.app.dto.DtoEmployeeType;
import com.johnsunday.app.entity.BaseEntity;

public interface IEmployeeTypeController<E extends BaseEntity,ID extends Serializable> {

	public ResponseEntity<?> getAllEmployeeType(@RequestParam Integer requestUserId);	
	public ResponseEntity<?> getOneEmployeeType(@PathVariable ID employeeTypeId,
										    	@RequestParam ID requestUserId);
	public ResponseEntity<?> saveEmployeeType(@RequestBody @Valid DtoEmployeeType dtoEmployeeType,
			  						      	  @RequestParam Integer requestUserId);
	public ResponseEntity<?> updateEmployeeType(@PathVariable ID userId,
										        @RequestBody @Valid DtoEmployeeType dtoEmployeeType,
										        @RequestParam ID requestUserId);
	public ResponseEntity<?> deleteEmployeeType(@PathVariable ID employeeTypeId,
										    	@RequestParam ID requestUserId);
	
}
