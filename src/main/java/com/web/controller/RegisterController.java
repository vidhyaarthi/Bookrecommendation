package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.model.User;
import com.web.repos.RegisterRepository;
import java.io.IOException;

@RestController
public class RegisterController {
	
	private RegisterRepository registerRepository;
	
	 @Autowired
	  public RegisterController(RegisterRepository registerRepository) {
	        this.registerRepository = registerRepository;	        
	    }
	
    @RequestMapping(method = RequestMethod.POST, produces="application/json", consumes="application/json", path = "/user")
    @ResponseBody
    public ResponseEntity<String> addUser(@RequestBody String json) throws JsonParseException, JsonMappingException, IOException
    {
    	System.out.println(" I am inside post method");
    		HttpHeaders responseHeaders = new HttpHeaders();
    		try {
    				
	    	    	User r=new User();
	    	    	ObjectMapper mapper = new ObjectMapper();
	    	    	r = mapper.readValue(json, User.class);
	    	    	registerRepository.save(r);  
	    	    	return new ResponseEntity<String>("New user is successfully added", responseHeaders, HttpStatus.CREATED);
	    	    	
    	  } catch(Exception e) {
    			return new ResponseEntity<String>("Invalid input", responseHeaders, HttpStatus.BAD_REQUEST);
    	  }
    }
    
   
}