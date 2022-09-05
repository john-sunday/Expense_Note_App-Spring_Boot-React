package com.johnsunday.app.security.configuration;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.johnsunday.app.security.dao.IUserDao;
import com.johnsunday.app.security.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		prePostEnabled=true,
		securedEnabled=false,
		jsr250Enabled=false)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired private IUserDao userDao;
	@Autowired private JwtAuthenticationFilter jwtAuthFilter;
	
    @Bean 
    public PasswordEncoder passwordEncoder() { 
    	return new BCryptPasswordEncoder();
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> userDao.findByUserEmail(				
				username).orElseThrow(() -> 				
				new UsernameNotFoundException("User " + username + " NOT found")));
	}	
	@Override 
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.exceptionHandling().authenticationEntryPoint(
				(request,response,ex) -> {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED,ex.getMessage());
				});
		http.authorizeRequests()
			.antMatchers("/api/v1/auth/login").permitAll()		
//		.antMatchers(HttpMethod.GET,"/api/v1/expense").hasAnyRole("ADMIN") 
////			.antMatchers(HttpMethod.POST).hasAnyRole("ADMIN_ROLE","USER_ROLE")
////			.antMatchers(HttpMethod.PUT).hasAnyRole("ADMIN_ROLE","USER_ROLE")
////			.antMatchers(HttpMethod.DELETE,"/api/v1/expense/").hasAnyRole("ADMIN_ROLE")
			.anyRequest().authenticated();
		
		http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
	}	
}
