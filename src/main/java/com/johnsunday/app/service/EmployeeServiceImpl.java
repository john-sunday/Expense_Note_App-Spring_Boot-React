package com.johnsunday.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnsunday.app.dao.IEmployeeDao;
import com.johnsunday.app.dao.IEmployeeTypeDao;
import com.johnsunday.app.dto.EmployeeDto;
import com.johnsunday.app.dto.EmployeeMapper;
import com.johnsunday.app.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired IEmployeeDao employeeDao;
	@Autowired IEmployeeTypeDao employeeTypeDao;
	
	@Override 
	public EmployeeDto findByNameAndSurnameAllIgnoreCase(String name,String surname) throws Exception {
		Optional<Employee>optionalEmployee  = employeeDao.findByNameAndSurnameAllIgnoreCase(name,surname);
		Employee searchedEmployee = null;
		if (!optionalEmployee.isEmpty()) {
			searchedEmployee = optionalEmployee.get();
		}
		return EmployeeMapper.employeeToDtoWithId(searchedEmployee);		
	}
	@Override
	public List<EmployeeDto> findAll() throws Exception {
		try {
			List<Employee>employees = employeeDao.findAll();
			List<EmployeeDto>dtoEmployees = new ArrayList<>();
			for (Employee e:employees) {
				dtoEmployees.add(EmployeeMapper.employeeToDtoWithId(e));
			}			
			return dtoEmployees;
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public EmployeeDto findById(Integer id) throws Exception {
		try {
			Optional<Employee> optionalEmployee = employeeDao.findById(id);		
			return EmployeeMapper.employeeToDtoWithId(optionalEmployee.get());
		}catch(Exception e) {			
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	@Transactional
	public EmployeeDto save(EmployeeDto dtoEmployee) throws Exception {
		try {
			Employee enteredEmployee = EmployeeMapper.dtoToEmployee(dtoEmployee);
			return EmployeeMapper.employeeToDtoWithId(employeeDao.save(enteredEmployee));			
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	@Transactional
	public EmployeeDto update(Integer id,EmployeeDto dtoEmployee) throws Exception {
		Employee employeeUpdated = null;
		try {
			Employee employeeToUpdate = EmployeeMapper.dtoToEmployeeWithId(dtoEmployee);
			Optional<Employee> optionalEmployee = employeeDao.findById(id);
					
			if(optionalEmployee!=null) {
				employeeUpdated = employeeDao.save(employeeToUpdate);	
			}					
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return EmployeeMapper.employeeToDtoWithId(employeeUpdated);	
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
