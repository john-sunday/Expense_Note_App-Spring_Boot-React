package com.johnsunday.app.security.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.johnsunday.app.dao.IBaseDao;
import com.johnsunday.app.security.dto.DtoUser;
import com.johnsunday.app.security.entity.User;


@Repository
public interface IUserDao extends IBaseDao<User, Integer> {

	public Optional<User> findByUserEmail(String userEmail);
}
