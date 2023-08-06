package com.madhav.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.madhav.ecommerce.entities.Cart;
import com.madhav.ecommerce.entities.Product;
import com.madhav.ecommerce.entities.User;
import com.madhav.ecommerce.repository.CartRepository;
import com.madhav.ecommerce.repository.ProductRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private ProductRepository productRepo;

	public Cart getCartByCustomer(User user) {
		return cartRepo.findByCustomer(user);
	}

	public void addProductToCart(Cart cartItems, Integer productId) {
		Optional<Product> product = productRepo.findById(productId);
		cartItems.addProducts(product.get());
		cartRepo.save(cartItems);
	}

	public void removeProductFromCart(Cart cartItems, Integer productId) {
		Optional<Product> product = productRepo.findById(productId);
		cartItems.removeProduct(product.get());
		cartRepo.save(cartItems);
	}

	public Page<Cart> getAllCarts() {
		Pageable page = PageRequest.of(1, 5);
		return cartRepo.findAll(page);
	}
}
