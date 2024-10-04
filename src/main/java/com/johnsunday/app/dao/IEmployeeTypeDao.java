package com.johnsunday.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.johnsunday.app.entity.EmployeeType;

@Repository
public interface IEmployeeTypeDao extends JpaRepository<EmployeeType, Integer> {

	Optional<EmployeeType> findByNameIgnoreCase(String employeeTypeName);
}
