package com.johnsunday.app.controller;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsunday.app.entity.BaseEntity;

public interface IBaseController<E extends BaseEntity,ID extends Serializable> {

	public ResponseEntity<?> getAllEntities(@RequestParam ID requestUserId);
	public ResponseEntity<?> getOneEntity(@PathVariable ID userId,
										  @RequestParam ID requestUserId);
	public ResponseEntity<?> saveEntity(@RequestBody @Valid E entity,
			  						    @RequestParam ID requestUserId);
	public ResponseEntity<?> updateEntity(@PathVariable ID userId,
										  @RequestBody E entity,
										  @RequestParam ID requestUserId);
	public ResponseEntity<?> deleteEntity(@PathVariable ID userId,
										  @RequestParam ID requestUserId);
}
