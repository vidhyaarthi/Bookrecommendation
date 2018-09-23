package com.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.web.model.User;
import com.web.repos.RegisterRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
public class RegisterControllerTest {
	
	 private MockMvc mockMvc;	 
	 

	 @MockBean
	 private RegisterRepository registerRepository; 
	 
	 @InjectMocks
	 private RegisterController registerController;

	@Before
	public void setUp() throws Exception {
		  mockMvc = MockMvcBuilders.standaloneSetup(registerController).build();
	}


	@Test
	public void testRegisterController() throws Exception {
		
		String username="a";
		String password="b";

		  mockMvc.perform(post("/user").param("username", username).param("password",password)
		  .contentType(MediaType.APPLICATION_FORM_URLENCODED))
		  .andExpect(status().isOk());
	}
		
}
