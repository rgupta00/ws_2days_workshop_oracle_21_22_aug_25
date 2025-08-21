package com.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/messages")
public class MessageResources {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage() {
		return "hello";
	}
}