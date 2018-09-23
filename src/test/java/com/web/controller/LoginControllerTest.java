package com.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.web.model.User;
import com.web.repos.RegisterRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
public class LoginControllerTest {
	
	 private MockMvc mockMvc;	
	 
	 @MockBean
	 private RegisterRepository registerRepository; 	
	 
	 @InjectMocks
	 private User user;	
	 
	 @InjectMocks
	 private LoginController loginController;	 
 
	 
	@Before
	public void setUp() throws Exception {
		  mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
	}


	@Test
	public void testUser() throws Exception {
		
			List<User> users = new ArrayList<User>();
			String username="a";
			String password="b";
	
			user.setUsername(username);
			user.setPassword(password);
			users.add(user);
			
			Mockito.when(registerRepository.findAll()).thenReturn(users);		
			mockMvc.perform(post("/userlogin").param("username", username).param("password", password)
											  .contentType(MediaType.APPLICATION_FORM_URLENCODED))
											  .andExpect(status().isOk());
			
	}
		
}
