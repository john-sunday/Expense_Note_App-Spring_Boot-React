package com.johnsunday.app.dao.security;

import org.springframework.stereotype.Repository;

import com.johnsunday.app.dao.IBaseDao;
import com.johnsunday.app.entity.security.User;

@Repository
public interface IUserDao extends IBaseDao<User, Integer> {

	public User findByEmail(String email);
}
