package com.johnsunday.app.security.dto;

import java.util.Collection;
import java.util.HashSet;

import com.johnsunday.app.entity.BaseEntity;
import com.johnsunday.app.security.entity.Role;
import com.johnsunday.app.security.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoUser extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	private String dtoUserName;
	private String dtoUserSurname;
	private String dtoUserEmail;
	private String dtoUserPassword;
	private Collection<Role>dtoUserRoles = new HashSet<>();	
}
