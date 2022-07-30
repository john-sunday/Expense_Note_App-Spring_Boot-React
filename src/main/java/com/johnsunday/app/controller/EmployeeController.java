package com.johnsunday.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.service.EmployeeServiceImpl;

@CrossOrigin("*")
@RequestMapping("api/v1/employee")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@GetMapping("/")
	public ResponseEntity<?> getAllEmployees(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll());
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW all the employees\"}");
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneEmployee(@PathVariable("id")Integer id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(id));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW the employee who you find.\"}");
		}
	}
	@PostMapping("/")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeService.save(employee));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible to SAVE the employee.\"}");
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable("id")Integer id, @RequestBody Employee employee){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeService.update(id, employee));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible UPDATE the employee.\"}");
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id")Integer id){
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(employeeService.delete(id));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. Not possible show the employee who you find.\"}");
		}
	}
}
