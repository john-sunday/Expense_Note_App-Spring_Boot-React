package com.johnsunday.app.security.service;

import java.util.List;

import com.johnsunday.app.security.dto.DtoRole;
import com.johnsunday.app.security.entity.Role;

public interface IRoleService {

	public List<Role> findAll() throws Exception;
	public Role findById(Integer id) throws Exception;
	public Role save(DtoRole dtoRole) throws Exception;
	public Role update(Integer roleId, DtoRole dtoRole) throws Exception;
	public Boolean delete(Integer id) throws Exception;
}
