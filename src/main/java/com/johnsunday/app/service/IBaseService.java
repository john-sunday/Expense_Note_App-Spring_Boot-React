package com.johnsunday.app.service;

import java.util.List;

public interface IBaseService<E> {

	public List<E> findAll() throws Exception;
	public E findById(Integer id) throws Exception;
	public E save(E entity) throws Exception;
	public E update(Integer id,E entity) throws Exception;
	public Boolean delete(Integer id) throws Exception;
}
