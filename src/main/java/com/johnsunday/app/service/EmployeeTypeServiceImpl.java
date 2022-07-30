package com.johnsunday.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.johnsunday.app.dao.IEmployeeTypeDao;
import com.johnsunday.app.entity.EmployeeType;

@Service
public class EmployeeTypeServiceImpl extends BaseServiceImpl<EmployeeType,Integer> {

	@Autowired
	private IEmployeeTypeDao employeeTypeDao;	
}
