package com.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {	

	@RequestMapping(path="/", method = RequestMethod.GET,   produces="application/json")	
	public String welcome() {	
		return "register";
	}

}