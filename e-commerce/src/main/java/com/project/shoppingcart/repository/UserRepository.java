package com.project.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shoppingcart.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
