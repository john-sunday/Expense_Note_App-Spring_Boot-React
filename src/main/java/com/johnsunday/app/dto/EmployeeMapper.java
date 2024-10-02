package com.johnsunday.app.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.EmployeeType;
import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.entity.Payroll;

public class EmployeeMapper {
	// 1 - With ID.
		// A - DTO to Employee.
	public static Employee dtoToEmployeeWithId(EmployeeDto dtoEmployee) {
		if (isNullList(dtoEmployee.getDtoExpenses())) {			
			dtoEmployee.setDtoExpenses(initializeDtoExpenseList(dtoEmployee.getDtoExpenses()));
		}
		if (isNullList(dtoEmployee.getDtoPayrolls())) {			
			dtoEmployee.setDtoPayrolls(initializeDtoPayrollList(dtoEmployee.getDtoPayrolls()));
		}
					/* 		public Employee(String name,String surname,LocalDateTime birthDate,
					EmployeeType employeeType,String email,
					List<Expense>expenses,List<Payroll>payrolls) { */
		return new Employee(
				dtoEmployee.getId(),
				dtoEmployee.getName(),
				dtoEmployee.getSurname(),
				dtoEmployee.getBirthDate(),				
				EmployeeTypeMapper.dtoToEmployeeType(dtoEmployee.getDtoEmployeeType()),
				dtoEmployee.getEmail(),
				dtoListToExpenseList(dtoEmployee.getDtoExpenses()),
				dtoListToPayrollList(dtoEmployee.getDtoPayrolls())
				);
	}

		// B - Employee to DTO.
	public static EmployeeDto employeeToDtoWithId(Employee employee) {
		if (isNullList(employee.getExpenses())) {			
			employee.setExpenses(initializeExpenseList(employee.getExpenses()));
		}
		if (isNullList(employee.getPayrolls())) {			
			employee.setPayrolls(initializePayrollList(employee.getPayrolls()));
		}
		return new EmployeeDto(
				employee.getId(),
				employee.getName(),
				employee.getSurname(),
				employee.getBirthDate(),								
				EmployeeTypeMapper.employeeTypeToDtoWithId(employee.getEmployeeType()),
				expenseListToDtoList(employee.getExpenses()),
				payrollListToDtoList(employee.getPayrolls())
				);
	}
	// 2 - Without ID.
		// A - DTO to Employee.
	public static Employee dtoToEmployee(EmployeeDto dtoEmployee) {
		if (isNullList(dtoEmployee.getDtoExpenses())) {			
			dtoEmployee.setDtoExpenses(initializeDtoExpenseList(dtoEmployee.getDtoExpenses()));
		}
		if (isNullList(dtoEmployee.getDtoPayrolls())) {			
			dtoEmployee.setDtoPayrolls(initializeDtoPayrollList(dtoEmployee.getDtoPayrolls()));
		}
		EmployeeType employeeType = EmployeeTypeMapper.dtoToEmployeeTypeWithId(dtoEmployee.getDtoEmployeeType());
		return new Employee(
				dtoEmployee.getName(),
				dtoEmployee.getSurname(),
				dtoEmployee.getBirthDate(),
				employeeType,
				dtoEmployee.getEmail(), 
				dtoListToExpenseList(dtoEmployee.getDtoExpenses()),
				dtoListToPayrollList(dtoEmployee.getDtoPayrolls())
				);
	}
		// B - Employee to DTO.
	public static EmployeeDto employeeToDto(Employee employee) {
		return new EmployeeDto(
				employee.getName(),
				employee.getSurname(),
				employee.getBirthDate(),								
				EmployeeTypeMapper.employeeTypeToDto(employee.getEmployeeType())
				);
	}
	private static Boolean isNullList(List<?>list) {
		boolean isNull = false;
		if (list == null) isNull = true;
		return isNull;
	}
	private static Boolean isEmptyList(List<?>list) {
		boolean isEmpty = false;
		if (list.size()==0) isEmpty = true;
		return isEmpty;
	}
	private static List<ExpenseDto> initializeDtoExpenseList(List<ExpenseDto>list) {
		return list = new ArrayList<>();
	}
	private static List<Expense> initializeExpenseList(List<Expense>list) {
		return list = new ArrayList<>();
	}
	private static List<PayrollDto> initializeDtoPayrollList(List<PayrollDto>list) {
		return list = new ArrayList<>();
	}
	private static List<Payroll> initializePayrollList(List<Payroll>list) {
		return list = new ArrayList<>();
	}
	
	// A - Expense/DTO lists.
	private static List<Expense> dtoListToExpenseList(List<ExpenseDto>dtoExpenseList){
		List<Expense>expenses = new ArrayList<>();
		for (ExpenseDto dtoExpense:dtoExpenseList) {
			expenses.add(ExpenseMapper.dtoToExpense(dtoExpense));
		}
		return expenses;
	}
	private static List<ExpenseDto> expenseListToDtoList(List<Expense>expenseList){
		List<ExpenseDto>dtoExpenses = new ArrayList<>();
		for (Expense expense:expenseList) {
			dtoExpenses.add(ExpenseMapper.expenseToDto(expense));
		}
		return dtoExpenses;
	}
	// B - Payroll/DTO lists.
	private static List<Payroll> dtoListToPayrollList(List<PayrollDto>dtoPayrollList){
		List<Payroll>payrolls = new ArrayList<>();
		for (PayrollDto dtoPayroll:dtoPayrollList) {
			payrolls.add(PayrollMapper.dtoToPayroll(dtoPayroll));
		}
		return payrolls;
	}
	private static List<PayrollDto> payrollListToDtoList(List<Payroll>payrollList){
		List<PayrollDto>dtoPayrolls = new ArrayList<>();
		for (Payroll payroll:payrollList) {
			dtoPayrolls.add(PayrollMapper.payrollToDto(payroll));
		}
		return dtoPayrolls;
	}
}
