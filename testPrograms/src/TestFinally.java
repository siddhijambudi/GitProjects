// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		TestFinally.java
 * Author:	sjambudi
 */


public class TestFinally 
{
	int n = 1; 
	public static void main(String args[]){
		call1();
	}
	public static void call1(){
		try{
			int i = 1;
			i= i / 0;
			System.out.println(n);
		}
		catch(Exception e){
			System.out.println("in catch : " + e.getMessage());
		}
		finally{
			System.out.println("in finally");
		}
	}
	public void test1(){
		System.out.println(n);
	}
}

