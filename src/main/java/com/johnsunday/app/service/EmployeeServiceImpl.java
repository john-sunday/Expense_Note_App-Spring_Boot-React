package com.johnsunday.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnsunday.app.dao.IEmployeeDao;
import com.johnsunday.app.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired IEmployeeDao employeeDao;
	
	@Override 
	public Employee findByNameAndSurnameAllIgnoreCase(String name,String surname) throws Exception {
		Optional<Employee>optionalEmployee  = employeeDao.findByNameAndSurnameAllIgnoreCase(name,surname);
		Employee searchedEmployee = null;
		if (!optionalEmployee.isEmpty()) {
			searchedEmployee = optionalEmployee.get();
		}
		return searchedEmployee;
		
	}
	@Override
	public List<Employee> findAll() throws Exception {
		try {
			return employeeDao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public Employee findById(Integer id) throws Exception {
		try {
			Optional<Employee> optionalEmployee = employeeDao.findById(id);
			return optionalEmployee.get();
		}catch(Exception e) {			
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	@Transactional
	public Employee save(Employee employee) throws Exception {
		try {
			Employee newEmployee = employeeDao.save(employee);
			return newEmployee;
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	@Transactional
	public Employee update(Integer id,Employee employee) throws Exception {
		Employee employeeUpdated = null;
		try {
			Optional<Employee> optionalEmployee = employeeDao.findById(id);
			Employee oldEmployee = optionalEmployee.get();			
			if(oldEmployee!=null) {
				employeeUpdated = employeeDao.save(employee);	
			}					
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return employeeUpdated;	
	}
	@Override
	@Transactional
	public Boolean delete(Integer id) throws Exception {
		boolean isDeleted = false;
		try {
			if(employeeDao.existsById(id)) {
				employeeDao.deleteById(id);
				isDeleted = true;
			} else {
				throw new Exception();
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return isDeleted;
	}
}
