package com.johnsunday.app.security.service;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.johnsunday.app.entity.Employee;
import com.johnsunday.app.security.dao.IRoleDao;
import com.johnsunday.app.security.dao.IUserDao;
import com.johnsunday.app.security.entity.Role;
import com.johnsunday.app.security.entity.User;
import com.johnsunday.app.service.EmployeeServiceImpl;

@Service
public class UserServiceImpl implements IUserService,UserDetailsService {
	
	private final String ROLE_USER = "ROLE_USER";
	@Autowired private IUserDao userDao;
	@Autowired private IRoleDao roleDao;
	@Autowired @Lazy private BCryptPasswordEncoder passwordEncoder;
	@Autowired private EmployeeServiceImpl employeeService;
	
	@Override
	@Transactional
	public User save(User user) throws Exception {
		User savedUser = new User();
		try {
			Employee employee = employeeService.findByEmail(user.getEmail());
			if (employee!=null) {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				if((user.getRoles()==null)||(user.getRoles().size()==0)) user.getRoles().add(roleDao.findByName(ROLE_USER).get());				 
				
				savedUser = userDao.save(user);	
			}
		}catch(Exception e) {
			System.out.println("e.getCause(): " + e.getCause());
			e.printStackTrace();
			throw new Exception(e.getCause());
		}
		return savedUser;
	}
	@Override
	@Transactional
	public User update(Integer userId,User user) throws Exception {
		User updatedUser = new User();
		try {
			Optional<User>optionalUser = userDao.findById(userId);
			if (!optionalUser.isEmpty()) {
				 updatedUser = userDao.save(optionalUser.get());			
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return updatedUser;
	}
	// Load an User by 'email', NOT name.
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
	public Collection<? extends GrantedAuthority> mappAuthorityRole(Collection<Role>roles) {
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
		return userDao.findAll();
	}
	@Override
	public Optional<User> findById(Integer id) throws Exception {
		Optional<User>optUser = userDao.findById(id);
		return optUser;
	}
	@Override
	@Transactional
	public Boolean delete(Integer id) throws Exception {
		boolean isDeleted = false;
		Optional<User>optUser = userDao.findById(id);
		if (optUser!=null) {
			userDao.delete(optUser.get());
			isDeleted = true;
		}
		return isDeleted;
	}
}
