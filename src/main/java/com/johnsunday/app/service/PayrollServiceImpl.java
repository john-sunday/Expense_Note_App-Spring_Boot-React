package com.johnsunday.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnsunday.app.dao.IPayrollDao;
import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.Payroll;

@Service
public class PayrollServiceImpl implements IPayrollService {

	@Autowired
	private IPayrollDao payrollDao;

	@Override
	public List<Payroll> findAllPayrollByEmployeeId(Integer id) throws Exception {
		try {
			//return payrollDao.findAllPayrollByEmployeeId(employeeId);
			return payrollDao.findAllByEmployeeId(id);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public Boolean findByDateAndEmployeeAllIgnoreCase(LocalDateTime date,Employee employee) throws Exception{
		return payrollDao.findByDateAndEmployeeAllIgnoreCase(date,employee);
	}
	@Override
	public List<Payroll> findAll() throws Exception {
		try {
			return payrollDao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public Payroll findById(Integer id) throws Exception {
		try {
			Optional<Payroll> optionalPayroll = payrollDao.findById(id);
			return optionalPayroll.get();
		}catch(Exception e) {			
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	@Transactional
	public Payroll save(Payroll payroll) throws Exception {
		try {
			Payroll newPayroll = payrollDao.save(payroll);
			return newPayroll;
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	@Transactional
	public Payroll update(Integer id,Payroll payroll) throws Exception {
		Payroll payrollUpdated = null;
		try {
			Optional<Payroll> optionalPayroll = payrollDao.findById(id);
			Payroll oldPayroll = optionalPayroll.get();			
			if(oldPayroll!=null) {
				payrollUpdated = payrollDao.save(payroll);				
			}					
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return payrollUpdated;	
	}
	@Override
	@Transactional
	public Boolean delete(Integer id) throws Exception {
		boolean isDeleted = false;
		try {
			if(payrollDao.existsById(id)) {
				payrollDao.deleteById(id);
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
