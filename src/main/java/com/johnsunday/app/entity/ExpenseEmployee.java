package com.johnsunday.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee_expense")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Audited
public class ExpenseEmployee extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@Column(name="expense_id")
	private Integer expenseId;
	@Column(name="employee_id")
	private Integer employeeId;
}
