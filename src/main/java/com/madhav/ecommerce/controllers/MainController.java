package com.madhav.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.madhav.ecommerce.entities.Product;
import com.madhav.ecommerce.entities.User;
import com.madhav.ecommerce.service.ProductService;
import com.madhav.ecommerce.service.UserService;

@Controller
public class MainController {

	// Now we have used spring security in our project so it generates a mapping to
	// a login page by default for user authentication

	// By default the username is "User" and password is auto generated and provided
	// in the console

	// we can also set username and password in application.properties

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String getIndexPage(Model model) {
		Page<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "index";
	}

	@GetMapping("/signup")
	public String getSignUpPage(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("user") User user) {
		userService.register(user);
		return "redirect:/mainPage";
	}
}
