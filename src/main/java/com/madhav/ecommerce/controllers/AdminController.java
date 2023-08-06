package com.madhav.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.madhav.ecommerce.entities.Cart;
import com.madhav.ecommerce.service.CartService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CartService cartService;
	
	@GetMapping("/getAllCarts")
	public String getAllCarts(Model model) {
		Page<Cart> carts = cartService.getAllCarts();
		model.addAttribute("carts", carts);
		return "allcarts";
	}
}
