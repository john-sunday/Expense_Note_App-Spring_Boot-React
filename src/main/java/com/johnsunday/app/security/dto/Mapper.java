package com.johnsunday.app.security.dto;

import com.johnsunday.app.security.entity.User;

public class Mapper {
	
	public static User dtoToUser(DtoUser dtoUser) {
		User newUser = new User(					
				dtoUser.getDtoUserName(),
				dtoUser.getDtoUserSurname(),
				dtoUser.getDtoUserEmail(),
				dtoUser.getDtoUserPassword(),
				dtoUser.getDtoUserRoles()							 					
				);			
		return newUser;
	}
	
	public static DtoUser userToDto(User user) {
		DtoUser newDtoUser = new DtoUser(					
				user.getUserName(),
				user.getUserSurname(),
				user.getUserEmail(),
				user.getUserPassword(),
				user.getUserRoles()							 					
				);			
		return newDtoUser;
	}
}
