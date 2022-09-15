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

import com.johnsunday.app.dto.DtoEmployee;
import com.johnsunday.app.dto.DtoExpense;
import com.johnsunday.app.dto.EmployeeMapper;
import com.johnsunday.app.dto.ExpenseMapper;
import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.service.EmployeeServiceImpl;
import com.johnsunday.app.service.ExpenseServiceImpl;

@CrossOrigin(origins="*")
@RequestMapping("api/v1/expense")
@RestController
public class ExpenseControllerImpl implements IExpenseController<Expense,Integer>{

	@Autowired private ExpenseServiceImpl expenseService;
	@Autowired private EmployeeServiceImpl employeeService;
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/all")
	public ResponseEntity<?> getAllExpense(@RequestParam("requestUserId")Integer requestUserId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(expenseService.findAll());
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW all expenses\"}");
		}
	}
	@Override
	@PreAuthorize("hasAnyRole('ADMIN_ROLE','USER_ROLE')")
	//@PreAuthorize("hasRole('ROLE_ADMIN')||hasRole('ROLE_USER')")
	@GetMapping("/all/{employeeId}")
	@ResponseBody
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
	public ResponseEntity<?> getOneExpense(@PathVariable("expenseId")Integer expenseId,
										   @RequestParam("requestUserId")Integer requestUserId){
		System.out.println("Request User ID: " + requestUserId);
		try {
			return ResponseEntity.status(HttpStatus.OK).body(expenseService.findById(expenseId));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("401 ******** UNAUTHORIZED ");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW the expense which you find.\"}");
		}
	}
	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/save")
	@ResponseBody
	public ResponseEntity<?> saveExpense(@RequestBody @Valid DtoExpense dtoExpense,
										 @RequestParam("requestUserId") Integer requestUserId) {
		ResponseEntity<Expense> responseEntity = null;
		try {
			DtoEmployee dtoEmployee = dtoExpense.getDtoEmployee();
			Expense enteredExpense = ExpenseMapper.dtoToExpense(dtoExpense);
			// Check the if the expense exists.
			if (expenseService.findByAmountAndExpenseDateAndConceptAndEmployeeIdFk(enteredExpense.getAmount(), 
																				   enteredExpense.getExpenseDate(), 
																				   enteredExpense.getConcept(), 
																				   enteredExpense.getEmployee().getId())) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. The expense you are trying to introduce alredy exists.\"}");
			}
			Employee enteredEmployee = EmployeeMapper.dtoToEmployee(dtoEmployee);
			Employee searchedEmployee = employeeService.findById(enteredEmployee.getId());
//			Employee searchedEmployee = employeeService.findByNameAndSurnameAllIgnoreCase(newEmployee.getName(), newEmployee.getSurname());
			if (searchedEmployee!=null) {
				responseEntity = ResponseEntity.status(HttpStatus.OK).body(expenseService.save(dtoExpense));			
				searchedEmployee.addExpense(ExpenseMapper.dtoToExpense(dtoExpense));
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. The requested resource does NOT exist, and the server does not know if it ever existed.\"}");
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible to SAVE the expense.\"}");
		}
		return responseEntity;
	}
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	// Si no funciona, probar con --> *** @PreAuthorize("hasRole('ADMIN')") ***
	@DeleteMapping("/delete/{expenseId}")
	@ResponseBody
	public ResponseEntity<?> deleteExpense(@PathVariable("expenseId")Integer expenseId,
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
	@PutMapping("/{id}")	
	public ResponseEntity<?> updateExpense(@PathVariable("expenseId")Integer expenseId, 
										   @RequestBody @Valid DtoExpense dtoExpense,
										   @RequestParam("requestUserId")Integer requestUserId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(expenseService.update(expenseId, ExpenseMapper.dtoToExpense(dtoExpense)));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible UPDATE the expense which you are looking for.\"}");
		}
	}
}
