package com.johnsunday.app.service;

import java.util.List;

import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.entity.Payroll;

public interface IPayrollService extends IBaseService<Expense> {

	public List<Payroll> findPayrollByEmployeeId(Integer id) throws Exception;
}
