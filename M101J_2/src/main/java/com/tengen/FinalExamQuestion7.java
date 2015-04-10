// Copyright (c) 2014 Financial Engines, Inc. All Rights Reserved.
// Palo Alto, CA

/*
 * File: FinalExamQuestion7.java Author: sjambudi
 */

package com.tengen;

import java.io.IOException;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class FinalExamQuestion7
{
	public static void main(String[] args) throws IOException
	{
		MongoClient c = new MongoClient(new MongoClientURI("mongodb://localhost"));
		DB db = c.getDB("finaltask");
		
		db.getCollection("albums").ensureIndex("{'images':1}");
		DBCursor curImage = db.getCollection("images").find();
		curImage.next();
		int count = 0;
		while(curImage.hasNext())
		{
			Object id = curImage.curr().get("_id");
			int cnt = db.getCollection("albums").find(new BasicDBObject("images", id)).count();
			if (cnt == 0)
			{
				count++;
				System.out.println(count);
				//db.getCollection("images").remove(new BasicDBObject("_id", id));
			}
			curImage.next();
		}
		System.out.println("final count" + count);
		
		/*int i = 0;
		DBCollection album = db.getCollection("albums");
		DBCollection image = db.getCollection("images");

		DBCursor cur = image.find();
		cur.next();
		
		int count = 0;
		while (cur.hasNext())
		{			
			Object id = cur.curr().get("_id");
			DBCursor curalbum = album.find(new BasicDBObject("images", id));
			if (curalbum.size() == 0)//(!curalbum.hasNext())
			{
				count++;		
				
				
				BasicDBObject query = new BasicDBObject();
			    query.put("_id", id);
			    DBObject dbObj = image.findOne(query);
				
				System.out.println(dbObj + "::" + count);
				//image.remove(new BasicDBObject("_id", id));		
				//break;
			}
			cur.next();
		}
		System.out.println("final count" + count);*/
	}
}
