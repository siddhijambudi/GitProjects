// Copyright (c) 2014 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		HelloWorldSparkFreeMarkerStyle.java
 * Author:	sjambudi
 */

package com.tengen;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloWorldSparkFreeMarkerStyle
{
	public static void main(String args[])
	{
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(
			HelloWorldSparkFreeMarkerStyle.class, "/");
		
		Spark.get(new Route("/")
		{
			public Object handle(final Request request, final Response response)
			{
				StringWriter stringWriter = new StringWriter();
				try
				{
					Template helloTemplate = configuration.getTemplate("Hello.ftl");
					Map<String,Object> helloMap = new HashMap<String,Object>();
					helloMap.put("name", "FreeMarker");
					
					helloTemplate.process(helloMap, stringWriter);
					
				}
				catch (Exception e)
				{
					halt(500);
					e.printStackTrace();
				}
				return stringWriter;
			}			
		});
		
	}
}

