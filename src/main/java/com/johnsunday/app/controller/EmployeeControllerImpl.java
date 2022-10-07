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

import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.service.EmployeeServiceImpl;

@CrossOrigin(origins="*")
@RequestMapping("api/v1/employee")
@RestController
public class EmployeeControllerImpl implements IEmployeeController {
	
	@Autowired EmployeeServiceImpl employeeService;
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/all")	
	public ResponseEntity<?> getAllEmployee(@RequestParam("requestUserId")Integer requestUserId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll());
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. It is NOT possible to SHOW all employees\"}");
		}
	}
	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/one/{employeeId}")
	@ResponseBody
	public ResponseEntity<?> getEmployeeById(@PathVariable("employeeId")Integer employeeId,
										     @RequestParam("requestUserId")Integer requestUserId){
		//System.out.println("Request User ID: " + requestUserId);
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(employeeId));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW the payroll which you find.\"}");
		}
	}
	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/save")
	@ResponseBody
	public ResponseEntity<?> saveEmployee(@RequestBody @Valid Employee employee,
										  @RequestParam("requestUserId")Integer requestUserId) {
		try {		
			return ResponseEntity.status(HttpStatus.OK).body(employeeService.save(employee));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. It is NOT possible to SAVE the employee.\"}");
		}
	}
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{employeeId}")
	@ResponseBody
	public ResponseEntity<?> deleteEmployee(@PathVariable("employeeId")Integer employeeId,
										    @RequestParam("requestUserId")Integer requestUserId) {		
		try {			
			return ResponseEntity.status(HttpStatus.OK).body(employeeService.delete(employeeId));			
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. It is NOT possible to DELETE the employee.\"}");
		}
	}
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/update/{employeeId}")
	public ResponseEntity<?> updateEmployee(@PathVariable("employeeId")Integer employeeId, 
										    @RequestBody @Valid Employee employee,
										    @RequestParam("requestUserId")Integer requestUserId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeService.update(employeeId,employee));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. It is NOT possible UPDATE the employee who you are looking for.\"}");
		}
	}
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/one/{name}/{surname}")
	public ResponseEntity<?> getUserByNameAndSurname(@PathVariable("name")String name,
													 @PathVariable("surname")String surname,
													 @RequestParam("requestUserId")Integer requestUserId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeService.findByNameAndSurnameAllIgnoreCase(name,surname));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. It is NOT possible to FIND the employee who you are looking for.\"}");
		}
	}
	
}
