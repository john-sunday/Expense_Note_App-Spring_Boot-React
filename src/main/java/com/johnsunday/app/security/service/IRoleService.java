package com.johnsunday.app.security.service;

import java.util.List;
import java.util.Optional;

import com.johnsunday.app.security.entity.Role;

public interface IRoleService {

	public List<Role> findAll() throws Exception;
	public Optional<Role> findById(Integer id) throws Exception;
	public Role save(Role role) throws Exception;
	public Role update(Integer roleId,Role role) throws Exception;
	public Boolean delete(Integer id) throws Exception;
}
