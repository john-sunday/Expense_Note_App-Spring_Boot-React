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
import com.johnsunday.app.entity.Payroll;
import com.johnsunday.app.service.PayrollServiceImpl;

@CrossOrigin(origins="*")
@RequestMapping("api/v1/payroll")
@RestController
public class PayrollControllerImpl extends BaseControllerImpl<Payroll, PayrollServiceImpl>
									implements IPayrollController<Payroll,Integer>{
	@Autowired
	private PayrollServiceImpl payrollService;
	
	@Override
	@PostMapping("/")
	@ResponseBody
	public ResponseEntity<?> saveEntity(@RequestBody Payroll payroll) {
		ResponseEntity<Payroll> responseEntity;
		try {
//			Employee employee = payroll.getEmployee();
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(payrollService.save(payroll));			
//			employee.addPayroll(payroll);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible to SAVE the entity.\"}");
		}
		return responseEntity;
	}
	@Override
	@DeleteMapping("/{payrollId}")
	@ResponseBody
	public ResponseEntity<?> deleteEntity(@PathVariable("payrollId") Integer payrollId) {
		ResponseEntity<Boolean> responseEntity;
		try {
//			Payroll payroll = payrollService.findById(payrollId);
//			Employee employee = payroll.getEmployee();
//			employee.removePayroll(payroll);//*********** Check if it allows remove from employee java object before executing in payroll table
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(payrollService.delete(payrollId));			
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible to SAVE the entity.\"}");
		}
		return responseEntity;
	}	
	@Override
	@GetMapping("/employee/{employeeId}")
	@ResponseBody
	public ResponseEntity<?> getAllPayrollByEmployeeId(@PathVariable("employeeId")Integer employeeId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(payrollService.findAllPayrollByEmployeeId(employeeId));			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW the employee's PAYROLLS.\"}");
		}
	}
}
