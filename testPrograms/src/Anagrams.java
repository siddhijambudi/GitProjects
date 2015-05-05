// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		Test1.java
 * Author:	sjambudi
 */

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Anagrams
{
	  public static void check_anagrams(String[] firstWords, String[] secondWords) {
	        // Write your code here
	        // To print results to the standard output you can use System.out.println()
	        // Example: System.out.println("Hello world!");
	        isAnagram(firstWords, secondWords);
	    }
	    
	    public static void isAnagram(String[] firstWords, String[] secondWords)
	    {
	        int stringNum = 0;
	        Map<String,Integer> mapValues = new LinkedHashMap<String,Integer>();
	        for(String firstWord: firstWords)
	        {
	            char[] firstWordChars = firstWord.toCharArray();
	            StringBuilder secondWordBuilder = new StringBuilder(secondWords[stringNum]);
	            for(char c : firstWordChars)
	            {	                
	                int index = secondWordBuilder.indexOf(""+ c);
	                if(index != -1)
	                {
	                	secondWordBuilder.deleteCharAt(index);
	                }
	            }
	            mapValues.put(firstWord, (secondWordBuilder.length() == 0 ? 1 : 0));
	            stringNum++;
	        }
	        
	        //print map values 
	        for(Entry<String,Integer> entry : mapValues.entrySet())
	        {
	            System.out.println(entry.getKey() + ":" + entry.getValue());
	        }
	    }
	
}