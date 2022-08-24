package com.johnsunday.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

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
	@Column(name="type_name",nullable=false)
	@Length(min=3,max=128)
	private String typeName;	
}
