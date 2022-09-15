package com.johnsunday.app.security.controller;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsunday.app.entity.BaseEntity;
import com.johnsunday.app.security.dto.DtoRole;

public interface IRoleController<E extends BaseEntity,ID extends Serializable> {

	public ResponseEntity<?> getAllRole(@RequestParam ID requestRoleId);
	public ResponseEntity<?> getOneRole(@PathVariable ID roleId,
										@RequestParam ID requestRoleId);
	public ResponseEntity<?> saveRole(@RequestBody @Valid DtoRole dtoRole,
			  						  @RequestParam Integer requestRoleId);
	public ResponseEntity<?> updateRole(@PathVariable ID roleId,
										@RequestBody DtoRole dtoRole,
										@RequestParam ID requestRoleId);
	public ResponseEntity<?> deleteRole(@PathVariable ID roleId,
										@RequestParam ID requestRoleId);
}
