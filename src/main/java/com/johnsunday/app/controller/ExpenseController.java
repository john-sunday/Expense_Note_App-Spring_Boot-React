package com.johnsunday.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.service.ExpenseServiceImpl;

@CrossOrigin(origins="*")
@RequestMapping("api/v1/expense")
@RestController
public class ExpenseController extends BaseControllerImpl<Expense, ExpenseServiceImpl>{

}
