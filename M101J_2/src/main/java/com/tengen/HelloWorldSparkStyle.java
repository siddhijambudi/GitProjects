// Copyright (c) 2014 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		HelloWorldSparkStyle.java
 * Author:	sjambudi
 */

package com.tengen;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldSparkStyle
{
	public static void main(String args[])
	{
		Spark.get(new Route("/")
		{
			public Object handle(final Request request, final Response response)
			{
				return 	"Hello World";
			}			
		});
	}
}

