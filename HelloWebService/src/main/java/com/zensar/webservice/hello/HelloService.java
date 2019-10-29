package com.zensar.webservice.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainHello() {
		return "welcome to zensar hello service";
	}

	@Path("/html")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String HTMLHello() {
		return "<h1>" + "welcome to zensar" + "</h1>";
	}

	@Path("/xml")
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version='1.0'?><hello>Welcome to zensar XML</hello>";
	}
}
