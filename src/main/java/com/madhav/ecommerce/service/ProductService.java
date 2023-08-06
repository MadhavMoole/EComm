package com.madhav.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.madhav.ecommerce.entities.Product;
import com.madhav.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public Page<Product> getAllProducts() {
		Pageable pageable = PageRequest.of(1, 10);
		return repo.findAll(pageable);
	}

	public Optional<Product> getProductById(Integer id) {
		return repo.findById(id);
	}
}
