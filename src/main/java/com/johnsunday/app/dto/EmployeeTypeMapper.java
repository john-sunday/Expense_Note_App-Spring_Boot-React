package com.johnsunday.app.dto;

import com.johnsunday.app.entity.EmployeeType;

public class EmployeeTypeMapper {
	
	public static EmployeeType dtoToEmployeeType(DtoEmployeeType dtoEmployeeType) {
		return new EmployeeType(				
				dtoEmployeeType.getDtoEmployeeTypeName()				 					
				);
	}
	
	public static DtoEmployeeType employeeTypeToDto(EmployeeType employeeType) {
		return new DtoEmployeeType(					
				employeeType.getTypeName()						 					
				);
	}
}
