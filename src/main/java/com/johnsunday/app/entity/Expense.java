package com.johnsunday.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
//@Audited
public class Expense extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="expense_id")
	private Integer expenseId;
	@Column(name="concept")
	private String concept;
	@Column(name="note")
	private String note;
	@Column(name="expense_date")
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime expenseDate;
	@Column(name="amount")
	private Double amount;
	@ManyToOne
	@JoinColumn(name="employee_id_fk")
	private Employee employee;
	
}
