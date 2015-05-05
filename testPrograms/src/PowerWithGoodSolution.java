// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		PowerWithGoodSolution.java
 * Author:	sjambudi
 */


public class PowerWithGoodSolution
{
	public static void main(String args[]){
		int a = 3;
		int b = 6;
		
		System.out.println((pow(a, b)));
	}
	
	//pow(a,b) where a,b > 0 and it returns a ^ b.


	/* 3 ^ 5  = 3 * 3 * 3 * 3 * 3 * 3 * 3
	 (9 ^ 2) * a = 9 * 9 * 3
	 243 ^ 1 = 
*/
	public static int pow(int a, int b)
	{
		// base condn
		if (b == 0)
		{
			return 1;
		}
		return (a * pow(a, b - 1));
	}
}

