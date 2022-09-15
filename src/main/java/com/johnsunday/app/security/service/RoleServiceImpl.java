package com.johnsunday.app.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnsunday.app.security.dao.IRoleDao;
import com.johnsunday.app.security.dto.DtoRole;
import com.johnsunday.app.security.dto.RoleMapper;
import com.johnsunday.app.security.entity.Role;
import com.johnsunday.app.service.BaseServiceImpl;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role,Integer>
							 implements IRoleService {

	@Autowired IRoleDao roleDao;
	
	@Override
	public Role save(DtoRole dtoRole) throws Exception{
		try {			
			Role newRole = RoleMapper.dtoToRole(dtoRole);			
			return roleDao.save(newRole);			
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public Role update(Integer roleId, DtoRole dtoRole) throws Exception {
		Role updatedRole = null;
		try {
			Role roleToUpdate = RoleMapper.dtoToRole(dtoRole);
			Optional<Role>optionalRole = roleDao.findById(roleId);
			if (!optionalRole.isEmpty()) {
				updatedRole = roleDao.save(roleToUpdate);			
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}		
		return updatedRole;
	}
}
