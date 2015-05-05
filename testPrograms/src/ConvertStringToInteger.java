// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		ConvertStringToInteger.java
 * Author:	sjambudi
 */

class SolutionConvertStringToInteger {
    public void convert(String str) {
        int negFlag = 1;
        int start = 1;
        int out = str.charAt(0) - '0';
        if(str.charAt(0) == 45) {
            negFlag = -1;
            out = str.charAt(1) - '0';
            start = 2;
            if(out < 0 || out > 9) {
                System.out.println("INVALID NUMBER");
                return;
            }
        }
        for(int i = start; i < str.length(); i++) {
            int temp = str.charAt(i) - '0';
            if(temp < 0 || temp > 9) {
                System.out.println("INVALID NUMBER");
                return;
            }
            out = (out * 10) + temp; 
        }
        System.out.println(out * negFlag);
    }
}

public class ConvertStringToInteger {

    public static void main(String[] args) {
        SolutionConvertStringToInteger mSol = new SolutionConvertStringToInteger();
        mSol.convert("67889");
        mSol.convert("-67889");
        mSol.convert("-678-89");
        mSol.convert("678-89");
    }
}
