package com.johnsunday.app.test.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.johnsunday.app.security.dao.IRoleDao;
import com.johnsunday.app.security.dao.IUserDao;
import com.johnsunday.app.security.entity.ExpenseUser;
import com.johnsunday.app.security.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserTest {

	@Autowired
	IUserDao userDao;
	@Autowired
	IRoleDao roleDao;

	@Test
	public void testUserSaving() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		/* 83 Rihanna Fenty 1988-02-20 18:22:17.000 17 */

		String rawPassword = "fenty1234";
		String encodedPassword = passwordEncoder.encode(rawPassword);
		// Obtén el rol, lanza una excepción si no se encuentra
		Optional<Role> roleAdmin = roleDao.findByName("ROLE_ADMIN");
		// Role roleAdmin = roleDao.getReferenceById(1L);
		// System.out.println(roleAdmin.getName());
		// roleAdmin.setName("ROLE_ADMIN");
		// .orElseThrow(() -> new IllegalArgumentException("Role 'ROLE_ADMIN' not
		// found"));
		ExpenseUser newUser = new ExpenseUser(
				"rihannafenty@mail.com",
				"Rihanna",
				encodedPassword,
				"Fenty",
				Arrays.asList(roleAdmin.get()));
		// newUser.addRole(roleAdmin);

		ExpenseUser savedUser = userDao.save(newUser);

		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getId()).isGreaterThan(0);
	}

	/*
	 * @Test
	 * public void testAssignRoleToUser() {
	 * Optional<ExpenseUser> optUser = userDao.findByEmail("rihannafenty@mail.com");
	 * Optional<Role> optRole = roleDao.findByName("ROLE_ADMIN");
	 * ExpenseUser user = optUser.get();
	 * user.addRole(optRole.get());
	 * ExpenseUser updatedUser = userDao.save(user);
	 * 
	 * assertThat(updatedUser.getRoles().size() == 2);
	 * }
	 */
}
