// Copyright (c) 2014 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		HelloWorldFreeMarkerStyle.java
 * Author:	sjambudi
 */

package com.tengen;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloWorldFreeMarkerStyle
{
	public static void main(String args[])
	{
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(
				HelloWorldFreeMarkerStyle.class, "/");
		
		try
		{
			Template helloTemplate = configuration.getTemplate("/freemarker/Hello.ftl");
			StringWriter stringWriter = new StringWriter();
			Map<String,Object> helloMap = new HashMap<String,Object>();
			helloMap.put("name", "FreeMarker");
			
			helloTemplate.process(helloMap, stringWriter);
			System.out.println(stringWriter);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

