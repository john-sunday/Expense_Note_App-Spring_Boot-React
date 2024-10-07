package com.johnsunday.app.security.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.johnsunday.app.security.entity.ExpenseUser;

public interface IUserController {

	public ResponseEntity<?> getAllUser();

	public ResponseEntity<?> getUserById(@PathVariable Integer userId);

	public ResponseEntity<?> saveUser(@RequestBody @Valid ExpenseUser user);

	public ResponseEntity<?> updateUser(@RequestBody @Valid ExpenseUser user,
			@PathVariable Integer userId);

	public ResponseEntity<?> deleteUser(@PathVariable Integer userId);
}
