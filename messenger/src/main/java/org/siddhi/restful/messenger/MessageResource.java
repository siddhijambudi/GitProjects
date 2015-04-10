// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		MessageResource.java
 * Author:	sjambudi
 */

package org.siddhi.restful.messenger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("messages")
public class MessageResource{
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getString(){
		return "Hello World !";
	}
}

