// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		PractiseCoding.java
 * Author:	sjambudi
 */


public class PractiseCoding
{
	public static void main(String args[])
	{
		String str = "siddhi";
		String strOutput = reverseString(str.toCharArray());
		System.out.println(strOutput);
	}
	
	private static String reverseString(char[] inputString) //siddhi
	{
		//start comparing first and last index chars 
		int i = 0; 
		int j = inputString.length -1;
						
		while( ( i != j) || (i < j || j > i) ) // indexes will be same at half way 
		{
		   char temp = inputString[i] ;
		   inputString[i] = inputString[j]; 
		   inputString[j] = temp; 
		   i++;
		   j--;		
		}
		return inputString.toString();
	}
}

