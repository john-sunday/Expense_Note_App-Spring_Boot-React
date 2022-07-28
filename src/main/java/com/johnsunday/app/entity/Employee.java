package com.johnsunday.app.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseEntity {
	
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="birth_date")
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime birthDate;
	@Column(name="id_employee_type")
	private EmployeeType employeeType;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Expense>expenses;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Payroll>payrolls;
}
