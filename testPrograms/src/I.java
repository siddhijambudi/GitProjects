import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		I.java
 * Author:	sjambudi
 */


public abstract class I
{
	 public abstract String tmp();
	 
	 public static void main(String[] args) {
		    PythonInterpreter interpreter = new PythonInterpreter();
		    interpreter.exec("import sys\n" + "sys.path.append(pathToModule)\n" + 
		        "from test import tmp");
		  
		    PyObject tmpFunction = interpreter.get("tmp");
		    System.err.println(tmpFunction.getClass());
		    PyObject x = new PyObject();
			I i = (I) x.__tojava__(I.class);
		    System.err.println(i.tmp());
		}
}

