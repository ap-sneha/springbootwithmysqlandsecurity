package com.demo.example1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.example1.entity.User;
import com.demo.example1.repository.userRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	userRepo repo;
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	   System.out.println("username = " +username);
	  User user = repo.findByUsername(username);
	  System.out.println("user = "+user);
	  if(user == null) {
		  throw new UsernameNotFoundException("404 not found!!!!!!");
	  }
	
	return new UserPrincipal(user);
//	  return new org.springframework.security.core.userdetails.User(
//	            user.getUsername(),
//	            user.getPassword(),
//	            ((UserDetails) user).getAuthorities()
//	        );
   }
  
}
