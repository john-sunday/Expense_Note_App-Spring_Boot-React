package com.johnsunday.app.dao;

import org.springframework.stereotype.Repository;

import com.johnsunday.app.entity.EmployeeType;

@Repository
public interface IEmployeeTypeDao extends IBaseDao<EmployeeType, Integer> {

}
