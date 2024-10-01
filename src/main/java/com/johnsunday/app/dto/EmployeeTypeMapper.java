package com.johnsunday.app.dto;

import com.johnsunday.app.entity.EmployeeType;

public class EmployeeTypeMapper {
	// Without ID.
	public static EmployeeType dtoToEmployeeType(EmployeeTypeDto dtoEmployeeType) {
		return new EmployeeType(				
				dtoEmployeeType.getName()				 					
				);
	}
	public static EmployeeTypeDto employeeTypeToDto(EmployeeType employeeType) {
		return new EmployeeTypeDto(					
				employeeType.getName()						 					
				);
	}
	
	// With ID.
	public static EmployeeType dtoToEmployeeTypeWithId(EmployeeTypeDto dtoEmployeeType) {
		return new EmployeeType(
				dtoEmployeeType.getId(),
				dtoEmployeeType.getName()				 					
				);
	}
	public static EmployeeTypeDto employeeTypeToDtoWithId(EmployeeType employeeType) {
		return new EmployeeTypeDto(
				employeeType.getId(),
				employeeType.getName()						 					
				);
	}
}
