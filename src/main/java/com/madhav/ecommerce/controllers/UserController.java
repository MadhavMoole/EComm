package com.madhav.ecommerce.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.madhav.ecommerce.entities.Cart;
import com.madhav.ecommerce.entities.Product;
import com.madhav.ecommerce.entities.User;
import com.madhav.ecommerce.service.CartService;
import com.madhav.ecommerce.service.ProductService;
import com.madhav.ecommerce.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/mainPage")
public class UserController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;

	@Autowired
	private UserService userService;
	
	@GetMapping
	public String getMainPage(Model model) {
		Page<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "main-page";
	}
	
	@GetMapping("/displayProduct")
	public String displayproduct(Integer id, HttpSession session) {
		Optional<Product> product = productService.getProductById(id);
		session.setAttribute("product", product);
		return "product-page";
	}

	@PostMapping("/addToCart")
	public String addToCart(Integer productId, Principal principal) {
		User user = userService.getUserByUserName(principal.getName());
		Cart cartItems = cartService.getCartByCustomer(user);
		cartService.addProductToCart(cartItems, productId);
		return "redirect:/cart";
	}

	@PostMapping("/deleteProductFromCart")
	public String deleteFromCart(Integer productId, Principal principal) {
		User user = userService.getUserByUserName(principal.getName());
		Cart cartItems = cartService.getCartByCustomer(user);
		cartService.removeProductFromCart(cartItems, productId);
		return "redirect:/cart";
	}

	@GetMapping("/cart")
	public String getCart(Model model, Principal principal) {
		User user = userService.getUserByUserName(principal.getName());
		Cart cartItems = cartService.getCartByCustomer(user);
		model.addAttribute("cart", cartItems);
		return "cart";
	}
}
