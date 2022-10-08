package com.johnsunday.app.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.johnsunday.app.security.jwt.JwtAuthenticationUtil;

import io.jsonwebtoken.Claims;

public class UserUtil {
	
	@Autowired static private JwtAuthenticationUtil jwtAuthUtil;	
	
	public static Boolean isAdminUser(String token) {
		boolean isAdmin = false;
		
		Claims claims = jwtAuthUtil.parseClaims(token);
		String claimRoles = (String) claims.get("roles");		
		claimRoles = claimRoles.replace("[", "").replace("]", "");
		String[]roleNames =  claimRoles.split(",");
		for (String role:roleNames) {
			if (role.equalsIgnoreCase("ROLE_ADMIN")) {
				isAdmin = true;
				break;
			}
		}
		return isAdmin;
	}
}
