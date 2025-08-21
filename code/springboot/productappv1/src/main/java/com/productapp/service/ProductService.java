package com.productapp.service;

import java.util.List;

import com.productapp.dao.Product;

public interface ProductService {
	public List<Product> getAll();
	public Product getProductById(int productId);
	public Product addProduct(Product book);
	public Product updateProduct(int productId, Product product);
	public Product deleteProduct(int productId);
}
