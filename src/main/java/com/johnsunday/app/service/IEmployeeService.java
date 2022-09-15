package com.johnsunday.app.service;

import com.johnsunday.app.entity.Employee;

public interface IEmployeeService extends IBaseService<Employee,Integer> {

	public Employee findByNameAndSurnameAllIgnoreCase(String employeeName,String employeeSurname) throws Exception;
}
