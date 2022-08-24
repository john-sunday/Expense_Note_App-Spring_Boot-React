//package com.johnsunday.app.controller.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.johnsunday.app.controller.BaseControllerImpl;
//import com.johnsunday.app.dto.security.UserRegistrationDto;
//import com.johnsunday.app.entity.security.User;
//import com.johnsunday.app.service.security.UserServiceImpl;
//
//@Controller
//@RequestMapping("/signup")
//@CrossOrigin(origins="*")
//public class UserRegistrationControllerImpl /* extends BaseControllerImpl<User, UserServiceImpl> */{
//
//	@Autowired
//	private UserServiceImpl userService;
//	
//	@ModelAttribute("user")
//	public UserRegistrationDto getNewUserRegistrationDto() {
//		return new UserRegistrationDto();
//	}	
//	@GetMapping
//	public String showRegistrationForm() {
//		return "signup";
//	}
//	
////  Save method for return a user JSON ??
////	@Override
////	@PostMapping("/")
////	public ResponseEntity<?> saveEntity(User user) {	
////		try {
////			return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
////		}catch(Exception e) {
////			e.printStackTrace();
////			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible to SAVE the USER entity.\"}");
////		}
////	}
//	
//	@PostMapping
//	public String createUserAccount(@ModelAttribute("user")UserRegistrationDto userRegistrationDto) {
//		try {
//			userService.save(userRegistrationDto);			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "redirect:/signup?success";
//	}
//	
//}
