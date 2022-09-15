package com.johnsunday.app.dto;

import com.johnsunday.app.entity.Payroll;

public class PayrollMapper {
	
	public static Payroll dtoToPayroll(DtoPayroll dtoPayroll) {
		return new Payroll(
				dtoPayroll.getDtoPayrollAmount(),
				dtoPayroll.getDtoPayrollDate(),
				EmployeeMapper.dtoToEmployee(dtoPayroll.getDtoEmployee())								
				);
	}
	
	public static DtoPayroll payrollToDto(Payroll payroll) {
		return new DtoPayroll(
				payroll.getAmount(),
				payroll.getPayrollDate(),
				EmployeeMapper.employeeToDto(payroll.getEmployee())								
				);
	}
}
