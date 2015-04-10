// Copyright (c) 2014 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		Test.java
 * Author:	sjambudi
 */


public class Test
{
	public static void main(String args[])
	{
		/*new Test().test();
		new Test().test1();
		new Test().test2();*/
		int[] array = new int[]{5,6,3,1,2,8,8,11,77,5,6,0};
		System.out.println(biranySearch(2, array, 0, array.length - 1));
	}
	
	public static int biranySearch(int key, int[] array, int min, int max)
	{
		//base condition to return from recursion
		if(max < min)
		{
			return -1;
		}
		else
		{
			//find key in array
			int mid = ((min + max) / 2);
			
			//check if key is in left side of mid
			if(key < array[mid])
			{
				biranySearch(key, array, 0, mid);
			}
			
			//right side of mid
			else if(key > array[mid])
			{
				biranySearch(key, array, mid + 1, max);
			}	
			else
			{
				return array[mid];
			}
		}
		return -1;			
	}
	
	private static void binarySearch(int key, int[] array, int i, int j)
	{
		// TODO Auto-generated method stub
		
	}

	public void test()
	{
		String str = "siddhi shah is happy";		
		String strNew = new String();
		
		int length = str.length();
		for(int i = length - 1; i >= 0; i--)
		{
			strNew = strNew.concat(String.valueOf(str.charAt(i)));						
		}
		
		System.out.println(strNew);
	}
	public void test1()
	{
		String str = "siddhi shah is happy";	
		char[] strArray = str.toCharArray();
		
		for(int i = 0, j = str.length() - 1; i < str.length() / 2 ; i++, j--)
		{
			char c = strArray[i];
			strArray[i] = strArray[j];
			strArray[j] = c;
		}
		System.out.println(strArray);
	}
	public void test2()
	{
		String str = "siddhi shah is happy";
		System.out.println(reverseString(str));
	}
	
	public String reverseString(String str)
	{
		if(str.length() < 2)
		{
			return str;
		}
		return reverseString(str.substring(1)) + str.charAt(0);
	}
}

