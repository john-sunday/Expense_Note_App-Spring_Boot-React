package com.johnsunday.app.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
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
@Table(name="payroll")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Audited
public class Payroll extends BaseEntity {

	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="id")
//	private Integer id;
	@Column(name="amount")
	private Double amount;
	@Column(name="payroll_date")
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime payrollDate;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_employee")
	private Employee employee;
}
