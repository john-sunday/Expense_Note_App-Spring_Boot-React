package com.johnsunday.app.dto;

import java.time.LocalDateTime;

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
public class PayrollDto extends Payroll {

	private static final long serialVersionUID = 1L;
	private Integer id;
	@NonNull
	private Double amount;
	@NonNull
	private LocalDateTime date;
	@NonNull
	private EmployeeDto employeeDto;
}
