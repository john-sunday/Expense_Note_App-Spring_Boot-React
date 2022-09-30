package com.johnsunday.app.service;

import java.util.List;

import com.johnsunday.app.entity.EmployeeType;

public interface IEmployeeTypeService {

	public List<EmployeeType> findAll() throws Exception;
	public EmployeeType findById(Integer id) throws Exception;
	public EmployeeType save(EmployeeType employeeType) throws Exception;
	public EmployeeType update(Integer id,EmployeeType employeeType) throws Exception;
	public Boolean delete(Integer id) throws Exception;
	public EmployeeType findByName(String name);
}
