package com.productapp.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.productapp.dao.Product;
import com.productapp.service.ProductService;
import com.productapp.service.ProductServiceImpl;

@Path("productapp")
public class ProductApi {
	
	private ProductService productService=new ProductServiceImpl();
	
	@Path("products")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAll(){
		return productService.getAll();
	}
	

}
