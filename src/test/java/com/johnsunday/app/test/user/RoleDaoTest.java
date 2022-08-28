package com.johnsunday.app.test.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.johnsunday.app.dao.security.IRoleDao;
import com.johnsunday.app.entity.user.security.UserRole;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class RoleDaoTest {

	@Autowired private IRoleDao roleDao;
	
	@Test
	public void createRoleTest() {
		UserRole adminRole = new UserRole("USER_ROLE");
		UserRole userRole = new UserRole("ADMIN_ROLE");
		
		roleDao.saveAll(List.of(adminRole,userRole));
		
		long roleNumbers = roleDao.count();
		assertEquals(2,roleNumbers);
	}
	@Test
	public void testListRoles() {
		List<UserRole>roles = roleDao.findAll();
		
		assertThat(roles.size()).isGreaterThan(0);
		roles.forEach(System.out::println);
	}
}
