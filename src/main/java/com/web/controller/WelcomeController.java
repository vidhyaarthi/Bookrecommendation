package com.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WelcomeController {
	

	@RequestMapping("/")	
	public String welcome() {	
		return "register";
	}

}