package com.dharani.Restful;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			//create Object Mapper
			ObjectMapper mapper=new ObjectMapper();
			
			//Read JSON file and map/convert into JAVA POJO			
		    Student student=mapper.readValue(new File("data/sample.json"), Student.class);
		    
		    //Print Student Object variables.
		    System.out.println(student.getFirstName()+student.getLastName());
		    System.out.println(student.getLanguages()[0]);
		    for(String language:student.getLanguages()) {
		    	 System.out.println(language);
		    }	
		    System.out.println(student.getAddress().getCountry());
		    
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
