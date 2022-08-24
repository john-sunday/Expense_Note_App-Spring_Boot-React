package com.johnsunday.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.service.ExpenseServiceImpl;

@CrossOrigin(origins="*")
@RequestMapping("api/v1/expense")
@RestController
public class ExpenseControllerImpl extends BaseControllerImpl<Expense, ExpenseServiceImpl>
									implements IExpenseController<Expense,Integer>{

	@Autowired
	private ExpenseServiceImpl expenseService;
	
	@Override
	@GetMapping("/employee/{employeeId}")
	@ResponseBody
	public ResponseEntity<?> getAllExpenseByEmployeeId(@PathVariable("employeeId")Integer employeeId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(expenseService.findAllExpenseByEmployeeId(employeeId));			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW the employee's EXPENSES.\"}");
		}
	}
	@Override
	@PostMapping("/")
	@ResponseBody
	public ResponseEntity<?> saveEntity(@RequestBody Expense expense) {
		ResponseEntity<Expense> responseEntity;
		try {
			Employee employee = expense.getEmployee();
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(expenseService.save(expense));
			employee.addExpense(expense);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible to SAVE the entity.\"}");
		}
		return responseEntity;
	}
	@Override
	@DeleteMapping("/{expenseId}")
	@ResponseBody
	public ResponseEntity<?> deleteEntity(@PathVariable("expenseId") Integer expenseId) {
		ResponseEntity<Boolean> responseEntity;
		try {
			Expense expense = expenseService.findById(expenseId);
			Employee employee = expense.getEmployee();	
			employee.removeExpense(expense);//******** Check if it's allow.......***********
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(expenseService.delete(expenseId));			
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible to SAVE the entity.\"}");
		}
		return responseEntity;
	}
}
