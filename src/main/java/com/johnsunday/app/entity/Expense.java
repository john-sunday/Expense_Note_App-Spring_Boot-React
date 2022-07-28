package com.johnsunday.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="expense")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense extends BaseEntity {

	@Column(name="concept")
	private String concept;
	@Column(name="note")
	private String note;
	@Column(name="expense_date")
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime expenseDate;
	@Column(name="amount")
	private Double amount;
	@Column(name="id_employee")
	private Employee employee;
	
}
