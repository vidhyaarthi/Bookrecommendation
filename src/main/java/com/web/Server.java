package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.web.Server;


@SpringBootApplication
@ComponentScan(basePackages = {"com.web.model","com.web.repos","com.web.controller"} )
public class Server {

	 public static void main(String[] args) {
	        SpringApplication.run(Server.class, args);
	    }
	}


