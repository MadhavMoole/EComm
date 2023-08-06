package com.madhav.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.madhav.ecommerce.entities.User;
import com.madhav.ecommerce.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public User getUserByUserName(String username) {
		return repo.getUserByUserName(username);
	}

	public void register(User user) {
		String password = user.getPassword();
		user.setPassword(encoder.encode(password));
		user.setRole("USER");
		repo.save(user);
	}

	
	
}
