import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		StudyDotCom.java
 * Author:	sjambudi
 */

/***
 * Your goal is to write a method that, given a date, returns the first day of the next calendar quarter for that date.  For instance, if we were to pass in 2/10/2000 to the method, it would return 4/1/2000 -- the first day of the next calendar quarter.  

The calendar quarters start on January 1st, April 1st, July 1st, and October 1st.

Your java method takes an instance of our class SimpleDate (see below) and returns the first day of the next calendar quarter as a SimpleDate.  We are not testing your knowledge of java.util.Date or the Calendar API, which is why we created the SimpleDate as a simple data structure to track our date information.

Here is our SimpleDate class:

/**
 Simple data structure representing a Date
*/
/*public class SimpleDate {
  protected int year = 0;
  protected int month = 0;
  protected int day = 0;
  
  public SimpleDate (int year, int month, int day) {...}
  public void setDate (int year, int month, int day) {...}
  public void setYear (int year) {...}
  public int getYear () {...}
  public void setMonth (int month) {...}
  public int getMonth () {...}
  public void setDay (int day) {...}
  public int getDay () {...}
}


The method you implement should have the signature: 

public static SimpleDate getFirstDayOfNextQuarter (SimpleDate date)
 * @author sjambudi
 *
 */

class SimpleDate {
  protected int year = 0;
  protected int month = 0;
  protected int day = 0;
  
  public SimpleDate (int year, int month, int day) {
	  this.year = year;
	  this.month = month;
	  this.day = day;
  }
  public void setDate (int year, int month, int day) {
	  this.year = year;
	  this.month = month;
	  this.day = day;
  }
  public String getDate() throws ParseException{
	  String year = String.valueOf(this.year);
	  String month = String.valueOf(this.month);
	  String day = String.valueOf(this.day);
	  String strDate = month +"/" + day + "/" + year;
	  //String strDate = "04/01/2000";
	  
	  SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	  Date stringDate = dateFormat.parse(strDate);
	  
	  return stringDate.toString();
  }
  public void setYear (int year) {
	  this.year = year;
  }
  public int getYear () {
	  return this.year;
  }
  public void setMonth (int month) {
	  this.month = month;
  }
  public int getMonth () {
	  return this.month;
  }
  public void setDay (int day) {
	  this.day = day;
  }
  public int getDay () {
	  return this.day;
  }
}
public class StudyDotCom
{
	public static void main(String args[]) throws IllegalAccessException, ParseException{
		SimpleDate date = new SimpleDate(2000,8,10);
		System.out.println(getFirstDayOfNextQuarter(date).getDate());
	}

		//test cases:
		//date =  2/10/2000 - answer will be 4/1/2000
		//date = 12/10/2000 - answer will be 1/1/2001

		public static SimpleDate getFirstDayOfNextQuarter (SimpleDate date) throws IllegalAccessException{
		        
		        //check date is not null
		        if(date == null){
		            throw new IllegalAccessException("date can not be null");
		        }
		        
		        //check month of the date and see which quarter it will be 
		        //The calendar quarters start on January 1st, April 1st, July 1st, and October 1st.
		        // 1 - 3 - Q1
		        // 4 - 6 - Q2
		        // 7 - 9 - Q3
		        //10 - 12 - Q4
		        
		        int month = date.getMonth();
		        int year = date.getYear();
		        int day = date.getDay();
		        if(day < 1 || day > 31){
		        	throw new IllegalAccessException("Day should be between 1 to 31");
		        }
		        switch(month){
		            case 1:
		            case 2:
		            case 3:
		                return new SimpleDate(year, 4 , 1);
		            case 4:
		            case 5:
		            case 6:
		                return new SimpleDate(year, 7 , 1);
		            case 7:
		            case 8:	
		            case 9:
		                return new SimpleDate(year, 10, 1);
		            case 10:
		            case 11:
		            case 12:
		                return new SimpleDate(year + 1, 1, 1);
		            default:
		                throw new IllegalAccessException("Not a valid month...Please enter month from 1 to 12");
		        }
		}

}

