package com.johnsunday.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.johnsunday.app.entity.Payroll;

@Repository
public interface IPayrollDao extends IBaseDao<Payroll, Integer> {

	@Query(value="SELECT * FROM payroll WHERE payroll.id_employee=?1", nativeQuery=true)
	List<Payroll> findAllPayrollByIdEmployee(Integer employeeId);
}
