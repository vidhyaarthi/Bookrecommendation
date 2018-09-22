package com.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.web.model.User;
import com.web.repos.RegisterRepository;

@Controller
public class LoginController {

	private RegisterRepository registerRepository;
	
	@Autowired
	private HttpSession session;
	 
	int userId=0;

	 @Autowired
	  public LoginController(RegisterRepository registerRepository) {
	        this.registerRepository = registerRepository;	        
	    }
	 
    @RequestMapping(value="/userlogin", method = RequestMethod.POST,   consumes= "application/x-www-form-urlencoded", path = "/userlogin")
    public String checkUser(@RequestParam("username")String name, @RequestParam("password")String password ) throws JsonParseException, JsonMappingException, IOException
    {
    		try {
    			
    			 Iterable<User> users = registerRepository.findAll();
    	         
    	        	 for (User user : users) {  

    	                 if(!((user.getUsername().equals(name))&&(user.getPassword().equals(password))))
    	                 {
    	                	 throw new Exception();
    	                 }
    	                 
    	                 	userId = user.getUserid();	  
	    	    	        session.setAttribute("userId",userId);  	
    	             	}
    	        	 
    	        	 return "book";
    	         	}
    	              catch(Exception e) {
    	     				
    	     				return "loginfailure";
    	     			}  
    	}
    
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET,   produces="application/json", path = "/login")
    public String checkUser() throws JsonParseException, JsonMappingException, IOException
    {
    		try { 
    			return "success";	    	    	
    		}
    		catch(Exception e) {    				
    			return "loginfailure";
     		}
    }
	
	@RequestMapping(value="/logout", method = RequestMethod.POST,  consumes= "application/x-www-form-urlencoded", path = "/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException
    {
    		try { 
    			request.getSession().invalidate();
    			return "success";
    		}
    		catch(Exception e) {    				
    			return "success";
     		}
    }
 }