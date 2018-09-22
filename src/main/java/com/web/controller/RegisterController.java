package com.web.controller;

import java.io.IOException;
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
public class RegisterController {
	
	private RegisterRepository registerRepository;
	
	@Autowired
	private HttpSession session;
	 
	int userId=0;
	
	 @Autowired
	  public RegisterController(RegisterRepository registerRepository) {
	        this.registerRepository = registerRepository;	        
	    }
	
    @RequestMapping(value="/user", method = RequestMethod.POST,   consumes= "application/x-www-form-urlencoded", path = "/user")
    public String addUser(@RequestParam("username")String name, @RequestParam("password")String password ) throws JsonParseException, JsonMappingException, IOException
    {
    		try {  
    			
				User r=new User();
    	    	r.setUsername(name);
    	    	r.setPassword(password);
    	    	registerRepository.save(r); 
    	    	userId = r.getUserid();	    	    	
    	        session.setAttribute("userId",userId);  	    	    	
    	    	return "registerconfirmation";
	    	    	
    	  } catch(Exception e) {
    			return "failure";
    	  }
    }
}
   
