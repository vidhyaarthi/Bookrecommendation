package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.web.model.Book;
import com.web.repos.BookRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpSession;

@Controller
public class BookController {
	
	@Autowired
	private HttpSession session;
	
	private BookRepository bookRepository;
	
	 @Autowired
	  public BookController(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;	        
	    }

	 @RequestMapping(method = RequestMethod.GET, produces="application/json", path = "/user/{userId}/book")
	    public String listBooks() throws JsonParseException, JsonMappingException, IOException
	    {	
		 	ClassLoader classLoader = getClass().getClassLoader();
		 	
		    File file = new File(classLoader.getResource("books.txt").getFile());
		    
		    Book book = new Book();
		    
		    InputStream inputStream = null;
		    
		    inputStream = new FileInputStream(file);
		  
		    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		    
		    String line = null;
	         
	        while ((line = bufferedReader.readLine()) != null) 
	        {	        	
	    		String[] output = line.split("\\;");
	    		book.setBookid(Integer.parseInt(output[0]));
	    		book.setBooktitle(output[1]);
	    		book.setAuthor(output[2]);
	    		book.setGenre(output[3]);
	    		bookRepository.save(book);
	        }     	        
	              
	         Iterable<Book> books = bookRepository.findAll();

             String bookids ="";
             String bookstitle="";

	         for (Book b : books) {
	        	 
	             String bookid = "";
	             String booktitle = "";
	             bookid = String.valueOf(b.getBookid());
	             booktitle= b.getBooktitle();

	             bookids += bookid + ",";
	             bookstitle += booktitle + ",";
	             
	         }
	         
	         session.setAttribute("bookids", bookids);
	         session.setAttribute("bookstitle", bookstitle);
	         
	         if (bookids.isEmpty()) {
	        	   return "bookfailure";
	         } else {
	             return "display";
	         }
	     }
	 }

