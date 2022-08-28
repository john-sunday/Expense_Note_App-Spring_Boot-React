package com.johnsunday.app.service.security;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.johnsunday.app.dao.security.IUserDao;
import com.johnsunday.app.entity.user.security.UserEmployee;
import com.johnsunday.app.entity.user.security.UserRole;
import com.johnsunday.app.service.BaseServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserEmployee, Integer> 
							 implements IUserService/**, UserDetailsService*/								 
							 {
	@Autowired
	private IUserDao userDao;
	@Autowired
	@Lazy
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserEmployee save(UserEmployee user) throws Exception{
		try {
			//ModelMapper modelMapper = new ModelMapper().map(User, UserRegistrationDto.class);
//			UserEmployee user = new UserEmployee(userDto.getUserDtoName(),
//								 userDto.getUserDtoSurname(),
//								 userDto.getUserDtoEmail(),
//								 passwordEncoder.encode(userDto.getUserDtoPassword()),
//								 Arrays.asList(new UserRole("USER_ROLE")));
			return userDao.save(user);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
//	@Override
//	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
//		Optional<UserEmployee> optionalUser = userDao.findByUserEmail(userEmail);
//		if(optionalUser  == null) throw new UsernameNotFoundException("User or Password INVALIDS");
//		/* Warning !!! 
//		 * We have to implement User constructor:
//		 * 'Construct the User with the details required by org.springframework.security.authentication.dao.DaoAuthentication' */
//		return new org.springframework.security.core.userdetails.User(
//				optionalUser.get().getUserEmail(),
//				optionalUser.get().getUserPassword(),
//				mappAuthorityRole(optionalUser.get().getUserRoles()));		
//	}
//	private Collection<? extends GrantedAuthority> mappAuthorityRole(Collection<UserRole>roles){
//		return roles
//				.stream()
//				.map(role->new SimpleGrantedAuthority(role.getRoleType())).collect(Collectors.toList());
//	}
}
