package com.johnsunday.app.security.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.johnsunday.app.security.entity.Role;
import com.johnsunday.app.security.entity.User;

public class UserMapper {
	// With ID.
	public static User dtoToUserWithId(DtoUser dtoUser) {
		return new User(
				dtoUser.getId(),
				dtoUser.getName(),
				dtoUser.getSurname(),
				dtoUser.getEmail(),
				dtoUser.getPassword(),
				dtoSetToRoleSet(dtoUser.getDtoRoles())
				);
	}	
	public static DtoUser userToDtoWithId(User user) {
		return new DtoUser(
				user.getId(),
				user.getName(),
				user.getSurname(),
				user.getEmail(),
				user.getPassword(),
				roleSetToDtoSet(user.getRoles())							 					
				);
	}
	// Without ID.
	public static User dtoToUser(DtoUser dtoUser) {
		return new User(
				dtoUser.getName(),
				dtoUser.getSurname(),
				dtoUser.getEmail(),
				dtoUser.getPassword(),
				dtoSetToRoleSet(dtoUser.getDtoRoles())
				);
	}	
	public static DtoUser userToDto(User user) {
		return new DtoUser(
				user.getName(),
				user.getSurname(),
				user.getEmail(),
				user.getPassword(),
				roleSetToDtoSet(user.getRoles())							 					
				);
	}
	
	// Role/DTO Set.
	private static Set<Role> dtoSetToRoleSet(Collection<DtoRole> dtoRoleSet) {
		Set<Role>roles = new HashSet<Role>();
		for (DtoRole dtoRole:dtoRoleSet) {
			roles.add(RoleMapper.dtoToRole(dtoRole));
		}
		return roles;
	}
	private static Set<DtoRole> roleSetToDtoSet(Collection<Role> roleSet) {
		Set<DtoRole>dtoRoleSet = new HashSet<DtoRole>();
		for (Role role:roleSet) {
			dtoRoleSet.add(RoleMapper.roleToDto(role));
		}
		return dtoRoleSet;
	}
}
