package com.johnsunday.app.entity.security;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.johnsunday.app.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_role")
public class UserRole extends BaseEntity{

	private static final long serialVersionUID = 1L;
	private String roleType;
}
