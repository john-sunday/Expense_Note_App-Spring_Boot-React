package com.johnsunday.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.entity.Payroll;

public class EmployeeMapper {
	
	public static Employee dtoToEmployee(DtoEmployee dtoEmployee) {
		return new Employee(				
				dtoEmployee.getDtoEmployeeName(),
				dtoEmployee.getDtoEmployeeSurname(),
				dtoEmployee.getDtoEmployeeBirthDate(),
				EmployeeTypeMapper.dtoToEmployeeType(dtoEmployee.getDtoEmployeeType()),
				dtoListToExpenseList(dtoEmployee.getDtoExpenses()),
				dtoListToPayrollList(dtoEmployee.getDtoPayrolls())
				);
	}
	
	public static DtoEmployee employeeToDto(Employee employee) {
		return new DtoEmployee(
				employee.getName(),
				employee.getSurname(),
				employee.getBirthDate(),								
				EmployeeTypeMapper.employeeTypeToDto(employee.getEmployeeType()),
				expenseListToDtoList(employee.getExpenses()),
				payrollListToDtoList(employee.getPayrolls())
				);
	}
	
	public static List<Expense> dtoListToExpenseList(List<DtoExpense>dtoExpenseList){
		List<Expense>expenses = new ArrayList<>();
		for (DtoExpense dtoExpense:dtoExpenseList) {
			expenses.add(ExpenseMapper.dtoToExpense(dtoExpense));
		}
		return expenses;
	}
	public static List<DtoExpense> expenseListToDtoList(List<Expense>expenseList){
		List<DtoExpense>dtoExpenses = new ArrayList<>();
		for (Expense expense:expenseList) {
			dtoExpenses.add(ExpenseMapper.expenseToDto(expense));
		}
		return dtoExpenses;
	}
	
	public static List<Payroll> dtoListToPayrollList(List<DtoPayroll>dtoPayrollList){
		List<Payroll>payrolls = new ArrayList<>();
		for (DtoPayroll dtoPayroll:dtoPayrollList) {
			payrolls.add(PayrollMapper.dtoToPayroll(dtoPayroll));
		}
		return payrolls;
	}
	public static List<DtoPayroll> payrollListToDtoList(List<Payroll>payrollList){
		List<DtoPayroll>dtoPayrolls = new ArrayList<>();
		for (Payroll payroll:payrollList) {
			dtoPayrolls.add(PayrollMapper.payrollToDto(payroll));
		}
		return dtoPayrolls;
	}
}
