package com.johnsunday.app.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.johnsunday.app.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmployee extends Employee{

	private static final long serialVersionUID = 1L;
	private String dtoEmployeeName;
	private String dtoEmployeeSurname;
	private LocalDateTime dtoEmployeeBirthDate;
	private DtoEmployeeType dtoEmployeeType;
	private List<DtoExpense>dtoExpenses;
	private List<DtoPayroll>dtoPayrolls;
}
