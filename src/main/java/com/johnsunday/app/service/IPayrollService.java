package com.johnsunday.app.service;

import java.time.LocalDateTime;
import java.util.List;

import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.entity.Payroll;

public interface IPayrollService {
	
	public List<Payroll> findAll() throws Exception;
	public Payroll findById(Integer id) throws Exception;
	public Payroll save(Payroll payroll) throws Exception;
	public Payroll update(Integer id,Payroll payroll) throws Exception;
	public Boolean delete(Integer id) throws Exception;
	public List<Payroll> findAllPayrollByEmployeeId(Integer employeeId) throws Exception;
	public Boolean findByDateAndEmployeeAllIgnoreCase(LocalDateTime PayrollDate,Employee employee) throws Exception;
}
