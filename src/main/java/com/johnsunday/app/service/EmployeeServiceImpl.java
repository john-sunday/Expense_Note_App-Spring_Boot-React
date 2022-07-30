package com.johnsunday.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.johnsunday.app.dao.IEmployeeDao;
import com.johnsunday.app.entity.Employee;

@Repository
public class EmployeeServiceImpl implements IBaseService<Employee> {

	@Autowired
	private IEmployeeDao employeeDao;
	
	@Override
	@Transactional
	public List<Employee> findAll() throws Exception {
		try {
			return employeeDao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}		
	}
	@Override
	@Transactional
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
	public Employee save(Employee entity) throws Exception {
		try {
			Employee employee = employeeDao.save(entity);
			return employee;
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}		
	}
	@Override
	@Transactional
	public Employee update(Integer id, Employee entity) throws Exception {
		try {
			Optional<Employee> optionalEmployee = employeeDao.findById(id);
			Employee employee = optionalEmployee.get();
			employee = employeeDao.save(entity);
			return employee;
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}		
	}
	@Override
	@Transactional
	public Boolean delete(Integer id) throws Exception {
		try {
			if(employeeDao.existsById(id)) {
				employeeDao.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
