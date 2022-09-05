package com.johnsunday.app.security.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.johnsunday.app.entity.BaseEntity;
import com.johnsunday.app.security.entity.User;

public interface IUserController<E extends BaseEntity,ID extends Serializable> {

	public ResponseEntity<User> findByUserEmail(@PathVariable String userEmail);
}
