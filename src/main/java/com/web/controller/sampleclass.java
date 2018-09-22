package com.web.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sampleclass {
	
	public static void main(String args[]) throws IOException
	{
		 
         
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sampleclass.class.getClass().getClassLoader().getResourceAsStream("/books.txt")));
	        
	        
	        String line = null;
	         
	        while ((line = bufferedReader.readLine()) != null) 
	        {
	          System.out.println("Line>>>>>>" +line);
	        }    
	        
	}

}
