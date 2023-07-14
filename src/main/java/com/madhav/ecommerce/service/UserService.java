package com.madhav.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhav.ecommerce.entities.User;
import com.madhav.ecommerce.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public User getUserByUserName(String username) {
		return repo.getUserByUserName(username);
	}

	public void register(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}

	
	
}
