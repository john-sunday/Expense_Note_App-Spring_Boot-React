package com.johnsunday.app.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.service.EmployeeServiceImpl;

public class EmployeeUtil {

	@Autowired private static EmployeeServiceImpl employeeService;
	
	public static Boolean existsEmployeeInDb(Employee employee) {
		boolean exists = false;
		try {
			if ((employeeService.findById(employee.getId()))!=null) {				
				exists = true;
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return exists;
	}
}
