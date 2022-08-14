package com.johnsunday.app.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.johnsunday.app.entity.BaseEntity;
import com.johnsunday.app.entity.Expense;

public interface IPayrollController<E extends BaseEntity,ID extends Serializable> {

	public ResponseEntity<?> getAllPayrollByEmployeeId(@PathVariable ID employeeId);
}
