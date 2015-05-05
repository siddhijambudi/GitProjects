import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Copyright (c) 2015 Financial Engines, Inc. All Rights Reserved.
// Palo Alto, CA

/*
 * File: Test3.java Author: sjambudi
 */

public class ReverseStringRecursively
{
	public static void main(String args[])
	{
		String str = "siddhi";
		System.out.println(reverseStringRecursively(str, str.length() - 1));		
	}
	public static String reverseStringRecursively(String str, int length)
	{
		if(length == 0)
			return str;
		return reverseStringRecursively(str, length-1) + str.charAt(length);
	}
}
