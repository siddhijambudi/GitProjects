import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		Test20.java
 * Author:	sjambudi
 */



public class SCJPTestExamples implements Serializable
{
	private TestInner t1 = new TestInner();
	public static void main(String args[]){
		SCJPTestExamples tnew = new SCJPTestExamples();
		tnew.m1(tnew);
	}
	public static void m1(SCJPTestExamples tnew){
		try{
			ObjectOutputStream os = new ObjectOutputStream(
				new FileOutputStream("F1"));
			os.writeObject(tnew);
		}
		catch(Exception ex){
			ex.printStackTrace();
			ex.getMessage();
			System.out.println("exc");
		}
	}
}
class TestInner implements Serializable {}

