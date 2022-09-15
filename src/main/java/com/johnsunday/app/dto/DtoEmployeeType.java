package com.johnsunday.app.dto;

import com.johnsunday.app.entity.EmployeeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmployeeType extends EmployeeType{

	private static final long serialVersionUID = 1L;
	private String dtoEmployeeTypeName;
}
