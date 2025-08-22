package com.productapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dao.Product;
import com.productapp.service.ProductService;

@RestController
@RequestMapping("productapp/api")
public class ProductController {
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	//get all products
	@GetMapping(path="products")
	public List<Product> getAll(){
		return productService.getAll();
	}
	
	//get by id
	
	//add
	
	//update
	
	///delete

}
