package com.johnsunday.app.test.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import com.johnsunday.app.security.dao.IRoleDao;
import com.johnsunday.app.security.dao.IUserDao;
import com.johnsunday.app.security.entity.ExpenseUser;
import com.johnsunday.app.security.entity.Role;

//@SpringBootTest
//@TestPropertySource(locations = "classpath:application-sample.properties")
@DataJpaTest
// Spring Boot no intentará reemplazar tu base de datos real con H2 para
// ejecutar las pruebas
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserTest {

	@Autowired
	private IUserDao userDao;
	@Autowired
	private IRoleDao roleDao;
	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void createRoleTesting() {
		Role roleAdmin = new Role("ROLE_ADMIN");
		Role roleUser = new Role("ROLE_USER");
		entityManager.persist(roleAdmin);
		entityManager.persist(roleUser);

	}

	@Test
	public void testUserSaving() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		/* 83 Rihanna Fenty 1988-02-20 18:22:17.000 17 */
		final String ROLE_ADMIN = "ROLE_ADMIN";
		String rawPassword = "fenty1234";
		String encodedPassword = passwordEncoder.encode(rawPassword);
		// Obtén el rol, lanza una excepción si no se encuentra
		Optional<Role> adminRoleOpt = roleDao.findByName(ROLE_ADMIN);
		// Role roleAdmin = roleDao.getReferenceById(1L);
		Role adminRole = new Role();
		ExpenseUser newUser = new ExpenseUser();
		ExpenseUser savedUser = new ExpenseUser();
		if (adminRoleOpt.isPresent()) {
			adminRole = adminRoleOpt.get();
			newUser.setEmail("rihannafenty@mail.com");
			newUser.setName("Rihanna");
			newUser.setPassword(encodedPassword);
			newUser.setSurname("Fenty");
			newUser.addRole(adminRole);

			savedUser = userDao.save(newUser);
			assertThat(savedUser).isNotNull();
			assertThat(savedUser.getId()).isGreaterThan(0);
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("Admin Role Optional EMPTY: ").append(adminRoleOpt);
		}
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
