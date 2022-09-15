package com.johnsunday.app.dto;

import java.time.LocalDateTime;

import com.johnsunday.app.entity.Expense;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoExpense extends Expense{
	private static final long serialVersionUID = 1L;

	private String dtoExpenseConcept;
	private String dtoExpenseNote;
	private LocalDateTime dtoExpenseDate;
	private Double dtoExpenseAmount;
	private DtoEmployee dtoEmployee;
}
