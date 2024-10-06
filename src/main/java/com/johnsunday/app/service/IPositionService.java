package com.johnsunday.app.service;

import java.util.List;

import com.johnsunday.app.entity.Position;

public interface IPositionService {

	public List<Position> findAll() throws Exception;

	public Position findById(Integer id) throws Exception;

	public Position save(Position employeeType) throws Exception;

	public Position update(Integer id, Position employeeType) throws Exception;

	public Boolean delete(Integer id) throws Exception;

	public Position findByName(String name);
}
