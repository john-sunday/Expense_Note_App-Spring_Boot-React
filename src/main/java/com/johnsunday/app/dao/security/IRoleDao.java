package com.johnsunday.app.dao.security;

import org.springframework.stereotype.Repository;

import com.johnsunday.app.dao.IBaseDao;
import com.johnsunday.app.entity.user.security.UserRole;

@Repository
public interface IRoleDao extends IBaseDao<UserRole, Integer> {

}
