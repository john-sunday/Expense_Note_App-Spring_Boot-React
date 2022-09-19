package com.johnsunday.app.dto;

import com.johnsunday.app.entity.Payroll;

public class PayrollMapper {
	// Without ID.
	public static Payroll dtoToPayroll(DtoPayroll dtoPayroll) {
		return new Payroll(
				dtoPayroll.getAmount(),
				dtoPayroll.getDate(),
				EmployeeMapper.dtoToEmployeeWithId(dtoPayroll.getDtoEmployee())								
				);
	}	
	public static DtoPayroll payrollToDto(Payroll payroll) {
		return new DtoPayroll(
				payroll.getAmount(),
				payroll.getDate(),
				EmployeeMapper.employeeToDtoWithId(payroll.getEmployee())								
				);
	}
	// With ID.
	public static Payroll dtoToPayrollWithId(DtoPayroll dtoPayroll) {
		return new Payroll(
				dtoPayroll.getId(),
				dtoPayroll.getAmount(),
				dtoPayroll.getDate(),
				EmployeeMapper.dtoToEmployeeWithId(dtoPayroll.getDtoEmployee())								
				);
	}	
	public static DtoPayroll payrollToDtoWithId(Payroll payroll) {
		return new DtoPayroll(
				payroll.getId(),
				payroll.getAmount(),
				payroll.getDate(),
				EmployeeMapper.employeeToDtoWithId(payroll.getEmployee())								
				);
	}
}
