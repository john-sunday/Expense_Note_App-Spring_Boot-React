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
import org.springframework.web.bind.annotation.RestController;

import com.johnsunday.app.security.dto.DtoUser;
import com.johnsunday.app.security.entity.User;
import com.johnsunday.app.security.jwt.JwtAuthenticationFilter;
import com.johnsunday.app.security.service.UserServiceImpl;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/v1/user")
public class UserControllerImpl /* extends BaseControllerImpl<User, UserServiceImpl> */
								implements IUserController<User, Integer>{
	@Lazy
	@Autowired
	private UserServiceImpl userService;
	
	@Override
	public ResponseEntity<User> findByUserEmail(String userEmail) {
		return null;
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/all?userId={userId}")	
	public ResponseEntity<?> getAllUser(@PathVariable("userId")Integer userId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW all the employees\"}");
		}
	}
	@GetMapping("/one/{userId}?requestUserId={requestUserId}")
	public ResponseEntity<?> getOneUser(@PathVariable("userId")Integer userId,
										@PathVariable("requestUserId")Integer requestUserId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.findById(userId));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW the entity who you find.\"}");
		}
	}
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/save?userId={userId}")	
	public ResponseEntity<?> saveUser(@RequestBody @Valid DtoUser dtoUser,
									  @PathVariable("userId")Integer userId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.save(dtoUser));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible to SAVE the entity.\"}");
		}
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/update/{userId}?requestUserId={requestUserId}")	
	public ResponseEntity<?> updateUser(@PathVariable("userId")Integer userId,
										@RequestBody User userEmployee,
										@PathVariable("requestUserId")Integer requestUserId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.update(userId, userEmployee));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible UPDATE the entity who you looking for.\"}");
		}
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{userId}?requestUserId={requestUserId}")	
	public ResponseEntity<?> deleteUser(@PathVariable("userId")Integer userId,
										@PathVariable("requestUserId")Integer requestUserId){
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userService.delete(userId));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. Not possible DELETE the entity who you looking for.\"}");
		}
	}	
}
