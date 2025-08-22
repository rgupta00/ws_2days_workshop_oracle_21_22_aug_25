package com.productapp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.productapp.dao.Product;
import com.productapp.service.ProductService;

@SpringBootApplication
@ComponentScan(basePackages = "com.productapp")
public class Productappv1Application implements CommandLineRunner{

	@Autowired
	private ProductService productService;
	

	public static void main(String[] args) {
		SpringApplication.run(Productappv1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productService.addProduct(new Product("laptop",BigDecimal.valueOf(23000)));
		productService.addProduct(new Product("laptop stand",BigDecimal.valueOf(700)));
		
	}

	
}
