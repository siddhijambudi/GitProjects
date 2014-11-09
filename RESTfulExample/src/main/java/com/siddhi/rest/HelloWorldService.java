package com.siddhi.rest;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldService {
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg; 
		return Response.status(200).entity(output).build();
 
	}
	
	@GET
    @Path("/print/{name}")
    @Produces("application/json")
    public Student produceJSON( @PathParam("name") String name ) {
        Student st = new Student(name, "Marco1",190,120);
        return st;
    }
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response consumeJSON(Student student) { 
		String result = "Student : " + student;
		return Response.status(201).entity(result).build(); 
	}	
}