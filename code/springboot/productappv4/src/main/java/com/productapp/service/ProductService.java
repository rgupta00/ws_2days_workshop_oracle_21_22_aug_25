package com.productapp.service;

import java.util.List;

import com.productapp.dto.ProductDto;
import com.productapp.enitities.Product;

public interface ProductService {
	public List<ProductDto> getAll();
	public ProductDto getProductById(int productId);
	public ProductDto addProduct(ProductDto productDto);
	public ProductDto updateProduct(int productId, ProductDto productDto);
	public ProductDto deleteProduct(int productId);
}
