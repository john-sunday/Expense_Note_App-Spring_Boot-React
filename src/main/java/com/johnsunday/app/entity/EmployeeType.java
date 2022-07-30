package com.johnsunday.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Audited
public class EmployeeType extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_type_id")
	private Integer employeeTypeId;
	@Column(name="type_name")
	private String typeName;	
}
