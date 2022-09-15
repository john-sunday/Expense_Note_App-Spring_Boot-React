package com.johnsunday.app.controller;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsunday.app.dto.DtoEmployee;
import com.johnsunday.app.entity.BaseEntity;

public interface IEmployeeController<E extends BaseEntity,ID extends Serializable> {

	public ResponseEntity<?> getAllEmployee(@RequestParam Integer requestUserId);	
	public ResponseEntity<?> getOneEmployee(@PathVariable ID employeeId,
										    @RequestParam ID requestUserId);
	public ResponseEntity<?> saveEmployee(@RequestBody @Valid DtoEmployee dtoEmployee,
			  						      @RequestParam Integer requestUserId);
	public ResponseEntity<?> updateEmployee(@PathVariable ID userId,
										   @RequestBody @Valid DtoEmployee dtoEmployee,
										   @RequestParam ID requestUserId);
	public ResponseEntity<?> deleteEmployee(@PathVariable ID employeeId,
										    @RequestParam ID requestUserId);
	
}
