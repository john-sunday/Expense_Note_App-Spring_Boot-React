package com.johnsunday.app.dao.security;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.johnsunday.app.dao.IBaseDao;
import com.johnsunday.app.entity.user.security.UserEmployee;

@Repository
public interface IUserDao extends IBaseDao<UserEmployee, Integer> {

	public Optional<UserEmployee> findByUserEmail(String userEmail);
}
