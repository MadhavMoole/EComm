package com.madhav.ecommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.madhav.ecommerce.entities.Product;
import com.madhav.ecommerce.entities.User;
import com.madhav.ecommerce.service.CartService;
import com.madhav.ecommerce.service.ProductService;
import com.madhav.ecommerce.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@ComponentScan(basePackages = "com.madhav.ecommerce.security")
public class MainController {

	// Now we have used spring security in our project so it generates a mapping to
	// a login page by default for user authentication
	
	//By default the username is "User" and password is auto generated and provided in the console
	
	//we can also set username and password in application.properties
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}
	
	@GetMapping("/mainPage")
	public String getMainPage(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("Products", products);
		return "main-page";
	}
	
	@GetMapping("/signup")
	public String getSignUpPage(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@GetMapping("/register")
	public String register(@ModelAttribute("user")User user) {
		
		userService.register(user);
		return "redirect:/mainPage";
	}
	
	@GetMapping("/displayProduct")
	public String displayproduct(Integer id, HttpSession session) {
		Optional<Product> product = productService.getProductById(id);
		session.setAttribute("product", product);
		return "product-page";
	}	
	
	@PostMapping("addToCart")
	public String addToCart(Integer ProductID) {
		return "redirect:/displayProduct";
	}
}
