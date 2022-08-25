package com.johnsunday.app.controller.security;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnsunday.app.controller.BaseControllerImpl;
import com.johnsunday.app.entity.security.UserRole;
import com.johnsunday.app.service.security.UserRoleServiceImpl;

@CrossOrigin(origins="*")
@RequestMapping("api/v1/user_role")
@RestController
public class UserRoleControllerImpl extends BaseControllerImpl<UserRole, UserRoleServiceImpl>{	
	
}
