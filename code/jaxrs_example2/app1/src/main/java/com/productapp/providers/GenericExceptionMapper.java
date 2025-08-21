package com.productapp.providers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.productapp.dto.ErrorMessage;
import com.productapp.exceptions.ProductNotFoundException;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setStatusCode(Status.INTERNAL_SERVER_ERROR.getStatusCode());
		errorMessage.setMessage(ex.getMessage());
		errorMessage.setToContact("raj@oracle.com");
		
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}

}
