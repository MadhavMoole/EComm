package com.madhav.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhav.ecommerce.entities.Cart;
import com.madhav.ecommerce.entities.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	Cart findByCustomer(User user);
}
