package com.johnsunday.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnsunday.app.entity.Payroll;
import com.johnsunday.app.service.PayrollServiceImpl;

@CrossOrigin(origins="*")
@RequestMapping("api/v1/payroll")
@RestController
public class PayrollController extends BaseControllerImpl<Payroll, PayrollServiceImpl>{

}
