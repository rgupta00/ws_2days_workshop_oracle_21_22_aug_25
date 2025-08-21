package com.productapp.service;

import java.util.List;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
import com.productapp.dao.ProductDaoImplUsingMap;
import com.productapp.exceptions.ProductNotFoundException;

public class ProductServiceImpl implements ProductService{

	private ProductDao productDao=new ProductDaoImplUsingMap();
	
	@Override
	public List<Product> getAll() {
		return productDao.getAll();
	}

	@Override
	public Product getProductById(int productId) {
		Product product= productDao.getProductById(productId);
		if(product==null) {
			throw new ProductNotFoundException("product with id "+productId +" is not found");
		}
		return product;
	}

	@Override
	public Product addProduct(Product product) {
		return productDao.addProduct(product);
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		return productDao.updateProduct(productId, product);
	}

	@Override
	public Product deleteProduct(int productId) {
		return productDao.deleteProduct(productId);
	}

}
