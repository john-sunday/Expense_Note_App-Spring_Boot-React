package com.johnsunday.app.controller.security;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.johnsunday.app.entity.BaseEntity;
import com.johnsunday.app.entity.user.security.UserEmployee;

public interface IUserController<E extends BaseEntity,ID extends Serializable> {

	public ResponseEntity<UserEmployee> getByUserUserEmail(@PathVariable String userEmail);
}
