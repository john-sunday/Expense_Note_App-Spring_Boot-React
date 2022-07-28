package com.johnsunday.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.johnsunday.app.entity.Employee;

@Repository
public interface IEmployeeDao extends JpaRepository<Employee, Integer> {

}
