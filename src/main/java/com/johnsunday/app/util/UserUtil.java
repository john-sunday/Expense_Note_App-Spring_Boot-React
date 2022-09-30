package com.johnsunday.app.util;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.johnsunday.app.security.dao.IRoleDao;
import com.johnsunday.app.security.entity.Role;
import com.johnsunday.app.security.jwt.JwtAuthenticationFilter;

public class UserUtil {
	
	//@Autowired static private JwtAuthenticationFilter jwtAuthFilter;
	@Autowired static private IRoleDao roleDao;
	
	
	public static Boolean checkUserAdminRole(String token,JwtAuthenticationFilter jwtAuthFilter) {
		boolean isAdmin = false;
		//UserDetails userTokenDetails = null;
		UserDetails userTokenDetails = jwtAuthFilter.getUserDetails(token);			
		Collection<? extends GrantedAuthority>roles = userTokenDetails.getAuthorities();		
		Optional<Role>optAdminRole = roleDao.findByName("ROLE_ADMIN");		
		//roles.stream().map(r->r.getAuthority().compareTo("ROLE_ADMIN"));
		if (roles.contains(optAdminRole)) isAdmin = true;
		return isAdmin;
	}
}
