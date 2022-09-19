package com.johnsunday.app.dto;

import com.johnsunday.app.entity.EmployeeType;

public class EmployeeTypeMapper {
	// Without ID.
	public static EmployeeType dtoToEmployeeType(DtoEmployeeType dtoEmployeeType) {
		return new EmployeeType(				
				dtoEmployeeType.getName()				 					
				);
	}
	public static DtoEmployeeType employeeTypeToDto(EmployeeType employeeType) {
		return new DtoEmployeeType(					
				employeeType.getName()						 					
				);
	}
	
	// With ID.
	public static EmployeeType dtoToEmployeeTypeWithId(DtoEmployeeType dtoEmployeeType) {
		return new EmployeeType(
				dtoEmployeeType.getId(),
				dtoEmployeeType.getName()				 					
				);
	}
	public static DtoEmployeeType employeeTypeToDtoWithId(EmployeeType employeeType) {
		return new DtoEmployeeType(
				employeeType.getId(),
				employeeType.getName()						 					
				);
	}
}
