package com.johnsunday.app.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name="amount")
	private Double amount;
	@Column(name="payroll_date")
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime payrollDate;
	@ManyToOne(optional=false,cascade= {CascadeType.MERGE, CascadeType.REMOVE,
            CascadeType.REFRESH, CascadeType.DETACH} ,fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id_fk")
	//@JsonIgnore
	private Employee employee;
}
