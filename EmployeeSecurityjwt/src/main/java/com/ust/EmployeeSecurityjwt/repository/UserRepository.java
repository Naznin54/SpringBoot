package com.ust.EmployeeSecurityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.EmployeeSecurityjwt.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	User findByUsername(String username);
	

	
}
