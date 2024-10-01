package com.johnsunday.app.security.dto;

import com.johnsunday.app.security.entity.Role;

public class RoleMapper {
	// Without ID.
	public static Role dtoToRole(DtoRole dtoRole) {
		return new Role(dtoRole.getName());
	}	
	public static DtoRole roleToDto(Role role) {
		return new DtoRole(role.getName());
	}
	// With ID.
	public static Role dtoToRoleWithId(DtoRole dtoRole) {
		return new Role(
				dtoRole.getId(),
				dtoRole.getName()
				);
	}	
	public static DtoRole roleToDtoWithId(Role role) {
		return new DtoRole(
				role.getId(),
				role.getName()
				);
	}
}
