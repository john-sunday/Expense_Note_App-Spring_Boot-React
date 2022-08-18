package com.johnsunday.app.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.johnsunday.app.entity.BaseEntity;

public interface IPayrollController<E extends BaseEntity,ID extends Serializable> {

	public ResponseEntity<?> getAllPayrollByEmployeeId(@PathVariable ID employeeId);
}
