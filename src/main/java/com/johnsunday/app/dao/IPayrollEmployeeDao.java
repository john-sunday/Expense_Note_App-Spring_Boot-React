package com.johnsunday.app.dao;

import org.springframework.stereotype.Repository;

import com.johnsunday.app.entity.PayrollEmployee;

@Repository
public interface IPayrollEmployeeDao extends IBaseDao<PayrollEmployee, Integer> {

}
