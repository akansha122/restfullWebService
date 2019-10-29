package com.zensar.webservice.hello;

import java.time.LocalDate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloParamService {
	@GET
	@Path("/res")
	@Produces("test/html")
	public Response sayHelloUsertResponse(@PathParam("nm")String message)
	{
		Response res=Response.status(200).entity("Hello Jersey").build();
		return res;
	}

	@GET
	@Path("/{res/nm}/{dd}/{mm}/{yy}")
	@Produces("test/html")
	public Response sayHappyBirthday(@PathParam("nm")String name, @PathParam("dd")int date, @PathParam("mm")int month, @PathParam("yy")int year)
	{
		LocalDate birthdate=LocalDate.of(2019, 05, 23);	
		Response res=Response.status(200).entity("Dear"+ name+"Hello Birthday"+ birthdate).build();
		return res;
	}
}
