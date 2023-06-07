package com.demo.example1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.example1.entity.User;

@Repository
public interface userRepo extends JpaRepository<User, Integer> {
	
     public User findByUsername(String username);
     
     
}
