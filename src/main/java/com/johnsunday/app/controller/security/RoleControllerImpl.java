package com.johnsunday.app.controller.security;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnsunday.app.controller.BaseControllerImpl;
import com.johnsunday.app.entity.user.security.UserRole;
import com.johnsunday.app.service.security.RoleServiceImpl;

@CrossOrigin(origins="*")
@RequestMapping("api/v1/role")
@RestController
public class RoleControllerImpl extends BaseControllerImpl<UserRole, RoleServiceImpl>{	
	
}
