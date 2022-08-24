package com.johnsunday.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

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
	@Column(name="concept",nullable=false)
	@Length(min=3,max=128)
	private String concept;
	@Column(name="note",nullable=false)
	@Length(min=3,max=255)
	private String note;
	@Column(name="expense_date",nullable=false)
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime expenseDate;
	@Column(name="amount",nullable=false)
	private Double amount;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id_fk")
	//@JsonIgnore
	private Employee employee;	
}
