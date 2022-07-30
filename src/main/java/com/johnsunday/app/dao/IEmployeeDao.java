package com.johnsunday.app.dao;

import org.springframework.stereotype.Repository;

import com.johnsunday.app.entity.Employee;

@Repository
public interface IEmployeeDao extends IBaseDao<Employee, Integer> {

}
