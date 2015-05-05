
// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		Test10.java
 * Author:	sjambudi
 */


public class ProductsOfAllIntsExceptAtIndexItSelf
{
	public static void main(String args[]){
		int[] input = new int[]{2,4,10};
		int[] output = getProductsOfAllIntsExceptAtIndex(input);
		
		//int[] input = new int[]{1,3,5,9,11};
		
		//System.out.println(findMissingElement(5, input));
		printArray(output);
	}
	
	public static void printArray(int[] array)
	{
		for(int i = 0; i< array.length; i++){
			System.out.print(array[i] + " ");
		}
	}	
	
	public static int[] getProductsOfAllIntsExceptAtIndex(int[] a){
		int n = a.length;
		int[] prods = new int[n];
		
		int prod = 1;			
		for(int i = 0; i < n; i++){
			prods[i] = prod;
			prod = prod * a[i];
		}
		
		prod = 1;
		for(int i = n-1; i >= 0; i--){
			prods[i] = prods[i] * prod;
			prod = prod * a[i];
		}
		
		return prods;
	}
}

