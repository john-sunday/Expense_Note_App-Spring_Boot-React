package com.johnsunday.app.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.johnsunday.app.security.entity.User;
import com.johnsunday.app.security.service.UserServiceImpl;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/v1/user")
public class UserControllerImpl implements IUserController {
	@Lazy
	@Autowired private UserServiceImpl userService;
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/all")	
	public ResponseEntity<?> findAll(@RequestParam("requestUserId")Integer requestUserId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. It is NOT possible to SHOW all the users\"}");
		}
	}
	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/one/{userId}")
	public ResponseEntity<?> findById(@PathVariable("userId")Integer userId,
									  @RequestParam("requestUserId")Integer requestUserId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.findById(userId));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW the user who you find.\"}");
		}
	}
	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/save")	
	public ResponseEntity<?> save(@Valid @RequestBody User user,
								  @RequestParam("requestUserId")Integer requestUserId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible to SAVE the user.\"}");
		}
	}
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/update/{userId}")	
	public ResponseEntity<?> update(@PathVariable("userId")Integer userId,
									@RequestBody User user,
									@RequestParam("requestUserId")Integer requestUserId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.update(userId,user));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. it is NOT possible UPDATE the user who you looking for.\"}");
		}
	}
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{userId}")	
	public ResponseEntity<?> delete(@PathVariable("userId")Integer userId,
									@RequestParam("requestUserId")Integer requestUserId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.delete(userId));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. It is NOT possible DELETE the user who you looking for.\"}");
		}
	}
}
