package com.johnsunday.app.dao;

import org.springframework.stereotype.Repository;

import com.johnsunday.app.entity.ExpenseEmployee;

@Repository
public interface IExpenseEmployeeDao extends IBaseDao<ExpenseEmployee, Integer> {

}
