package com.johnsunday.app.entity.user.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.johnsunday.app.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_role")
//@ToString(includeFieldNames = false)
public class UserRole extends BaseEntity{

	private static final long serialVersionUID = 1L;
	@Column(nullable=false,unique=true)
	@Length(min=6,max=25)
	private String roleType;
	@Override
	public String toString() {
		return this.roleType;
	}
	
}
