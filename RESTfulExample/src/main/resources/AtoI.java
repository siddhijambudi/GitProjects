// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		AtoI.java
 * Author:	sjambudi
 */


import fei.annotation.Owner;

@Owner("sjambudi")
public class AtoI
{
	@SuppressWarnings("null")
    public static int atoi(String str) {
        int value=0, sign=1;
        if(!isNumber(str)) {
            System.out.println("String not a valid number format..." + str);
            return (Integer) null;
        }
        for (int i=0; i<str.length();i++) {
            char ch = str.charAt(i);
            if (ch=='-') {
                sign=-1;
                continue;
            }
            if (i==str.length()-1)
                value = (value + str.charAt(i) - '0');
            else
                value = (value + str.charAt(i) - '0') * 10;
        }
        return sign*value;
    }
    
    /*
     * Private method to check if the string has all digits
     */
    private static boolean isNumber(String str) {
        for (int i=0; i<str.length();i++)
            if ((str.charAt(i)<'0' || str.charAt(i)>'9') && (str.charAt(i)!='-'))
                return false;
        return true;
    }
    
    public static void main(String[] args) {
        String str = "-123455";
        System.out.println("String: " + str + "; Integer: " + atoi(str));
    }
}

