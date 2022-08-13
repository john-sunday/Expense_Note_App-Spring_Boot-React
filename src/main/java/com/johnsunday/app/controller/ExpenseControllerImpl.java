package com.johnsunday.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.entity.ExpenseEmployee;
import com.johnsunday.app.service.ExpenseEmployeeServiceImpl;
import com.johnsunday.app.service.ExpenseServiceImpl;

@CrossOrigin(origins="*")
@RequestMapping("api/v1/expense")
@RestController
public class ExpenseControllerImpl extends BaseControllerImpl<Expense, ExpenseServiceImpl>
									implements IExpenseController<Expense,Integer>{

	@Autowired
	ExpenseServiceImpl expenseService;
	@Autowired
	ExpenseEmployeeServiceImpl expenseEmployeeService; 
	
	@Override
	@GetMapping("/employee/{id}")
	@ResponseBody
	public ResponseEntity<?> getAllExpenseByEmployeeId(@PathVariable("id")Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(expenseService.findExpenseByEmployeeId(id));			
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
			System.out.println("@Override method ExpenseServiceImpl");
			Employee employee = expense.getEmployee();
//			employee.addExpense(expense);

			responseEntity = ResponseEntity.status(HttpStatus.OK).body(expenseService.save(expense));
			expenseEmployeeService.save(new ExpenseEmployee(responseEntity.getBody().getId(),employee.getId()));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible to SAVE the entity.\"}");
		}
		return responseEntity;
	}

//	@Override
//	@PostMapping("/addlist/")
//	@ResponseBody
//	public ResponseEntity<?> saveExpenseEmployee(@RequestBody Expense expense) {
//		try {
//			System.out.println("@Override method to save Expense in Employee List<Expense>");
//			return ResponseEntity.status(HttpStatus.OK).body(expenseService.saveEmployeeExpense(expense));			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"**** Error. Please, Try it later. NOT possible to SHOW the employee's EXPENSES.\"}");
//		}
//	}
	
}
