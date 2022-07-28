package com.dharani.spring;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String  lastName;
	private String country;
	
	//instead of hard coding country options in html ,we can provide options in java code using LinkedHashMap
	//provide options for select tag (country) inside constructor
	private LinkedHashMap<String, String> countryOptions;
	
	public Student() {
		countryOptions =new LinkedHashMap<String, String>();
		
		//countryOptions.put(Value, Label);
		countryOptions.put("Ger", "Germany");
		countryOptions.put("Ind", "India");
		countryOptions.put("UK", "United Kingdom");
		countryOptions.put("US", "United States");
		
	}
	
	private String language; // Same can be done with Java code as similar to select options.Refer above
  
	private String operatingSystems;
	//private String[] operatingSystems;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
//we need only getters not setters method 
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	/*
	 * public String[] getOperatingSystems() { return operatingSystems; }
	 * 
	 * public void setOperatingSystems(String[] operatingSystems) {
	 * this.operatingSystems = operatingSystems; }
	 */
	
	 public String getOperatingSystems() { return operatingSystems; }
	 
	 public void setOperatingSystems(String operatingSystems) {
	 this.operatingSystems = operatingSystems; }
	 
	
	
}
