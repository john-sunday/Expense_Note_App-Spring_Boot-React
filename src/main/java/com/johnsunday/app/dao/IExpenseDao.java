package com.johnsunday.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.entity.Payroll;

@Repository
public interface IExpenseDao extends IBaseDao<Expense, Integer> {

	@Query(value="SELECT * FROM expense WHERE expense.employee_id_fk=?1", nativeQuery=true)
	List<Expense> findAllExpenseByEmployeeId(Integer employeeId);
}
