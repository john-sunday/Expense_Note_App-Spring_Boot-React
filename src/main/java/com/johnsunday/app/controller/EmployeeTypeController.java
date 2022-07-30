package com.johnsunday.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnsunday.app.entity.EmployeeType;
import com.johnsunday.app.service.EmployeeTypeServiceImpl;

@CrossOrigin(origins="*")
@RequestMapping("api/v1/employee_type")
@RestController
public class EmployeeTypeController extends BaseControllerImpl<EmployeeType, EmployeeTypeServiceImpl>{

}
