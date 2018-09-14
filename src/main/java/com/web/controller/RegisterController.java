package com.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.model.Register;
import com.web.repos.RegisterRepository;


import java.io.IOException;

@RestController
public class RegisterController {
	
	RegisterRepository registerrepository;
	
	 @Autowired
	  public RegisterController(RegisterRepository registerrepository) {
	        this.registerrepository = registerrepository;	        
	    }
	
    @RequestMapping(method = RequestMethod.POST, produces="application/json", consumes="application/json", path = "/user")
    @ResponseBody
    public ResponseEntity addUser(@RequestBody String json) throws JsonParseException, JsonMappingException, IOException
    {
    		HttpHeaders responseHeaders = new HttpHeaders();
    		try {
    				
	    	    	Register r=new Register();
	    	    	ObjectMapper mapper = new ObjectMapper();
	    	    	r = mapper.readValue(json, Register.class);
	    	    	registerrepository.save(r);  
	    	    	return new ResponseEntity<String>("New user is successfully added", responseHeaders, HttpStatus.CREATED);
	    	    	
    	  } catch(Exception e) {
    			return new ResponseEntity<String>("Invalid input", responseHeaders, HttpStatus.BAD_REQUEST);
    	  }
    }
    
   
}