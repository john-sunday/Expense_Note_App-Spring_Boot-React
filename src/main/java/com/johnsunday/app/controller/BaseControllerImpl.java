package com.johnsunday.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.johnsunday.app.dto.security.UserRegistrationDto;
import com.johnsunday.app.entity.BaseEntity;
import com.johnsunday.app.service.BaseServiceImpl;

public abstract class BaseControllerImpl<E extends BaseEntity,
										 S extends BaseServiceImpl<E, Integer>> 
										 	implements IBaseController<E, Integer> {

	@Autowired
	protected S service;
	
	@GetMapping("/")
	public ResponseEntity<?> getAllEntities(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW all the employees\"}");
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneEntity(@PathVariable("id")Integer id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW the entity who you find.\"}");
		}
	}
	@PostMapping("/")
	public ResponseEntity<?> saveEntity(@RequestBody E entity){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible to SAVE the entity.\"}");
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEntity(@PathVariable("id")Integer id, @RequestBody E entity){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. NOT possible UPDATE the entity who you looking for.\"}");
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEntity(@PathVariable("id")Integer id){
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. Not possible DELETE the entity who you looking for.\"}");
		}
	}
}
