package com.johnsunday.app.security.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnsunday.app.security.dao.IRoleDao;
import com.johnsunday.app.security.entity.Role;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired IRoleDao roleDao;
	
	@Override
	@Transactional
	public Role save(Role role) throws Exception{
		try {									
			return roleDao.save(role);			
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	@Transactional
	public Role update(Integer roleId,Role role) throws Exception {
		Role updatedRole = null;
		try {
			Optional<Role>optionalRole = roleDao.findById(roleId);
			if (!optionalRole.isEmpty()) {
				updatedRole = roleDao.save(role);			
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
	public Optional<Role> findById(Integer id) throws Exception {
		try {
			Optional<Role> optionalRole = roleDao.findById(id);
			return Optional.of(optionalRole.get());
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
