package com.johnsunday.app.security.service;

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

import com.johnsunday.app.security.dao.IRoleDao;
import com.johnsunday.app.security.dao.IUserDao;
import com.johnsunday.app.security.dto.DtoUser;
import com.johnsunday.app.security.dto.Mapper;
import com.johnsunday.app.security.entity.Role;
import com.johnsunday.app.security.entity.User;
import com.johnsunday.app.service.BaseServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> 
							 implements IUserService, UserDetailsService {
	
	private final String ROLE_USER = "ROLE_USER";
	@Autowired private IUserDao userDao;
	@Autowired private IRoleDao roleDao;
	@Autowired @Lazy private BCryptPasswordEncoder passwordEncoder;	
	
	@Override
	public User save(DtoUser dtoUser) throws Exception{
		try {			
			User newUser = Mapper.dtoToUser(dtoUser);			
			newUser.setUserPassword(passwordEncoder.encode(newUser.getUserPassword()));
			newUser.getUserRoles().add(roleDao.findByRoleType(ROLE_USER).get());
			return userDao.save(newUser);			
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		Optional<User> optionalUser = userDao.findByUserEmail(userEmail);
		if(optionalUser  == null) throw new UsernameNotFoundException("User or Password INVALIDS");
		/* Warning !!! 
		 * We have to implement User constructor:
		 * 'Construct the User with the details required by org.springframework.security.authentication.dao.DaoAuthentication' */
		return new org.springframework.security.core.userdetails.User(
				optionalUser.get().getUserEmail(),
				optionalUser.get().getUserPassword(),
				mappAuthorityRole(optionalUser.get().getUserRoles()));		
	}
	private Collection<? extends GrantedAuthority> mappAuthorityRole(Collection<Role>roles){
		return roles
				.stream()
				.map(role->new SimpleGrantedAuthority(role.getRoleType())).collect(Collectors.toList());
	}

	@Override
	public Optional<User> findByUserEmail(String userEmail) throws Exception {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}
