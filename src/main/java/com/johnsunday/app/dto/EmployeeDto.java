package com.johnsunday.app.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.johnsunday.app.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class EmployeeDto extends Employee{

	private static final long serialVersionUID = 1L;
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private String surname;
	@NonNull
	private LocalDateTime birthDate;
	@NonNull
	private EmployeeTypeDto dtoEmployeeType;
	private List<ExpenseDto>dtoExpenses;
	private List<PayrollDto>dtoPayrolls;
	
	// Constructor without id.
	public EmployeeDto(String name,String surname,LocalDateTime birthDate,EmployeeTypeDto dtoEmployeeType,List<ExpenseDto>dtoExpenses,List<PayrollDto>dtoPayrolls) {
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.dtoEmployeeType = dtoEmployeeType;
		this.dtoExpenses = dtoExpenses;
		this.dtoPayrolls = dtoPayrolls;
	}
}
