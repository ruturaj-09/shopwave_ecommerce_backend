package com.shopwave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopwave.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	public User findByEmail(String username);

}
