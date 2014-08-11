// Copyright (c) 2014 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		HelloWorldMongoDbSparkFreemarkerStyle.java
 * Author:	sjambudi
 */

package com.tengen;

import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloWorldMongoDbSparkFreemarkerStyle
{
	public static void main(String args[]) throws UnknownHostException
	{
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(
			HelloWorldSparkFreeMarkerStyle.class, "/");
		
		MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
		DB database = client.getDB("course");
		final DBCollection collection = database.getCollection("hello");
		
		Spark.get(new Route("/")
		{
			public Object handle(final Request request, final Response response)
			{
				StringWriter stringWriter = new StringWriter();
				try
				{
					Template helloTemplate = configuration.getTemplate("Hello.ftl");
					DBObject document = collection.findOne();
					
					
					helloTemplate.process(document, stringWriter);
					
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

