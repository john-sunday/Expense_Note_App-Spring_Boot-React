package com.johnsunday.app.security.service;

import com.johnsunday.app.security.dto.DtoRole;
import com.johnsunday.app.security.entity.Role;
import com.johnsunday.app.service.IBaseService;

public interface IRoleService extends IBaseService<Role,Integer> {

	public Role save(DtoRole dtoRole) throws Exception;
	public Role update(Integer roleId, DtoRole dtoRole) throws Exception;
}
