package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.dto.ProductDto;
import com.productapp.enitities.Product;
import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.repo.ProductRepo;
import com.productapp.util.ProductDaoConverter;
@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepo productRepo;
	
	@Autowired
	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public List<ProductDto> getAll() {
		return productRepo.findAll().stream()
				.map(product-> ProductDaoConverter.convertToDto(product)).toList();
	}

	@Override
	public ProductDto getProductById(int productId) {
		Product product= productRepo
				.findById(productId)
				.orElseThrow(()-> 
						new ProductNotFoundException("product with id "+productId +" is not found"));
	
		return  ProductDaoConverter.convertToDto(product);
	}

	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product product= productRepo.save(ProductDaoConverter.convertToEntity(productDto));
		return ProductDaoConverter.convertToDto(product);
	}

	@Override
	public ProductDto updateProduct(int productId, ProductDto productDto) {
		
		ProductDto productDtoToUpdate=getProductById(productId);
		productDtoToUpdate.setPrice(productDto.getPrice());
		
		productRepo.save(ProductDaoConverter.convertToEntity(productDtoToUpdate));
		
		return productDtoToUpdate;
	}

	@Override
	public ProductDto deleteProduct(int productId) {
		ProductDto productToDelete=getProductById(productId);
		productRepo.delete(ProductDaoConverter.convertToEntity(productToDelete));
		
		return productToDelete;
	}

}
