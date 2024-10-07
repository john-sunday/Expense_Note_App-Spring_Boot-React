package com.johnsunday.app.security.service;

import java.util.List;
import java.util.Optional;

import com.johnsunday.app.security.entity.ExpenseUser;

public interface IUserService {

	public List<ExpenseUser> findAll() throws Exception;

	public Optional<ExpenseUser> findById(Integer id) throws Exception;

	public Boolean delete(Integer id) throws Exception;

	public ExpenseUser save(ExpenseUser user) throws Exception;

	public ExpenseUser update(Integer userId, ExpenseUser user) throws Exception;

	public Optional<ExpenseUser> findByEmail(String userEmail) throws Exception;
}
