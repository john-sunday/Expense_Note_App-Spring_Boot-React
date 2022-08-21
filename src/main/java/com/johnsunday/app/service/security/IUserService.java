package com.johnsunday.app.service.security;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.johnsunday.app.dto.security.UserRegistrationDto;
import com.johnsunday.app.entity.security.User;
import com.johnsunday.app.service.IBaseService;

public interface IUserService extends IBaseService<User,Integer>, UserDetailsService{

	public User save(UserRegistrationDto userRegistrationDto) throws Exception;
}
