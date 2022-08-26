package com.johnsunday.app.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.johnsunday.app.entity.user.security.UserEmployee;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {

	private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000;// 24h
	
	@Value("${app.jwt.secret}")
	private String secretKey;
	
	public String generateAccessToken(UserEmployee user) {		
		return Jwts.builder()
				.setSubject(user.getId() + ", " + user.getUserEmail())
				.setIssuer("JohnSunday")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
	}
}
