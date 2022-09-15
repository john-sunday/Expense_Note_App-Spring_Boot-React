package com.johnsunday.app.security.dto;

import com.johnsunday.app.security.entity.User;

public class UserMapper {
	
	public static User dtoToUser(DtoUser dtoUser) {
		return new User(				
				dtoUser.getDtoUserName(),
				dtoUser.getDtoUserSurname(),
				dtoUser.getDtoUserEmail(),
				dtoUser.getDtoUserPassword(),
				dtoUser.getDtoUserRoles()							 					
				);
	}
	
	public static DtoUser userToDto(User user) {
		return new DtoUser(					
				user.getUserName(),
				user.getUserSurname(),
				user.getUserEmail(),
				user.getUserPassword(),
				user.getUserRoles()							 					
				);
	}
}
