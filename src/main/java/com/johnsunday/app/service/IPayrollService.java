package com.johnsunday.app.service;

import java.util.List;

import com.johnsunday.app.entity.Payroll;

public interface IPayrollService extends IBaseService<Payroll,Integer> {

	public List<Payroll> findAllPayrollByEmployeeId(Integer employeeId) throws Exception;
}
