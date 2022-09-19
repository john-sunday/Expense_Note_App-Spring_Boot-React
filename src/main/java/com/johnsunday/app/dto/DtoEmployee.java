package com.johnsunday.app.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.EmployeeType;
import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.entity.Payroll;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class DtoEmployee extends Employee{

	private static final long serialVersionUID = 1L;
	private Integer dtoEmployeeId;
	@NonNull
	private String dtoEmployeeName;
	@NonNull
	private String dtoEmployeeSurname;
	@NonNull
	private LocalDateTime dtoEmployeeBirthDate;
	@NonNull
	private DtoEmployeeType dtoEmployeeType;
	private List<DtoExpense>dtoExpenses;
	private List<DtoPayroll>dtoPayrolls;
	
	// Constructor without id.
	public DtoEmployee(String dtoEmployeeName,String dtoEmployeeSurname,LocalDateTime dtoEmployeeBirthDate,DtoEmployeeType dtoEmployeeType,List<DtoExpense>dtoExpenses,List<DtoPayroll>dtoPayrolls) {
		this.dtoEmployeeName = dtoEmployeeName;
		this.dtoEmployeeSurname = dtoEmployeeSurname;
		this.dtoEmployeeBirthDate = dtoEmployeeBirthDate;
		this.dtoEmployeeType = dtoEmployeeType;
		this.dtoExpenses = dtoExpenses;
		this.dtoPayrolls = dtoPayrolls;
	}
}
