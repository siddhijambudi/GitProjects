// Copyright (c) 2014 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		DocumentRepresentationTest.java
 * Author:	sjambudi
 */

package com.tengen;

import java.util.Arrays;
import java.util.Date;

import com.mongodb.BasicDBObject;

public class DocumentRepresentationTest
{
	public static void main(String args[])
	{
		BasicDBObject doc = new BasicDBObject();
		doc.put("userName", "siddhi");
		doc.put("birthDate", new Date(2343546));
		doc.put("programmer", true);
		doc.put("age", 45);
		doc.put("languages", Arrays.asList("Java", "c++", "python"));
		doc.put("address", new BasicDBObject("street", "50 main street").append("town", "fremont").append("zip", 94539));
		System.out.println(doc);
		
		/*BasicDBObject quizDoc = new BasicDBObject();
		quizDoc.put("_id", "user1");
		quizDoc.put("Interests", Arrays.asList("basketball", "drumming"));
		System.out.println(quizDoc);	*/	
	}
}

