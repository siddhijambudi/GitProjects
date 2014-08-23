// Copyright (c) 2014 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		SparkFormHandling.java
 * Author:	sjambudi
 */

package com.tengen;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class SparkFormHandling
{
	public static void main(String args[])
	{
		//configure free marker
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(SparkFormHandling.class, "/");
		
		Spark.get(new Route("/")
		{
			public Object handle(final Request request, final Response response)
			{				
				try
				{
					Map<String, Object> fruitsMap = new HashMap<String,Object>();
					fruitsMap.put("fruits", Arrays.asList("apple", "banana", "orange", "peach"));
					
					Template fruitPickerTemplate = configuration.getTemplate("/freemarker/fruitpicker.ftl");
					StringWriter stringWriter = new StringWriter();
					fruitPickerTemplate.process(fruitsMap, stringWriter);
					return stringWriter;
				}
				catch (Exception e)
				{
					halt(500);
					return null;
				}
				
			}			
		});
				
		//POST
		Spark.post(new Route("/favorite_fruit")
		{
			@Override
			public Object handle(final Request request, final Response response)
			{
				final String fruit = request.queryParams("fruit");
				if(fruit == null)
				{
					return ("why don't you pick one?");
				}
				else
				{
					return("Your favourite fruit is :" + fruit);
				}				
			}			
		});
	}
}

