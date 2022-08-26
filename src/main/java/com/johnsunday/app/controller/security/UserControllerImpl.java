package com.johnsunday.app.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnsunday.app.controller.BaseControllerImpl;
import com.johnsunday.app.entity.user.security.UserEmployee;
import com.johnsunday.app.service.security.UserServiceImpl;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/v1/user")
public class UserControllerImpl extends BaseControllerImpl<UserEmployee, UserServiceImpl> 
								implements IUserController<UserEmployee, Integer>{
	@Lazy
	@Autowired
	private UserServiceImpl userService;
	
	@Override
	public ResponseEntity<UserEmployee> getByUserUserEmail(String userEmail) {

		return null;
	}

//	@Override
//	@PostMapping("/")
//	@ResponseBody
//	public ResponseEntity<?> saveEntity(@RequestBody @Valid UserEmployee user) {
//		try {
//			return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
//		}catch(Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible to SAVE the USER entity.\"}");
//		}
//	}
	
	
}
