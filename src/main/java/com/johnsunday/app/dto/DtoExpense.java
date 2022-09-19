package com.johnsunday.app.dto;

import java.time.LocalDateTime;

import com.johnsunday.app.entity.Expense;

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
public class DtoExpense extends Expense{
	
	private static final long serialVersionUID = 1L;
	private Integer dtoExpenseId;
	@NonNull
	private String dtoExpenseConcept;
	@NonNull
	private String dtoExpenseNote;
	@NonNull
	private LocalDateTime dtoExpenseDate;
	@NonNull
	private Double dtoExpenseAmount;
	@NonNull
	private DtoEmployee dtoEmployee;
}
