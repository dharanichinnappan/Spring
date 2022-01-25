package com.dharani.spring;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



// Hibernate Validation Examples 
public class Customer {

	
	private String firstName;
	
//Adding validation to lastName 
	@NotNull(message = "Last Name is required")
	@Size(min = 1, message = "Last Name is required") /*--> This condition will pass for white space...even though minimun sie=1 (min=1)*/ 
	private String lastName;
	
//Adding validation to numbers	..
//To make int variable @NotNull ,change int to Interger data type. Because @InitBinder will trim white spaces to null. 
//In order to check for null we must use the appropriate wrapper class: Integer. like below "passes"
	@Min(value=0,message = "should be > or = 0")
	@Max(value=10,message = "should be < or = 10")
	private int freePasses;	
	
	@NotNull(message = "Last Name is required")
	@Min(value=0,message = "should be > or = 0")
	@Max(value=10,message = "should be < or = 10")
	private Integer passes;	
	
	
//Adding validation to numbers	
	@Pattern(regexp="^[0-9]{5}",message="only 5 digits")
	private String postalCode; 
	 
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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public Integer getPasses() {
		return passes;
	}
	public void setPasses(Integer passes) {
		this.passes = passes;
	}
	
	
	
}
