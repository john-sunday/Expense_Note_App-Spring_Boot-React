package com.johnsunday.app.service.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.johnsunday.app.dao.security.IUserDao;
import com.johnsunday.app.dto.security.UserRegistrationDto;
import com.johnsunday.app.entity.security.User;
import com.johnsunday.app.entity.security.UserRole;
import com.johnsunday.app.service.BaseServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> 
							 implements IUserService {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User save(UserRegistrationDto userRegistrationDto) throws Exception{
		try {
			//ModelMapper modelMapper = new ModelMapper().map(User, UserRegistrationDto.class);
			User user = new User(userRegistrationDto.getName(),
								 userRegistrationDto.getSurname(),
								 userRegistrationDto.getEmail(),
								 passwordEncoder.encode(userRegistrationDto.getPassword()),
								 Arrays.asList(new UserRole("USER_ROLE")));
			return userDao.save(user);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByEmail(username);
		if(user == null) throw new UsernameNotFoundException("User or Password INVALIDS");
		/* Warning !!! 
		 * We have to implement User constructor:
		 * 'Construct the User with the details required by org.springframework.security.authentication.dao.DaoAuthentication' */
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mappAuthorityRole(user.getRoles()));		
	}
	private Collection<? extends GrantedAuthority> mappAuthorityRole(Collection<UserRole>roles){
		return roles
				.stream()
				.map(role->new SimpleGrantedAuthority(role.getRoleType())).collect(Collectors.toList());
	}
}
