package com.johnsunday.app.security.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.johnsunday.app.security.entity.User;


@Repository
public interface IUserDao extends JpaRepository<User,Integer> {

	public Optional<User> findByEmail(String userEmail);
}
