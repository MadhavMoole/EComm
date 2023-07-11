package com.madhav.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhav.ecommerce.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	
	
}
