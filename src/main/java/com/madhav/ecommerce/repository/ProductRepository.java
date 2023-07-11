package com.madhav.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madhav.ecommerce.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
