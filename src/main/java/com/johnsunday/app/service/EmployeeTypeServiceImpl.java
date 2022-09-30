package com.johnsunday.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnsunday.app.dao.IEmployeeTypeDao;
import com.johnsunday.app.entity.EmployeeType;

@Service
public class EmployeeTypeServiceImpl implements IEmployeeTypeService {

	@Autowired private IEmployeeTypeDao employeeTypeDao;
	
	@Override
	public List<EmployeeType> findAll() throws Exception {
		try {
			return employeeTypeDao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public EmployeeType findById(Integer id) throws Exception {
		try {
			Optional<EmployeeType> optionalEmployeeType = employeeTypeDao.findById(id);
			return optionalEmployeeType.get();
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	@Transactional
	public EmployeeType save(EmployeeType employeeType) throws Exception {
		try {
			EmployeeType newEmployeeType = employeeTypeDao.save(employeeType);
			return newEmployeeType;
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	@Transactional
	public EmployeeType update(Integer id,EmployeeType employeeType) throws Exception {
		EmployeeType employeeTypeUpdated = null;
		try {
			Optional<EmployeeType> optionalEmployeeType = employeeTypeDao.findById(id);
			EmployeeType oldEmployeeType = optionalEmployeeType.get();	
			if(oldEmployeeType!=null) {
				employeeTypeUpdated = employeeTypeDao.save(employeeType);				
			}					
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return employeeTypeUpdated;	
	}
	@Override
	@Transactional
	public Boolean delete(Integer id) throws Exception {
		boolean isDeleted = false;
		try {
			if(employeeTypeDao.existsById(id)) {
				employeeTypeDao.deleteById(id);
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
	@Override
	public EmployeeType findByName(String name) {
		Optional<EmployeeType>optEmployeeType = employeeTypeDao.findByNameIgnoreCase(name);
		return optEmployeeType.get();
	}
}
