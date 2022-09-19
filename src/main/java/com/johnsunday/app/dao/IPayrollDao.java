package com.johnsunday.app.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.Payroll;

@Repository
public interface IPayrollDao extends JpaRepository<Payroll,Integer> {

	//@Query(value="SELECT * FROM payroll WHERE payroll.employee_id_fk=?1", nativeQuery=true)
	//List<Payroll> findAllPayrollByEmployeeId(Integer employeeId);
	
	List<Payroll> findAllByEmployeeId(Integer employeeId);
	Boolean findByDateAndEmployeeAllIgnoreCase(LocalDateTime PayrollDate,Employee employee);
}
