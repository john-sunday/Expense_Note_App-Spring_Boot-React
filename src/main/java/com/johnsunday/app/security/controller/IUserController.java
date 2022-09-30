package com.johnsunday.app.security.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsunday.app.security.entity.User;

public interface IUserController {

	public ResponseEntity<?> getAllUser(@RequestParam Integer requestUserId);
	public ResponseEntity<?> getOneUser(@PathVariable Integer userId,
										@RequestParam Integer requestUserId);
	public ResponseEntity<?> saveUser(@RequestBody @Valid User user,
			  						  @RequestParam Integer requestUserId);
	public ResponseEntity<?> updateUser(@PathVariable Integer userId,
										@RequestBody User user,
										@RequestParam Integer requestUserId);
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId,
										@RequestParam Integer requestUserId);
}
