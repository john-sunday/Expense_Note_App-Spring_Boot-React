package com.johnsunday.app.entity.user.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.johnsunday.app.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_employee",uniqueConstraints=@UniqueConstraint(columnNames="user_email"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserEmployee extends BaseEntity 
 						  implements UserDetails  {

	private static final long serialVersionUID = 1L;

	@Column(name="user_name",nullable=false)
	@Length(min=2,max=50)
	private String userName;
	@Column(name="user_surname",nullable=false)
	@Length(min=2,max=128)
	private String userSurname;
	@Column(name="user_email",nullable=false)
	@Length(min=3,max=50)
	private String userEmail;
	@Column(name="user_password",nullable=false)
	@Length(min=4,max=64)
	private String userPassword;

	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(
			name="useremployee_userrole",
			joinColumns=@JoinColumn(name="user_id",referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="role_id",referencedColumnName="id")
			)	
	private Collection<UserRole>userRoles = new HashSet<>();
	public void addRole(UserRole role) {
		this.userRoles.add(role);
	}
	public void removeRole(UserRole role) {
		this.userRoles.remove(role);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority>authorities = new ArrayList<>();
		for(UserRole role:this.userRoles) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleType()));
		}
		return authorities;
	}
	@Override
	public String getPassword() {
		return this.userPassword;
	}
	@Override
	public String getUsername() {
		return this.userEmail;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}	
}




