package com.johnsunday.app.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.johnsunday.app.dao.IEmployeeDao;
import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.security.dao.IUserDao;
import com.johnsunday.app.security.entity.ExpenseUser;
import com.johnsunday.app.security.jwt.JwtAuthenticationUtil;

public class EmployeeUtil {

	@Autowired
	private static IEmployeeDao employeeDao;
	@Autowired
	private static JwtAuthenticationUtil jwtAuthUtil;
	@Autowired
	private static IUserDao userDao;

	public static Boolean existsInDb(Employee employee) {
		boolean exists = false;
		try {
			if ((employeeDao.findById(employee.getId())) != null) {
				exists = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exists;
	}

	public Boolean matchEmployeeUserEmail(Employee employee, String token) throws Exception {
		boolean isMatch = false;
		long tokenUserId = jwtAuthUtil.extractTokenUserId(token);
		Optional<ExpenseUser> optTokenUser = userDao.findById(tokenUserId);
		if (optTokenUser.get().getEmail().equalsIgnoreCase(employee.getEmail()))
			isMatch = true;
		else
			throw new Exception("ERROR -> The token user email DOESN'T MATCH with the employee email.");
		return isMatch;
	}
}
