package com.madhav.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	// Now we have used spring security in our project so it generates a mapping to
	// a login page by default for user authentication
	
	//By default the username is "User" and password is auto generated and provided in the console
	
	//we can also set username and password in application.properties
	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}
}
