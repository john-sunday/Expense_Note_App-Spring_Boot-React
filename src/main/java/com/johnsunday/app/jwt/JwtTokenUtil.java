package com.johnsunday.app.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.johnsunday.app.entity.user.security.UserEmployee;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
	//private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
	private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000;// 24h	
	
	@Value("${app.jwt.secret}")
	private String secretKey;
	
	public String generateAccessToken(UserEmployee user) {		
		return Jwts.builder()
				.setSubject(user.getId() + "," + user.getUserEmail())
				.claim("roles", user.getUserRoles().toString())
				.setIssuer("JohnSunday")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
	}
	public boolean validateAccessToken(String token) {
		boolean isValidated = false;
		try {
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			isValidated = true;
		}catch(ExpiredJwtException ex) {
			ex.printStackTrace();
			LOGGER.error("jwt expired",ex);
		}catch(IllegalArgumentException ex) {
			ex.printStackTrace();
			LOGGER.error("Token is null, empty or has only whitespace",ex);
		}catch(MalformedJwtException ex) {
			LOGGER.error("JWT is invalid",ex);
		}catch(UnsupportedJwtException ex) {
			ex.printStackTrace();
			LOGGER.error("JWT is not supported",ex);
		}catch(SignatureException ex) {
			ex.printStackTrace();
			LOGGER.error("Signature validation failed",ex);
		}
		return isValidated;
	}
	public String getSubject(String token) {
		return parseClaims(token)
				.getSubject();
	}
	public Claims parseClaims(String token) {
		return Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(token)
				.getBody();
				
	}
}
