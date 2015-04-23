/*****
 * created by : Siddhi Jambudi
 * date : 4/22/2015
 * 
 * ReadFilesFromCommandLineInReverse.java class takes files as input from command line arg and read 
 * line by line and generates output in reverse 
 * 
 *  E.g.  
 *  given a file named "file1", containing:

file1line1
file1line2

And a "file2", containing:

file2line1
file2line2

When run with the arguments "file1" "file2", the program must output:

2enil2elif
1enil2elif
2enil1elif
1enil1elif
 */

package prep;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadFilesFromCommandLineInReverse {
	public static void main(String args[]) throws IOException{
		//read one or more files from command line argument 
		if(args.length == 0){
			throw new IllegalStateException("atleast one file should be provided");
		}
		for(int i = args.length - 1; i >= 0; i--){
			//read each file one by one
			File file = new File(args[i]);
	       
	        //reads content from each file and append output in reverse
			System.out.println(readFileFromLastLineToFirstLine(file));
		}
	}
	public static String readFileFromLastLineToFirstLine(File file) throws IOException{
		//read from file and use RandomAccessFile class and go to last line of file
		long length = file.length(); 
		length--;
		
		StringBuilder sb = new StringBuilder();
		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");		
		randomAccessFile.seek(length);
		
		//read all characters from last to first of the given line (starting from last to first)
		for(long seek = length; seek >= 0; --seek){
            randomAccessFile.seek(seek);
            char c = (char)randomAccessFile.read();
            //no need for extra carriage return
            if(c == '\r'){ 
            	continue;
            }
            sb.append(c);          
        }		
		return sb.toString();
	}
}
