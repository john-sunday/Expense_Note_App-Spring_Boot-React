package com.johnsunday.app.security.jwt;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.johnsunday.app.security.dao.IUserDao;
import com.johnsunday.app.security.entity.Role;
import com.johnsunday.app.security.entity.User;

import io.jsonwebtoken.Claims;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired private JwtAuthenticationUtil jwtAuthUtil;
	@Autowired private IUserDao userDao;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, 
									HttpServletResponse response, 
									FilterChain filterChain) 
											throws ServletException, IOException {
		if(!hasAuthorizationHeader(request)) {
			System.out.println("It hasn't header authorization");
			filterChain.doFilter(request, response);
			return;
		}
		String accessToken = getAccessToken(request);
		if(!jwtAuthUtil.validateAccessToken(accessToken)) {
			System.out.println("Token NOT valid");
			filterChain.doFilter(request, response);
			return;
		}
		//TODO ---> To finish the method which compare the id's(id Token and id URL parameter) 
		UserDetails userDetails =  setAuthenticationContext(accessToken,request);
				
		String userEmail = userDetails.getUsername();
		Optional<User>optionalUser = userDao.findByEmail(userEmail);
		User user = optionalUser.get();
		int tokenUserId = user.getId();
				
		String reqUserId = request.getParameter("requestUserId");
		System.out.println("Requesting User Id: " + reqUserId);
		
		//if (tokenUserId != Integer.parseInt(reqUserId)) return;
				
		filterChain.doFilter(request, response);		
	}
	private boolean hasAuthorizationHeader(HttpServletRequest request) {
		boolean hasAuth = true;
		String header = request.getHeader("Authorization");
		System.out.println("Authorization header: " + header);
		if(ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
			hasAuth = false;
		}
		return hasAuth;
	}
	private String getAccessToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		String token = header.split(" ")[1].trim();
		System.out.println("Access token: " + token);
		return token;
	}
	private UserDetails setAuthenticationContext(String accessToken, HttpServletRequest request) {
		UserDetails userDetails = getUserDetails(accessToken);
		
		UsernamePasswordAuthenticationToken authentication =
				new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return userDetails;
	}
	public UserDetails getUserDetails(String accessToken) {
		User userDetails = new User();
		Claims claims = jwtAuthUtil.parseClaims(accessToken);
		String claimRoles = (String) claims.get("roles");
		//String claimSub = claims.getSubject();
		
		// Testing
		System.out.println("Claim Roles: " + claimRoles);
		
		claimRoles = claimRoles.replace("[", "").replace("]", "");
		String[]roleNames =  claimRoles.split(",");
		for(String roleName:roleNames) {
			userDetails.addRole(new Role(roleName));
		}		
		String subject = (String)claims.get(Claims.SUBJECT);		
		String[]subjectArray = subject.split(",");
		userDetails.setId(Integer.parseInt(subjectArray[0]));
		userDetails.setEmail(subjectArray[1]);
		
		return userDetails;
	}
}
