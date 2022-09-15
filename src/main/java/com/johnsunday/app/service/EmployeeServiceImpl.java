package com.johnsunday.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnsunday.app.dao.IEmployeeDao;
import com.johnsunday.app.entity.Employee;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee,Integer> 
						    	 implements IEmployeeService{
	
	@Autowired IEmployeeDao employeeDao;
	
	@Override 
	public Employee findByNameAndSurnameAllIgnoreCase(String employeeName, String employeeSurname) throws Exception {
		Optional<Employee>optionalEmployee  = employeeDao.findByNameAndSurnameAllIgnoreCase(employeeName, employeeSurname);
		Employee searchedEmployee = null;
		if (!optionalEmployee.isEmpty()) {
			searchedEmployee = optionalEmployee.get();
		}
		return searchedEmployee;
		
	}
}
