import java.util.regex.Pattern;

// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		MatchPattern.java
 * Author:	sjambudi
 */



public class MatchPattern
{
	/**.java    foo.java .java
	abc?xyz  abcQxyz
	abc*xyz  abcQXXXXxyz

	*.java foo.java
	.java foo.java
	.java .java*/

	public static String matchPattern(String pattern, String originalString){
		
		Pattern.matches(arg0, arg1)
		
		if(pattern == null || originalString == null) {
			return null;
		}
		if(originalString.length() < 2){
			return originalString;
		}
		if(pattern.charAt[0] != originalString.charAt[0]){
			if(pattern.charAt[0] != '?' && pattern.charAt[0] != '*'){
				return false;
			}
			else if(pattern.charAt[0] == ‘?’) {
				return matchPattern(pattern.subString(1), originalString.subString(1));
			}
			else if(pattern.charAt[0] == ‘*’) {
				return matchPattern(pattern.subString(1), originalString) ||
						matchPattern(pattern, originalString.substr(1)) ||
						
			}
		}
		return matchPattern(pattern.subString(1), originalString.subString(1));
	}

}

