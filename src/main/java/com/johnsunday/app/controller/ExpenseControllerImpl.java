package com.johnsunday.app.controller;

import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.security.entity.Role;
import com.johnsunday.app.security.entity.User;
import com.johnsunday.app.security.service.UserServiceImpl;
import com.johnsunday.app.service.EmployeeServiceImpl;
import com.johnsunday.app.service.ExpenseServiceImpl;

@CrossOrigin(origins="*")
@RequestMapping("api/v1/expense")
@RestController
public class ExpenseControllerImpl implements IExpenseController<Expense> {

	@Autowired private ExpenseServiceImpl expenseService;
	@Autowired private EmployeeServiceImpl employeeService;
	@Autowired UserServiceImpl userService;
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/all")
	public ResponseEntity<?>getAllExpense(@RequestParam("requestUserId")Integer requestUserId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(expenseService.findAll());
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW all expenses\"}");
		}
	}
	@Override
	@PreAuthorize("hasAnyRole('ADMIN_ROLE','USER_ROLE')")
	@GetMapping("/all/{employeeId}")
	//@ResponseBody
	public ResponseEntity<?> getAllExpenseByEmployeeId(@PathVariable("employeeId")Integer employeeId,
											    	   @RequestParam("requestUserId")Integer requestUserId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(expenseService.findAllExpenseByEmployeeId(employeeId));			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW the employee's expenses.\"}");
		}
	}
	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/one/{expenseId}")
	@ResponseBody
	public ResponseEntity<?>getExpenseById(@PathVariable("expenseId")Integer expenseId,
										   @RequestParam("requestUserId")Integer requestUserId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(expenseService.findById(expenseId));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW the expense which you find.\"}");
		}
	}
	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/save")
	//@ResponseBody
	public ResponseEntity<?>saveExpense(@RequestBody @Valid Expense expense,
										@RequestParam("requestUserId")Integer requestUserId) {
		//System.out.println("Save Expense TOKEN TEST Controller ---> " + token);		
		ResponseEntity<?>responseEntity = null;
		try {
			boolean isAdmin = false;
			Employee expenseEmployee = employeeService.findById(expense.getEmployee().getId());
			Optional<User>optRequestUser = userService.findByEmail(expenseEmployee.getEmail());
			Collection<Role>roles = optRequestUser.get().getRoles();
			for (Role role:roles) {
				if (role.getName().equalsIgnoreCase("ROLE_ADMIN")) {
					isAdmin = true;
				}
			}
			if (isAdmin||(!isAdmin&&optRequestUser!=null)) responseEntity = ResponseEntity.status(HttpStatus.OK).body(expenseService.save(expense));						
		}catch(Exception e) {
			e.printStackTrace();
			responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible to SAVE the expense.\"}");
		}
		return responseEntity;
	}
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{expenseId}")
	//@ResponseBody
	public ResponseEntity<?>deleteExpense(@PathVariable("expenseId")Integer expenseId,
										  @RequestParam("requestUserId")Integer userId) {
		ResponseEntity<Boolean> responseEntity;
		try {
			Expense expense = expenseService.findById(expenseId);
			Employee employee = expense.getEmployee();			
			employee.removeExpense(expense);//******** Check if it's allow.......***********
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(expenseService.delete(expenseId));			
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible to SAVE the expense.\"}");
		}
		return responseEntity;
	}
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/update/{expenseId}")	
	public ResponseEntity<?>updateExpense(@PathVariable("expenseId")Integer expenseId, 
										  @RequestBody @Valid Expense expense,
										  @RequestParam("requestUserId")Integer requestUserId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(expenseService.update(expenseId,expense));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible UPDATE the expense which you are looking for.\"}");
		}
	}
}
