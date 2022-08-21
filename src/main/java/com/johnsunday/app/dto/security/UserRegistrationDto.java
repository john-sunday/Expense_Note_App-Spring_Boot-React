package com.johnsunday.app.dto.security;

import com.johnsunday.app.entity.security.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto extends User{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String surname;
	private String email;
	private String password;
}
