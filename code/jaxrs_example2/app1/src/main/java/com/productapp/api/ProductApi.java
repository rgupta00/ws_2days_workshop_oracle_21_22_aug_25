package com.productapp.api;

import java.awt.Taskbar.State;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.productapp.dao.Product;
import com.productapp.service.ProductService;
import com.productapp.service.ProductServiceImpl;

@Path("productapp")
public class ProductApi {

	private ProductService productService = new ProductServiceImpl();

	// Get all

	@Path("products")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAll() {
//		if(1==1)
//			throw new NullPointerException("internal server error pls try after some time");
//		
		return productService.getAll();
	}

	// insert
	@Path("products")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON) // Trigger the parser so that json
											// object send from the postman can be converted to the java object
	public Response inssertProduct(Product product) {
		return Response.status(Status.CREATED)
				.entity(productService.addProduct(product))
				.build();
	}

	// update
	@Path("products/{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON) // Trigger the parser so that json
											// object send from the postman can be converted to the java object
	public Product updateProduct(@PathParam("id") int id, Product product) {
		return productService.updateProduct(id, product);
	}

	// delete
	@Path("products/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProduct(@PathParam("id") int id) {
		 productService.deleteProduct(id);
		 return Response.status(Status.NO_CONTENT).build();
	}

	// find by id
	@Path("products/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByProductId(@PathParam("id") int id) {
		return Response.status(Status.OK).entity(productService.getProductById(id)).build();
	}
}
