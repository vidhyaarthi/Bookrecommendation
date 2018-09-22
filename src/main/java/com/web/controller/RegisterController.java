package com.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    @RequestMapping(method = RequestMethod.GET, produces="application/json", path = "/user")
    @ResponseBody
    public ResponseEntity<String> getUsers() throws JsonParseException, JsonMappingException, IOException
    {	
    	 Iterable<User> users = registerRepository.findAll();
         String userResponse = "";


         for (User user : users) {
             String userObj = null;
             try {
                 userObj = new JSONObject()
                         .put("id", String.valueOf(user.getUserid()))
                         .put("name", user.getUsername())
                         .toString();
             } catch (JSONException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }

             userResponse += userObj + ",";
         }
         if (userResponse.isEmpty()) {
        	   return ResponseEntity.ok("{\"users\":[]}");
         } else {
             return ResponseEntity.ok("{\"users\":[" + userResponse.substring(0, userResponse.length() - 1) + "]}");
         }
    }
}
   
