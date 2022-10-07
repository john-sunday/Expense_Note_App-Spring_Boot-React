package com.johnsunday.app.security.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsunday.app.security.entity.User;

public interface IUserController {

	public ResponseEntity<?> findAll(@RequestParam Integer requestUserId);
	public ResponseEntity<?> findById(@PathVariable Integer userId,
										@RequestParam Integer requestUserId);
	public ResponseEntity<?> save(@RequestBody @Valid User user,
			  						  @RequestParam Integer requestUserId);
	public ResponseEntity<?> update(@PathVariable Integer userId,
										@RequestBody User user,
										@RequestParam Integer requestUserId);
	public ResponseEntity<?> delete(@PathVariable Integer userId,
										@RequestParam Integer requestUserId);
}
