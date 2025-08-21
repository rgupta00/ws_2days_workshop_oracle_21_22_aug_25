package com.productapp.providers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.productapp.dto.ErrorMessage;
import com.productapp.exceptions.ProductNotFoundException;

@Provider
public class ProductNotFoundExceptionMapper implements ExceptionMapper<ProductNotFoundException>{

	@Override
	public Response toResponse(ProductNotFoundException ex) {
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setStatusCode(Status.NOT_FOUND.getStatusCode());
		errorMessage.setMessage(ex.getMessage());
		errorMessage.setToContact("raj@oracle.com");
		
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
