package com.madhav.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.madhav.ecommerce.entities.Product;
import com.madhav.ecommerce.repository.ProductRepository;

public class ProductService {
	
	@Autowired
	private ProductRepository repo;

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Optional<Product> getProductById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}
}
