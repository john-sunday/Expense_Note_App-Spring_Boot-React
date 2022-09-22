package com.johnsunday.app.service;

import java.util.List;

import com.johnsunday.app.dto.EmployeeDto;
import com.johnsunday.app.entity.Employee;

public interface IEmployeeService {
	public List<EmployeeDto> findAll() throws Exception;
	public EmployeeDto findById(Integer id) throws Exception;
	public EmployeeDto save(EmployeeDto dtoEmployee) throws Exception;
	public EmployeeDto update(Integer id,EmployeeDto dtoEmployee) throws Exception;
	public Boolean delete(Integer id) throws Exception;
	public EmployeeDto findByNameAndSurnameAllIgnoreCase(String employeeName,String employeeSurname) throws Exception;
}
