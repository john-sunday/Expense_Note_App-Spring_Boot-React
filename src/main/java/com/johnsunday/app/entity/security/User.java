package com.johnsunday.app.entity.security;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.johnsunday.app.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_employee",uniqueConstraints=@UniqueConstraint(columnNames="email"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	//@Column(name="email")
	private String email;
	private String password;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(
			name="user_role",
			joinColumns=@JoinColumn(name="user_id",referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="role_id",referencedColumnName="id")
			)	
	private Collection<UserRole>roles;
	
}




