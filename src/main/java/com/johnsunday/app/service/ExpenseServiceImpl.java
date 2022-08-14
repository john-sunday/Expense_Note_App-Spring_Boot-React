package com.johnsunday.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnsunday.app.dao.IExpenseDao;
import com.johnsunday.app.dao.IExpenseEmployeeDao;
import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.entity.ExpenseEmployee;

@Service
public class ExpenseServiceImpl extends BaseServiceImpl<Expense,Integer> 
								implements IExpenseService {

	@Autowired
	private IExpenseDao expenseDao;
	
	@Override	
	public List<Expense> findAllExpenseByEmployeeId(Integer employeeId) throws Exception {
		try {
			return expenseDao.findAllExpenseByEmployeeId(employeeId);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
