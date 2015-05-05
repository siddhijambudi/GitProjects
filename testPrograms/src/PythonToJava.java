import org.python.core.PyException;
import org.python.util.PythonInterpreter;

// Copyright (c) 2015 Financial Engines, Inc. All Rights Reserved.
// Palo Alto, CA

/*
 * File: PythonToJava.java Author: sjambudi
 */

public class PythonToJava
{

	public static void main(String[] args) throws PyException
	{
		try
		{
			PythonInterpreter.initialize(System.getProperties(), System.getProperties(), new String[0]);
			PythonInterpreter interp = new PythonInterpreter();
			interp.execfile("D:/workspace/testPrograms/src/perm.py");
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

}
