package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.dao.Product;
import com.productapp.dao.ProductRepo;
import com.productapp.exceptions.ProductNotFoundException;
@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepo productRepo;
	
	@Autowired
	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public List<Product> getAll() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(int productId) {
		Product product= productRepo
				.findById(productId)
				.orElseThrow(()-> 
						new ProductNotFoundException("product with id "+productId +" is not found"));
	
		return product;
	}

	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		Product productToUpdate=getProductById(productId);
		productToUpdate.setPrice(product.getPrice());
		
		productRepo.save(productToUpdate);
		
		return productToUpdate;
	}

	@Override
	public Product deleteProduct(int productId) {
		Product productToDelete=getProductById(productId);
		productRepo.delete(productToDelete);
		
		return productToDelete;
	}

}
