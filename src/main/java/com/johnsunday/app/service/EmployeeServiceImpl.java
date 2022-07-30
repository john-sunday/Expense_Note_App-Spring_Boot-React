package com.johnsunday.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnsunday.app.dao.IEmployeeDao;
import com.johnsunday.app.entity.Employee;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee,Integer> {

	@Autowired
	private IEmployeeDao employeeDao;
	
}
