// Copyright (c) 2014 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		Test.java
 * Author:	sjambudi
 */

package com.tengen;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Test
{
	public static void main(String args[]) throws UnknownHostException
	{
		MongoClient mongoClient = new MongoClient();
		DB courseDB = mongoClient.getDB("students");
		DBCollection dbCollection = courseDB.getCollection("grades");
		System.out.println(dbCollection.find().count());
		
		// create our pipeline operations, first with the $match
		DBObject match = new BasicDBObject("$match", new BasicDBObject("type", "homework"));
		
		// build the $projection operation
		DBObject fields = new BasicDBObject("student_id", 1);
		fields.put("score", 1);
		fields.put("_id", 0);
		DBObject project = new BasicDBObject("$project", fields );
		
		// Now the $group operation
		DBObject groupFields = new BasicDBObject( "_id", "$student_id");		
		groupFields.put("min", new BasicDBObject( "$min", "$score"));
		DBObject group = new BasicDBObject("$group", groupFields);
		
		// Finally the $sort operation		
		DBObject sort = new BasicDBObject("$sort", new BasicDBObject("_id", 1));
		
		// run aggregation		
		AggregationOutput output = dbCollection.aggregate(match, project, group, sort);
		
		//remove below documents from collection 
		for (DBObject result : output.results()) {		
		   // System.out.println("going to remove: " + result);
		    DBObject query = new BasicDBObject("student_id", result.get("_id")).append("score", result.get("min"));
		    DBObject objectToRemove = dbCollection.findOne(query);
		    
		    System.out.println(objectToRemove);
		    dbCollection.remove(objectToRemove);
		}		
	}
}

