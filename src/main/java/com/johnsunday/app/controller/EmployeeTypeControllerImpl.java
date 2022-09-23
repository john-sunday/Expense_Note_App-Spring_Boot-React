package com.johnsunday.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.johnsunday.app.entity.EmployeeType;
import com.johnsunday.app.service.EmployeeTypeServiceImpl;

@CrossOrigin(origins="*")
@RequestMapping("api/v1/employee_type")
@RestController
public class EmployeeTypeControllerImpl implements IEmployeeTypeController<EmployeeType> {

	
	@Autowired
	private EmployeeTypeServiceImpl employeeTypeService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/all")	
	public ResponseEntity<?> getAllEmployeeType(@RequestParam("requestUserId")Integer requestUserId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeTypeService.findAll());
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. It is NOT possible to SHOW all employee types\"}");
		}
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/one/{employeeTypeId}")
	@ResponseBody
	public ResponseEntity<?> getOneEmployeeType(@PathVariable("employeeTypeId")Integer employeeTypeId,
										        @RequestParam("requestUserId")Integer requestUserId){
		System.out.println("Request User ID: " + requestUserId);
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeTypeService.findById(employeeTypeId));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("401 ******** UNAUTHORIZED ");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW the employee type which you find.\"}");
		}
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/save")
	@ResponseBody
	public ResponseEntity<?> saveEmployeeType(@RequestBody @Valid EmployeeType employeeType,
										 	  @RequestParam("requestUserId") Integer requestUserId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeTypeService.save(employeeType));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. It is NOT possible to SAVE the employee type.\"}");
		}
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{employeeTypeId}")
	@ResponseBody
	public ResponseEntity<?> deleteEmployeeType(@PathVariable("employeeTypeId")Integer employeeTypeId,
										   		@RequestParam("requestUserId")Integer requestUserId) {
		try {						
			return ResponseEntity.status(HttpStatus.OK).body(employeeTypeService.delete(employeeTypeId));			
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. It is NOT possible to DELETE the employee type.\"}");
		}
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PutMapping("/update/{employeeTypeId}")	
	public ResponseEntity<?> updateEmployeeType(@PathVariable("employeeTypeId")Integer employeeTypeId, 
										   		@RequestBody @Valid EmployeeType employeeType,
										   		@RequestParam("requestUserId")Integer requestUserId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeTypeService.update(employeeTypeId,employeeType));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. It is NOT possible UPDATE the employee type which you are looking for.\"}");
		}
	}
}
