package com.johnsunday.app.security.dto;

import com.johnsunday.app.security.entity.Role;

public class RoleMapper {
	
	public static Role dtoToRole(DtoRole dtoRole) {
		return new Role(dtoRole.getDtoRoleType());
	}
	
	public static DtoRole roleToDto(Role role) {
		return new DtoRole(role.getRoleType());
	}
}
