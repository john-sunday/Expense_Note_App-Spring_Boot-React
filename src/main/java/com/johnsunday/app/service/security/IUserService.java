package com.johnsunday.app.service.security;

import com.johnsunday.app.entity.security.UserEmployee;
import com.johnsunday.app.service.IBaseService;

public interface IUserService extends IBaseService<UserEmployee,Integer> {

	public UserEmployee save(UserEmployee user) throws Exception;
}
