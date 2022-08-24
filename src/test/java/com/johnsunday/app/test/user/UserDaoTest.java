package com.johnsunday.app.test.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.johnsunday.app.dao.security.IUserDao;
import com.johnsunday.app.entity.security.UserEmployee;
import com.johnsunday.app.entity.security.UserRole;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserDaoTest {

	@Autowired IUserDao userDao;
	
	@Test
	public void testSaveUser() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "neil1234";
		String encodedPassword = passwordEncoder.encode(rawPassword);
		
		UserEmployee newUser = new UserEmployee("Neil","Percival Young","neilyoung@gmail.com",encodedPassword,Arrays.asList(new UserRole("USER_ROLE")));
		UserEmployee savedUser = userDao.save(newUser);
		
		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
}
