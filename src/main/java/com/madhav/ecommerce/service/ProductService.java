package com.madhav.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhav.ecommerce.entities.Product;
import com.madhav.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;

	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	public Optional<Product> getProductById(Integer id) {
		return repo.findById(id);
	}
}
