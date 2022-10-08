package com.johnsunday.app.security.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsunday.app.security.entity.User;

public interface IUserController {

	public ResponseEntity<?> getAllUser();
	public ResponseEntity<?> getUserById(@PathVariable Integer userId);
	public ResponseEntity<?> saveUser(@RequestBody @Valid User user);
	public ResponseEntity<?> updateUser(@RequestBody @Valid User user,
										@PathVariable Integer userId);
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId);
}
