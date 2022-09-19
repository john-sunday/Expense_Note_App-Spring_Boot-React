package com.johnsunday.app.security.dto;

import java.util.Collection;
import java.util.HashSet;

import com.johnsunday.app.security.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoUser extends User{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private Collection<DtoRole>dtoRoles = new HashSet<>();
	// Constructor WITHOUT id.
	public DtoUser(String name,String surname,String email,String password,Collection<DtoRole>dtoRoles) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.dtoRoles = dtoRoles;
	}
}
