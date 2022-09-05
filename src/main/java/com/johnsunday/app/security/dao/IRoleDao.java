package com.johnsunday.app.security.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.johnsunday.app.dao.IBaseDao;
import com.johnsunday.app.security.entity.Role;

@Repository
public interface IRoleDao extends IBaseDao<Role, Integer> {

	public Optional<Role> findByRoleType(String roleType);
}
