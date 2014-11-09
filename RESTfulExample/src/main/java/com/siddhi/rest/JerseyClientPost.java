// Copyright (c) 2014 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		JerseyClientPost.java
 * Author:	sjambudi
 */



package com.siddhi.rest;
 
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
 
public class JerseyClientPost {
 
  public static void main(String[] args) {
 
	try {
 
		Client client = Client.create();
 
		WebResource webResource = client
		   .resource("http://localhost:8080/RESTfulExample/rest/hello/send");
 		
		String input = "{\"id\": 12,\"firstName\": \"json\",\"lastName\": \"Marco\",\"age\": 19}";
 
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
 
		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
			     + response.getStatus());
		}
 
		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println(output);
 
	  } catch (Exception e) {
 
		e.printStackTrace();
 
	  }
 
	}
}
