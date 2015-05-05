// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		Test16.java
 * Author:	sjambudi
 */


public class BruteForceSubArray
{
	public static void main(String args[]){
		int[] A = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
		System.out.println(MaxSum(A, 8));
	}
	
	// This code fragment was a quote from Beauty of Programming
	static int MaxSum(int[] A, int n)
	{
	    int maximum = 0;
	    int sum = 0;
	    for (int i = 0; i < n; i++)
	    {
	        for (int j = i; j < n; j++)
	        {
	            for (int k = i; k <= j; k++)
	            {
	                sum += A[k];
	            }
	            if (sum > maximum)
	                maximum = sum;
	            sum = 0; // reset it to 0, or sum would be the sum of all subarrays.
	        }
	    }
	    return maximum;
	}
}


