package com.madhav.ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.madhav.ecommerce.entities.User;
import com.madhav.ecommerce.service.UserService;

public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = service.getUserByUserName(username);
		UserDetailsImpl details = new UserDetailsImpl(user); 
		return details;
	}

}
