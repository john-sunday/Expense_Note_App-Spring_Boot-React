package com.johnsunday.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee_payroll")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Audited
public class PayrollEmployee extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@Column(name="payroll_id")
	private Integer payrollId;
	@Column(name="employee_id")
	private Integer employeeId;
}
