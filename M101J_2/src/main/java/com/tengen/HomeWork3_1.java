// Copyright (c) 2014 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		HomeWork3_1.java
 * Author:	sjambudi
 */

package com.tengen;

import java.net.UnknownHostException;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class HomeWork3_1
{
	public static void main(String args[]) throws UnknownHostException
	{
		MongoClient mongoClient = new MongoClient();
		DB schoolDB = mongoClient.getDB("school");
		DBCollection dbCollection = schoolDB.getCollection("students");
		
		DBObject groupFields = new BasicDBObject( "_id", "$_id");		
		groupFields.put("min", new BasicDBObject( "$min", "$scores.score"));
		
		AggregationOutput output = dbCollection.aggregate(		
			new BasicDBObject("$unwind", "$scores"),
			new BasicDBObject("$match", new BasicDBObject("scores.type", "homework")),
			new BasicDBObject("$group", groupFields),
			new BasicDBObject("$sort", new BasicDBObject("_id", 1))
		);	
		
		for (DBObject result : output.results()) 
		{
			BasicDBObject query=new BasicDBObject("_id", result.get("_id")).append("scores.score", result.get("min"));
			BasicDBObject fields=new BasicDBObject("scores.$", 1);

			DBCursor cur = dbCollection.find(query, fields);
					
	        while (cur.hasNext()) {
	            DBObject objectToRemove = cur.next();
	           	           
	            //update the collection
	            BasicDBObject match = new BasicDBObject("_id", objectToRemove.get("_id"));
	            BasicDBObject update = new BasicDBObject("scores", 
	            	new BasicDBObject("type", "homework").append("score", result.get("min")));
	            	            
	           // dbCollection.update(match, new BasicDBObject("$pull", update));	            
	        }	    
		}
	}
}

