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

import com.johnsunday.app.dao.security.IRoleDao;
import com.johnsunday.app.dao.security.IUserDao;
import com.johnsunday.app.entity.user.security.UserEmployee;
import com.johnsunday.app.entity.user.security.UserRole;

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
		
		UserEmployee newUser = new UserEmployee(
				"Otis",
				"Ray Redding",
				"otisredding@gmail.com",
				encodedPassword,
				//Arrays.asList(new UserRole("USER_ROLE"))
				Arrays.asList(roleDao.findById(13).get())
				);
		UserEmployee savedUser = userDao.save(newUser);
		
		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	@Test
	public void assignRoleToUser() {
		Optional<UserEmployee>optUser = userDao.findByUserEmail("neilyoung@gmail.com");
		Optional<UserRole>optRole = roleDao.findByRoleType("ADMIN_ROLE");
		UserEmployee user = optUser.get();
		user.addRole(optRole.get());
		UserEmployee updatedUser = userDao.save(user);
		
		assertThat(updatedUser.getUserRoles().size()==2);		
	}
}
