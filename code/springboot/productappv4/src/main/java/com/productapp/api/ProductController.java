package com.productapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dto.ProductDto;
import com.productapp.enitities.Product;
import com.productapp.service.ProductService;

import jakarta.validation.Valid;

@RestController
//@CrossOrigin("*")
@RequestMapping("productapp/api")
public class ProductController {
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	//ResponseEnitity (bag) = data + status code
	
	//get all products
	@GetMapping(path="products")
	public ResponseEntity<List<ProductDto>> getAll(){	
		return ResponseEntity.status(HttpStatus.OK)
				.body(productService.getAll());
	}
	
	//get by id
	@GetMapping(path="products/{id}")
	public ResponseEntity<ProductDto> getById(@PathVariable("id") int id) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(productService.getProductById(id));
	}
	
	@PostMapping(path="products")
	public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(productDto));
	}
	
	//update
	@PutMapping(path="products/{id}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") int id,
			@RequestBody ProductDto productDto) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, productDto));
	}
	
	
	///delete
	@DeleteMapping(path="products/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") int id) {
		 productService.deleteProduct(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
