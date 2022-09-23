package com.johnsunday.app.service;

import java.util.List;

import com.johnsunday.app.entity.Employee;

public interface IEmployeeService {
	public List<Employee> findAll() throws Exception;
	public Employee findById(Integer id) throws Exception;
	public Employee save(Employee employee) throws Exception;
	public Employee update(Integer id,Employee employee) throws Exception;
	public Boolean delete(Integer id) throws Exception;
	public Employee findByNameAndSurnameAllIgnoreCase(String employeeName,String employeeSurname) throws Exception;
}
