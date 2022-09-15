package com.johnsunday.app.security.service;

import java.util.Optional;

import com.johnsunday.app.security.dto.DtoUser;
import com.johnsunday.app.security.entity.User;
import com.johnsunday.app.service.IBaseService;

public interface IUserService extends IBaseService<User,Integer> {

	public User save(DtoUser dtoUser) throws Exception;
	public User update(Integer userId, DtoUser dtoUser) throws Exception;
	public Optional<User> findByUserEmail(String userEmail) throws Exception;
}
