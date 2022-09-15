package com.johnsunday.app.security.controller;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsunday.app.entity.BaseEntity;
import com.johnsunday.app.security.dto.DtoUser;

public interface IUserController<E extends BaseEntity,ID extends Serializable> {

	public ResponseEntity<?> getAllUser(@RequestParam ID requestUserId);
	public ResponseEntity<?> getOneUser(@PathVariable ID userId,
										@RequestParam ID requestUserId);
	public ResponseEntity<?> saveUser(@RequestBody @Valid DtoUser dtoUser,
			  						  @RequestParam Integer requestUserId);
	public ResponseEntity<?> updateUser(@PathVariable ID userId,
										@RequestBody DtoUser user,
										@RequestParam ID requestUserId);
	public ResponseEntity<?> deleteUser(@PathVariable ID userId,
										@RequestParam ID requestUserId);
}
