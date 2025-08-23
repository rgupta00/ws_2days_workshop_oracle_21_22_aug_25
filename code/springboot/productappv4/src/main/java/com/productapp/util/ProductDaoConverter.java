package com.productapp.util;

import com.productapp.dto.ProductDto;
import com.productapp.enitities.Product;

public class ProductDaoConverter {

	public static ProductDto convertToDto(Product product) {
		return new ProductDto(product.getId(), product.getName(), product.getPrice());
	}
	public static Product convertToEntity(ProductDto productDto) {
		return new Product(productDto.getId(), productDto.getName(), productDto.getPrice());
	}
}
