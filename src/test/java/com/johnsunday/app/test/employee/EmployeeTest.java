package com.johnsunday.app.test.employee;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.johnsunday.app.dao.IEmployeeDao;
import com.johnsunday.app.dao.IEmployeeTypeDao;
import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.entity.Payroll;
import com.johnsunday.app.util.DateUtil;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class EmployeeTest {

	@Autowired IEmployeeDao employeeDao;
	@Autowired IEmployeeTypeDao employeeTypeDao;
	
	@Test
	@DisplayName(value="Test 1 -> test employee saving\n"
			+ "1.1 - savedEmployee.isNotNull()\n"
			+ "1.2 - savedEmployee.getId().isGreaterThan(0)\n")
	public void testEmployeeSaving() {
		
		Employee newEmployee = new Employee(
				"Marvin",
				"Pentz Gay",
				DateUtil.formattingDate(LocalDateTime.of(1978,07,22,22,35,18)),
				employeeTypeDao.findByNameIgnoreCase("devops").get(),
				"marvingay@gmail.com"
				);
		Employee savedEmployee = employeeDao.save(newEmployee);
		
		assertThat(savedEmployee).isNotNull();
		assertThat(savedEmployee.getId()).isGreaterThan(0);
	}
	@Test
	public void testEmployeeUpdating() {
		Optional<Employee>oldEmployee = employeeDao.findByNameAndSurnameAllIgnoreCase("Marvin", "Pentz Gay");
		
		// Test.
		System.out.println("Old Employee --> " + oldEmployee.toString());
		
		Employee updatedEmployee = null;
		if(oldEmployee!=null) {
			Employee employeeToUp = new Employee(
					56,
					"Marvin",
					"Pentz Gay Jr",
					DateUtil.formattingDate(LocalDateTime.of(1978,07,22,22,35,18)),
					employeeTypeDao.findByNameIgnoreCase("devops").get(),
					"marvingay@gmail.com",
					new ArrayList<Expense>(),
					new ArrayList<Payroll>()
					);
			updatedEmployee = employeeDao.save(employeeToUp);
		}
		
		assertThat(updatedEmployee).isNotNull();
		assertThat(updatedEmployee.getId()).isGreaterThan(0);
	}
}
