package com.johnsunday.app.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.johnsunday.app.entity.Expense;

@Repository
public interface IExpenseDao extends IBaseDao<Expense, Integer> {

	//@Query(value="SELECT * FROM expense WHERE expense.employee_id_fk=?1", nativeQuery=true)
	//List<Expense> findAllExpenseByEmployeeId(Integer employeeId);
	
	List<Expense> findAllByEmployeeId(Integer employeeId);
	
	@Query(value="SELECT * FROM expense WHERE expense.amount=?1 "
			+ "and expense.expense_date=?2 "
			+ "and expense.concept=?3 "
			+ "and expense.employee_id_fk=?4",nativeQuery=true)
	Boolean findByAmountAndExpenseDateAndConceptAndEmployeeIdFkAllIgnoreCase(Double amount,
																			 LocalDateTime expenseDate,
																			 String concept,
																			 Integer employeeIdFk);
}
