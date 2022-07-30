package com.johnsunday.app.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.johnsunday.app.entity.BaseEntity;

public interface IBaseController<E extends BaseEntity,ID extends Serializable> {

	public ResponseEntity<?> getAllEntities();
	public ResponseEntity<?> getOneEntity(@PathVariable ID id);
	public ResponseEntity<?> saveEntity(@RequestBody E entity);
	public ResponseEntity<?> updateEntity(@PathVariable ID id, @RequestBody E entity);
	public ResponseEntity<?> deleteEntity(@PathVariable ID id);
}
