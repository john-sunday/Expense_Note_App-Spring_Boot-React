package com.johnsunday.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnsunday.app.entity.Employee;

public interface IEmployeeTypeDao extends JpaRepository<Integer, Employee> {

}
