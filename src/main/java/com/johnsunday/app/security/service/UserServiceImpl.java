package com.johnsunday.app.security.service;

import java.util.Collection;
import java.util.List;
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
import com.johnsunday.app.security.dto.UserMapper;
import com.johnsunday.app.security.entity.Role;
import com.johnsunday.app.security.entity.User;

@Service
public class UserServiceImpl implements IUserService,UserDetailsService {
	
	private final String ROLE_USER = "ROLE_USER";
	@Autowired private IUserDao userDao;
	@Autowired private IRoleDao roleDao;
	@Autowired @Lazy private BCryptPasswordEncoder passwordEncoder;	
	
	@Override
	public User save(DtoUser dtoUser) throws Exception{
		try {			
			User newUser = UserMapper.dtoToUserWithId(dtoUser);			
			newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
			newUser.getRoles().add(roleDao.findByName(ROLE_USER).get());
			return userDao.save(newUser);			
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public User update(Integer userId, DtoUser dtoUser) throws Exception {
		User updatedUser = null;
		try {
			User userToUpdate = UserMapper.dtoToUserWithId(dtoUser);
			Optional<User>optionalUser = userDao.findById(userId);
			if (!optionalUser.isEmpty()) {
				updatedUser = userDao.save(userToUpdate);			
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}		
		return updatedUser;
	}
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		Optional<User> optionalUser = userDao.findByEmail(userEmail);
		if(optionalUser  == null) throw new UsernameNotFoundException("User or Password INVALIDS");
		/* Warning !!! 
		 * We have to implement User constructor:
		 * 'Construct the User with the details required by org.springframework.security.authentication.dao.DaoAuthentication' */
		return new org.springframework.security.core.userdetails.User(
				optionalUser.get().getEmail(),
				optionalUser.get().getPassword(),
				mappAuthorityRole(optionalUser.get().getRoles()));		
	}
	private Collection<? extends GrantedAuthority> mappAuthorityRole(Collection<Role>roles){
		return roles
				.stream()
				.map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	@Override
	public Optional<User> findByEmail(String userEmail) throws Exception {
		User searchedUser = null;
		Optional<User> optionalUser = userDao.findByEmail(userEmail);
		if (!optionalUser.isEmpty()) {
			searchedUser = optionalUser.get();
		}
		return Optional.of(searchedUser);
	}
	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
