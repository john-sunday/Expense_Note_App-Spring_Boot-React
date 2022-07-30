package com.johnsunday.app.dao;

import org.springframework.stereotype.Repository;

import com.johnsunday.app.entity.Payroll;

@Repository
public interface IPayrollDao extends IBaseDao<Payroll, Integer> {

}
