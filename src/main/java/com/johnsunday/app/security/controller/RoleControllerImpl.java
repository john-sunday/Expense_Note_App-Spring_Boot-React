package com.johnsunday.app.security.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnsunday.app.controller.BaseControllerImpl;
import com.johnsunday.app.security.entity.Role;
import com.johnsunday.app.security.service.RoleServiceImpl;

@CrossOrigin(origins="*")
@RequestMapping("api/v1/role")
@RestController
public class RoleControllerImpl extends BaseControllerImpl<Role, RoleServiceImpl>{	
	
}
