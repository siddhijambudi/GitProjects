// Copyright (c) 2014 Financial Engines, Inc. All Rights Reserved.
// Palo Alto, CA

/*
 * File: Student.java Author: sjambudi
 */
package com.siddhi.rest;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
 

public class Student
{

	private int		id;
	private String	firstName;
	private String	lastName;
	private int		age;

	// Must have no-argument constructor
	
	public Student()
	{

	}

	public Student(String fname, String lname, int age, int id)
	{
		this.firstName = fname;
		this.lastName = lname;
		this.age = age;
		this.id = id;
	}

	public void setFirstName(String fname)
	{
		this.firstName = fname;
	}
	
	@JsonProperty("firstName")	
	public String getFirstName()
	{
		return this.firstName;
	}

	public void setLastName(String lname)
	{
		this.lastName = lname;
	}
	
	@JsonProperty("lastName")
	public String getLastName()
	{
		return this.lastName;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
	
	@JsonProperty("age")
	public int getAge()
	{
		return this.age;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	@JsonProperty("id")
	public int getId()
	{
		return this.id;
	}

	@Override
	public String toString()
	{
		return new StringBuffer(" First Name : ").append(this.firstName)
		.append(" Last Name : ").append(this.lastName)
		.append(" Age : ").append(this.age).append(" ID : ")
		.append(this.id).toString();
	}
}
