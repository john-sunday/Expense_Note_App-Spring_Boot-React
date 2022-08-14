package com.johnsunday.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnsunday.app.dao.IPayrollDao;
import com.johnsunday.app.entity.Payroll;

@Service
public class PayrollServiceImpl extends BaseServiceImpl<Payroll,Integer> 
								implements IPayrollService {

	@Autowired
	private IPayrollDao payrollDao;

	@Override
	public List<Payroll> findAllPayrollByEmployeeId(Integer employeeId) throws Exception {
		try {
			return payrollDao.findAllPayrollByEmployeeId(employeeId);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
