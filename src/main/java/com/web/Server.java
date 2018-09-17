package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.web.Server;


@SpringBootApplication
@ComponentScan("com.web")
public class Server {

	 public static void main(String[] args) {
	        SpringApplication.run(Server.class, args);
	    }
	}


