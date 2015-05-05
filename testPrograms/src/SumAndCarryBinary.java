// Copyright (c) 2015 Financial Engines, Inc. All Rights Reserved.
// Palo Alto, CA

/*
 * File: SumAndCarryBinary.java Author: sjambudi
 */

public class SumAndCarryBinary
{
	public static void main(String args[])
	{
		System.out.println(sumBinary("0111101", "1101"));
	}

	public static String sumBinary(String binary1, String binary2)
	   {
		   char[] binary1Array = binary1.toCharArray();
		   char[] binary2Array = binary2.toCharArray();
		
		   int length = binary1.length() > binary2.length() ? binary1.length() + 1 : binary2.length() +1;
		   char[] sum = new char[length];
		   int i=binary1Array.length-1, j=binary2Array.length-1, k= length-1;
		   char carry = '0';
		   while (i >= 0 && j >= 0)
		   {
			   if (binary1Array[i] == '0' && binary2Array[j] == '0' && carry == '0') { sum[k] = '0'; carry = '0'; } else
			   if (binary1Array[i] == '1' && binary2Array[j] == '0' && carry == '0') { sum[k] = '1'; carry = '0'; } else
			   if (binary1Array[i] == '0' && binary2Array[j] == '1' && carry == '0') { sum[k] = '1'; carry = '0'; } else
			   if (binary1Array[i] == '0' && binary2Array[j] == '0' && carry == '1') { sum[k] = '1'; carry = '0'; } else
			   if (binary1Array[i] == '1' && binary2Array[j] == '1' && carry == '0') { sum[k] = '0'; carry = '1'; } else
			   if (binary1Array[i] == '1' && binary2Array[j] == '0' && carry == '1') { sum[k] = '0'; carry = '1'; } else
			   if (binary1Array[i] == '0' && binary2Array[j] == '1' && carry == '1') { sum[k] = '0'; carry = '1'; } else
			   if (binary1Array[i] == '1' && binary2Array[j] == '1' && carry == '1') { sum[k] = '1'; carry = '1'; }
			   i--;
			   j--;
			   k--;
		   }
		   if (i < 0 && j >=0)
		   {
			   while (j >=0)
			   {
				   if (binary2Array[j] == '1' && carry == '0') {sum[k] = '1'; carry = '0';} else
				   if (binary2Array[j] == '0' && carry == '1') {sum[k] = '1'; carry = '0';} else
				   if (binary2Array[j] == '1' && carry == '1') {sum[k] = '0'; carry = '1';} 
				   j--;
				   k--;
			   }
		   }
		   if ( j < 0 && i >= 0)
		   {
			   while (i >=0)
			   {
				   if (binary1Array[i] == '1' && carry == '0') {sum[k] = '1'; carry = '0';} else
				   if (binary1Array[i] == '0' && carry == '1') {sum[k] = '1'; carry = '0';} else
				   if (binary1Array[i] == '1' && carry == '1') {sum[k] = '0'; carry = '1';}
				   i--;
				   k--;
			   }
		   }
		   
		   if (carry == '1') sum[k] = carry;
		   return new String(sum);
	   }
}
