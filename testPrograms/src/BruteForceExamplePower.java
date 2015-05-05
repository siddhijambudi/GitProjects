// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		BruteForceExample.java
 * Author:	sjambudi
 */


public class BruteForceExamplePower
{
	public static void main(String args[]){
		System.out.println(power(2, 8));
		//System.out.println(powerBruteForce(2, 8));
	}
	
	public static int power(int a, int b){
		if(b == 0){
			return 1;
		}
		return a * (power(a, b-1));
	}
}

