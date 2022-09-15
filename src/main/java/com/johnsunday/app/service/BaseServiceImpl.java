package com.johnsunday.app.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.johnsunday.app.dao.IBaseDao;
import com.johnsunday.app.entity.BaseEntity;

public abstract class BaseServiceImpl<E extends BaseEntity, ID extends Serializable> 
									 implements IBaseService<E, ID> {
	
	@Autowired
	protected IBaseDao<E,ID> baseDao;
	
	@Override
	@Transactional
	public List<E> findAll() throws Exception {
		try {
			return baseDao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}		
	}
	@Override
	@Transactional
	public E findById(ID id) throws Exception {
		try {
			Optional<E> optionalEntity = baseDao.findById(id);
			return optionalEntity.get();
		}catch(Exception e) {			
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}		
	}
	@Override
	@Transactional
	public E save(E entity) throws Exception {		
		try {
			E newEntity = baseDao.save(entity);
			return newEntity;
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}		
	}
	@Override
	@Transactional
	public E update(ID id, E entity) throws Exception {
		E entityUpdated = null;
		try {
			Optional<E> optionalEntity = baseDao.findById(id);
			E oldEntity = optionalEntity.get();			
			if(oldEntity!=null) {
				entityUpdated = baseDao.save(entity);				
			}					
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return entityUpdated;		
	}
	@Override
	@Transactional
	public Boolean delete(ID id) throws Exception {
		boolean isDeleted = false;
		try {
			if(baseDao.existsById(id)) {
				baseDao.deleteById(id);
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
