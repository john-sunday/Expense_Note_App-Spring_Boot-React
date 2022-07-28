package com.johnsunday.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="payroll")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payroll extends BaseEntity {

	@Column(name="amount")
	private Double amount;
	@Column(name="payroll_date")
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime payrollDate;
	@Column(name="id_employee")
	private Employee employee;
}
