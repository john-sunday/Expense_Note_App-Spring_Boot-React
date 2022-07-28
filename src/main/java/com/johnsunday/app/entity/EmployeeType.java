package com.johnsunday.app.entity;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeType extends BaseEntity {

	@Column(name="type_name")
	private String typeName;
	
	
}
