package com.johnsunday.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.service.EmployeeServiceImpl;

@CrossOrigin(origins="*")
@RequestMapping("api/v1/employee")
@RestController
public class EmployeeControllerImpl extends BaseControllerImpl<Employee, EmployeeServiceImpl>{	
	
}
