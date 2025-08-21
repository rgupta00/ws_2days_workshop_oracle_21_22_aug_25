package com.productapp.dao;

import java.util.List;

public interface ProductDao {
	public List<Product> getAll();
	public Product getProductById(int productId);
	public Product addProduct(Product book);
	public Product updateProduct(int productId, Product product);
	public Product deleteProduct(int productId);
	
}