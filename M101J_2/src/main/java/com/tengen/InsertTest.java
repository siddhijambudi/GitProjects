// Copyright (c) 2014 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		InsertTest.java
 * Author:	sjambudi
 */

package com.tengen;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class InsertTest
{
	public static void main(String args[]) throws UnknownHostException
	{
		MongoClient mongoClient = new MongoClient();
		DB courseDB = mongoClient.getDB("course");
		DBCollection dbCollection = courseDB.getCollection("insertTest");
		DBObject doc = new BasicDBObject().append("x", 1);
		System.out.println(doc);
		dbCollection.insert(doc);
		System.out.println(doc);
	}
}

