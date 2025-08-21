package com.productapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("message")
public class MessageSource {
	
	@Path("demo")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMessageQueryParam(@QueryParam("name")String name,
			@QueryParam("city")String city) {
		String data="hello "+ name+" u are from this "+ city +" city";
		//Response: data + http status code
		return Response.status(200).entity(data).build();
	}
	
	
	@Path("{param}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMessagePathParam(@PathParam("param")String parameter) {
		String data="hello "+ parameter;
		//Response: data + http status code
		return Response.status(200).entity(data).build();
	}
	
	
	@Path("foo")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessageA() {
		return "hello to jax rs jersy A";
	}
	

	@Path("foo1")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessageB() {
		return "hello to jax rs jersy B";
	}
	
	
}
