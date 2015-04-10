// Copyright (c) 2014 Financial Engines, Inc. All Rights Reserved.
// Palo Alto, CA

/*
 * File: FinalExamQuestion8.java Author: sjambudi
 */

package com.tengen;

import java.io.IOException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class FinalExamQuestion8
{
	public static void main(String[] args) throws IOException
	{
		MongoClient c = new MongoClient(new MongoClientURI("mongodb://localhost"));
		DB db = c.getDB("test");
		DBCollection animals = db.getCollection("animals");

		BasicDBObject animal = new BasicDBObject("animal", "monkey");

		animals.insert(animal);
		animal.removeField("animal");
		animal.append("animal", "cat");
		animals.insert(animal);
		animal.removeField("animal");
		animal.append("animal", "lion");
		animals.insert(animal);
	}
}
