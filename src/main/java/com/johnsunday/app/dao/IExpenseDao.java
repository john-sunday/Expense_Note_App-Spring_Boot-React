package com.johnsunday.app.dao;

import org.springframework.stereotype.Repository;

import com.johnsunday.app.entity.Expense;

@Repository
public interface IExpenseDao extends IBaseDao<Expense, Integer> {

}
