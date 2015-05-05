// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		OnlyOne.java
 * Author:	sjambudi
 */


public class OnlyOne
{
	private static  OnlyOne	one	= new OnlyOne();

	private OnlyOne()
	{
	} // private constructor. This class cannot be instantiated from outside.

	public static OnlyOne getInstance()
	{
		return one;
	}
}

