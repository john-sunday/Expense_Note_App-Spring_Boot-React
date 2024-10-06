package com.johnsunday.app.security.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.johnsunday.app.security.entity.Role;
import com.johnsunday.app.security.entity.User;

public class UserMapper {
	// With ID.
	public static User dtoToUserWithId(UserDto userDto) {
		return new User(
				userDto.getId(),
				userDto.getName(),
				userDto.getSurname(),
				userDto.getEmail(),
				userDto.getPassword(),
				dtosToRoles(userDto.getRoleDtos()));
	}

	public static UserDto userToDtoWithId(User user) {
		return new UserDto(
				user.getId(),
				user.getName(),
				user.getSurname(),
				user.getEmail(),
				user.getPassword(),
				rolesToDtos(user.getRoles()));
	}

	// Without ID.
	public static User dtoToUser(UserDto userDto) {
		return new User(
				userDto.getName(),
				userDto.getSurname(),
				userDto.getEmail(),
				userDto.getPassword(),
				dtosToRoles(userDto.getRoleDtos()));
	}

	public static UserDto userToDto(User user) {
		return new UserDto(
				user.getName(),
				user.getSurname(),
				user.getEmail(),
				user.getPassword(),
				rolesToDtos(user.getRoles()));
	}

	// Role/DTO Set.
	private static Set<Role> dtosToRoles(Collection<RoleDto> roleDtos) {
		Set<Role> roles = new HashSet<Role>();
		for (RoleDto roleDto : roleDtos) {
			roles.add(RoleMapper.dtoToRole(roleDto));
		}
		return roles;
	}

	private static Set<RoleDto> rolesToDtos(Collection<Role> roles) {
		Set<RoleDto> roleDtos = new HashSet<RoleDto>();
		for (Role role : roles) {
			roleDtos.add(RoleMapper.roleToDto(role));
		}
		return roleDtos;
	}
}
