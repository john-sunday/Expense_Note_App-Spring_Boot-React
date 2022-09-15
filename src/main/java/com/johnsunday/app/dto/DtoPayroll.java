package com.johnsunday.app.dto;

import java.time.LocalDateTime;

import com.johnsunday.app.entity.Payroll;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoPayroll extends Payroll{

	private static final long serialVersionUID = 1L;
	private Double dtoPayrollAmount;
	private LocalDateTime dtoPayrollDate;
	private DtoEmployee dtoEmployee;
}
