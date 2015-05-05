// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		Test15.java
 * Author:	sjambudi
 */


public class Palindrome
{
	public static void main(String args[]){
		//System.out.println(countNoOfPrimeNumbers(1200));
		//System.out.println(isPalindrom1("malayalam"));
		
		System.out.println(isPalindromeNumber(454));
	}
	public static int isPalindromeNumber(int number){
		if(number == 0){
			return number;
		}			
		return isPalindromeNumber((number/10));
	}
	public static boolean isPalindrom1(String originalString){
		int i = 0;
		int n = originalString.length() - 1;
		char[] oChars = originalString.toCharArray();
		
		while(i < (n/2)){
			if(oChars[i] != oChars[n-i]){
				return false;
			}		
			i++;
		}
		return true;
	}
	
	public static boolean isPalindrom(String originalString){
		if(originalString == null || originalString.length() == 0){
			throw new IllegalStateException("String is null or empty");
		}
		char[] originalChars = originalString.toCharArray();
		
		int i = 0;
		int j = originalString.length() - 1;
		
		while(i < j){
			
			if(originalChars[i] != originalChars[j]){return false;}
			
			char temp = originalChars[i];
			originalChars[i] = originalChars[j];
			originalChars[j] = temp;
			
			i++;
			j--;
		}
		
		if(new String(originalChars).equals(originalString)){
			return true;
		}
		return false;
	}
	
	public static int countNoOfPrimeNumbers(int n){
		//find prime numbers from first 1000
		int count = 0;
		for(int i = 2; i <= n; i++){
			if(isPrimeNumber(i)) count++;
		}
		return count; 
	}
	public static boolean isPrimeNumber(int n1){
		for(int i = 2; i <= n1/2; i++){
			if(n1 % i == 0){
				return false;
			}
		}
		return true;
	}
}

