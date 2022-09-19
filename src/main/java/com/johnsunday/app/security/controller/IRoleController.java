package com.johnsunday.app.security.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsunday.app.security.dto.DtoRole;

public interface IRoleController {

	public ResponseEntity<?> getAllRole(@RequestParam Integer requestRoleId);
	public ResponseEntity<?> getOneRole(@PathVariable Integer roleId,
										@RequestParam Integer requestRoleId);
	public ResponseEntity<?> saveRole(@RequestBody @Valid DtoRole dtoRole,
			  						  @RequestParam Integer requestRoleId);
	public ResponseEntity<?> updateRole(@PathVariable Integer roleId,
										@RequestBody DtoRole dtoRole,
										@RequestParam Integer requestRoleId);
	public ResponseEntity<?> deleteRole(@PathVariable Integer roleId,
										@RequestParam Integer requestRoleId);
}
