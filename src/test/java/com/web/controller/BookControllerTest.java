package com.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class BookControllerTest {
	
	 private MockMvc mockMvc;	 
	 
	 
	 @InjectMocks
	 private BookController bookController;

	@Before
	public void setUp() throws Exception {
		  mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
	}


	@Test
	public void testBookController() throws Exception {
		
		  mockMvc.perform(post("/userfeedback")
		  .contentType(MediaType.APPLICATION_FORM_URLENCODED))
		  .andExpect(status().isOk());
	}
		
}
