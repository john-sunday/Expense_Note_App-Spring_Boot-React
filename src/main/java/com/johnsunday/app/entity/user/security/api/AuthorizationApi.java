package com.johnsunday.app.entity.user.security.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.johnsunday.app.entity.user.security.UserEmployee;
import com.johnsunday.app.jwt.JwtTokenUtil;

/***
 * @version 0.0.1
 * @author tecnicomanotas
 *
 */
@CrossOrigin(origins="*")
@RestController
/*	
 * 	WARNING !!!! 
 * 	El valor de la ruta("api/v1/auth" es lo mismo con slash al principio -> "/api/v1/auth"), 
 * 	me daba '401 Unauthorized'. Parece que las rutas largas, que no están pegadas al número de puerto
 * 	dan problemas.
 * */
@RequestMapping("/auth")
public class AuthorizationApi {
	
	@Autowired AuthenticationManager authManager;
	@Autowired JwtTokenUtil jwtUtil;
	
	//@RequestMapping(path="/login",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthorizationRequest request){
		try {
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));			
			UserEmployee user = (UserEmployee) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			AuthorizationResponse response = new AuthorizationResponse(user.getUserEmail(),accessToken);
			return ResponseEntity.ok(response);
		}catch(BadCredentialsException ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
