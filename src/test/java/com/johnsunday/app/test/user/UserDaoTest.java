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
import com.johnsunday.app.security.entity.User;
import com.johnsunday.app.security.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserDaoTest {

	@Autowired IUserDao userDao;
	@Autowired IRoleDao roleDao;
	
	@Test
	public void testSaveUser() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "otis1234";
		String encodedPassword = passwordEncoder.encode(rawPassword);
		
		User newUser = new User(
				"Otis",
				"Ray Redding",
				"otisredding@gmail.com",
				encodedPassword,
				//Arrays.asList(new UserRole("ROLE_ADMIN"))
				Arrays.asList(roleDao.findByRoleType("ROLE_ADMIN").get())
				);
		User savedUser = userDao.save(newUser);
		
		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	@Test
	public void assignRoleToUser() {
		Optional<User>optUser = userDao.findByUserEmail("neilyoung@gmail.com");
		Optional<Role>optRole = roleDao.findByRoleType("ADMIN_ROLE");
		User user = optUser.get();
		user.addRole(optRole.get());
		User updatedUser = userDao.save(user);
		
		assertThat(updatedUser.getUserRoles().size()==2);		
	}
}
