package com.madhav.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhav.ecommerce.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>{

}
