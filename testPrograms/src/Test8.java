// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		Test8.java
 * Author:	sjambudi
 */


public class Test8
{
	public static void main(String args[])
	{
		checkAndReturnSeedNum(738,1);
	}
	
	public static int checkAndReturnSeedNum(int number, int n){
		
		int division = getDivision(number);
		int div = number / division;
		
		if (div == 1 || division == 1 ||checkDigits(div) == (number * n))
		{			
			if(division != 1 && div != 1){
				System.out.println(div);
				return checkAndReturnSeedNum(div, n * division);
			}
			return div;
		}
		return checkAndReturnSeedNum(div, n * division);
	}
	private static int checkDigits(int div)
	{
		int number = div;
		int rem = 0;
		int multiply = number;
		
		while(div != 0)
		{
			rem = div % 10;
			div = div / 10;
						
			multiply = multiply * rem;
		}		
		return multiply;
	}
	private static int getDivision(int number)
	{
		int division = 1;
			if(number %  2 == 0){
			division = 2;
		}
		else if(number % 3 == 0 && number % 9 != 0){
			division = 3;
		}
		else if(number % 5 == 0){
			division = 5;
		}
		else if(number % 7 == 0){
			division = 7;
		}
		else if(number % 3 == 0 && number % 9 == 0){
			division = 9;
		}
		else if(number % 9 == 0){
			division = 9;
		}
		return division;
	}
}


