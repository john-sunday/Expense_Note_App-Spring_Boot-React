package com.johnsunday.app.security.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsunday.app.security.dto.DtoUser;

public interface IUserController {

	public ResponseEntity<?> getAllUser(@RequestParam Integer requestUserId);
	public ResponseEntity<?> getOneUser(@PathVariable Integer userId,
										@RequestParam Integer requestUserId);
	public ResponseEntity<?> saveUser(@RequestBody @Valid DtoUser dtoUser,
			  						  @RequestParam Integer requestUserId);
	public ResponseEntity<?> updateUser(@PathVariable Integer userId,
										@RequestBody DtoUser user,
										@RequestParam Integer requestUserId);
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId,
										@RequestParam Integer requestUserId);
}
