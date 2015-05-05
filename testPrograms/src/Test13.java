// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		Test13.java
 * Author:	sjambudi
 */


public class Test13{
	public static void main(String... args){
		System.out.println(reverseString("siddhi"));
	}
	
	public static String reverseString(String str){
		int midpoint = str.length() / 2;
		int i = 0;
		int j = str.length() - 1; 
		char[] stringArray = str.toCharArray();
		
		while ( i < midpoint){
			
			char temp = stringArray[i];
			stringArray[i] = stringArray[j];
			stringArray[j] = temp;

			i++;
			j--;
		}
		
		return new String(stringArray);
	}
}
