package com.johnsunday.app.security.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.security.dao.IRoleDao;
import com.johnsunday.app.security.dto.DtoRole;
import com.johnsunday.app.security.dto.RoleMapper;
import com.johnsunday.app.security.entity.Role;

@Service
public class RoleServiceImpl implements IRoleService {

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
	@Override
	public List<Role> findAll() throws Exception {
		try {
			return roleDao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public Role findById(Integer id) throws Exception {
		try {
			Optional<Role> optionalRole = roleDao.findById(id);
			return optionalRole.get();
		}catch(Exception e) {			
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	@Transactional
	public Boolean delete(Integer id) throws Exception {
		boolean isDeleted = false;
		try {
			if(roleDao.existsById(id)) {
				roleDao.deleteById(id);
				isDeleted = true;
			} else {
				throw new Exception();
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return isDeleted;
	}
}
