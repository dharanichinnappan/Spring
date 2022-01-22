package com.dharani.spring;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Hibernate Validation Examples 
public class Customer {

	
	private String firstName;
	
//Adding validation to lastName 
	@NotNull(message = "Last Name is required")
	@Size(min = 1, message = "Last Name is required") /*--> This condition will pass for white space...even though minimun sie=1 (min=1)*/ 
	private String lastName;
	
//Adding validation to numbers	
	@Min(value=0,message = "should be > or = 0")
	@Max(value=10,message = "should be < or = 10")
	private int freePasses;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
	
	
	
}
