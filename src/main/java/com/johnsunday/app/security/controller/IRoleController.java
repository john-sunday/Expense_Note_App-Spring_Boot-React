package com.johnsunday.app.security.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsunday.app.security.entity.Role;

public interface IRoleController {

	public ResponseEntity<?> getAllRole();
	public ResponseEntity<?> getRoleById(@PathVariable Integer roleId);
	public ResponseEntity<?> saveRole(@RequestBody @Valid Role role);
	public ResponseEntity<?> updateRole(@RequestBody @Valid Role role,
										@PathVariable Integer roleId);
	public ResponseEntity<?> deleteRole(@PathVariable Integer roleId);
}
