// Copyright (c) 2015 Financial Engines, Inc. All Rights Reserved.
// Palo Alto, CA

/*
 * File: isMatchPattern.java Author: sjambudi
 */

public class isMatchPattern
{
	public static  String	regex;
	public static String	content;

	public static boolean match(int regexPos, int contentPos)
	{
		if (regexPos == regex.length() && contentPos == content.length())
		{
			return true;
		}
		else if (regexPos < regex.length() && contentPos < content.length())
		{
			char regexChar = regex.charAt(regexPos);
			if (regexChar == '?')
			{
				return match(regexPos + 1, contentPos + 1);
			}
			else if (regexChar == '*') 
			{
				//* is the only pattern then anything is allowed
				if (regexPos + 1 == regex.length()) { return true; }
				
				for (int i = 0; i <= content.length() - contentPos; i++)
				{
					if (match(regexPos + 1, contentPos + i))
					{
						return true;
					}
				}
				return false;
			}
			else if (regexChar == content.charAt(contentPos))
			{
				return match(regexPos + 1, contentPos + 1);
			}
		}
		else if(regexPos < regex.length() && contentPos >= content.length())
		{
			char regexChar = regex.charAt(regexPos);
			
			//if in pattern * is the last character then it is ok 
			if(regexChar == '*' && (regexPos + 1 == regex.length())){				
				return true;							
			}			
			return false;
		}
		return false;
	}

	public static void main(String[] args)
	{
		isMatchPattern matcher = new isMatchPattern();
		matcher.regex = "abc*def";
		matcher.content = "abc**def";
		
		System.out.println(matcher.match(0, 0));
	}
}
