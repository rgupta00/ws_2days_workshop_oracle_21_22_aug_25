package com.productapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.productapp")
public class Productappv1Application {

	
	
	public static void main(String[] args) {
		SpringApplication.run(Productappv1Application.class, args);
	}

	
}
