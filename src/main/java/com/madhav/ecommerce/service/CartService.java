package com.madhav.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.madhav.ecommerce.repository.CartRepository;

public class CartService {
	
	@Autowired
	private CartRepository repo;

	public void addProductToCart(Integer productID) {
		// TODO Auto-generated method stub
		
	}
}
