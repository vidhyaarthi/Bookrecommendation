package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.web.model.Book;
import com.web.model.UserFeedback;
import com.web.repos.BookRepository;
import com.web.repos.FeedbackRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BookController {
	
	@Autowired
	private HttpSession session;
	
	private BookRepository bookRepository;
	private FeedbackRepository feedbackRepository;
	
	 @Autowired
	  public BookController(BookRepository bookRepository,FeedbackRepository feedbackRepository) {
	        this.bookRepository = bookRepository;	        
	        this.feedbackRepository = feedbackRepository;
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
	         List<Book> booklist = new ArrayList<Book>();

             String bookids ="";
             String bookstitle="";
             int n=0;
             
             for (Book b : books) {
            	 
	             booklist.add(b);
	             Collections.shuffle(booklist);
             }             
             
	         for (Book b : booklist) {
	        	 
		             String bookid = "";
		             String booktitle = "";
		             bookid = String.valueOf(b.getBookid());
		             booktitle= b.getBooktitle();
			             
				             if(n<20)
				             {
					             bookids += bookid + ",";
					             bookstitle += booktitle + ",";
					             n++;
				             }	             
	         			}
	         
	         session.setAttribute("bookids", bookids);
	         session.setAttribute("bookstitle", bookstitle);
	         
	         if (bookids.isEmpty()) {
	        	   return "bookfailure";
	         } else {
	             return "display";
	         }
	     }


	 
	  @RequestMapping(value="/userfeedback", method = RequestMethod.POST,   consumes= "application/x-www-form-urlencoded", path = "/userfeedback")
	    public String addStatus(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException
	    {
	    		try {     			
	    			
	    			String bookids = (String)session.getAttribute("bookids");
	    			String bookidsarr[] = bookids.split(",");	    			
	    			int userid = (Integer) session.getAttribute("userId");
	    			String status = "";
	    			
	    			for(int i=0;i<bookidsarr.length;i++)	    			
	    			{
	    				String req = "value" + Integer.toString(i);
	    				status= request.getParameter(req);
	    				
	    				UserFeedback u = new UserFeedback();
	    				u.setUserid(userid);
	    				u.setBookid(Integer.parseInt(bookidsarr[i]));
	    				u.setStatus(status);
	    				feedbackRepository.save(u); 
	    			} 
	    			
	    			return "result";	
		    	    	
	    	  } catch(Exception e) {
	    			return "feedbackfailure";
	    	  }
	    }
	    
}

