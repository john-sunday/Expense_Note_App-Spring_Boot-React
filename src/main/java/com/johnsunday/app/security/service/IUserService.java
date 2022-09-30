package com.johnsunday.app.security.service;

import java.util.List;
import java.util.Optional;

import com.johnsunday.app.security.entity.User;

public interface IUserService {

	public List<User> findAll() throws Exception;
	public Optional<User> findById(Integer id) throws Exception;
	public Boolean delete(Integer id) throws Exception;
	public User save(User user) throws Exception;
	public User update(Integer userId,User user) throws Exception;
	public Optional<User> findByEmail(String userEmail) throws Exception;
}
