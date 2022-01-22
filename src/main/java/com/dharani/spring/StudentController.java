package com.dharani.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller


//data binding html variables to java objects 

// creating java class and object of that particular class and  values from html page will be populated into it . 
// set that java class to model attribute.
@RequestMapping("/studentController")
public class StudentController {
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		Student student1=new Student();
		model.addAttribute("modelStudent", student1);
		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("modelStudent") Student theStudent ) {
		System.out.println("student name is:  " +  theStudent.getFirstName() +"  student las name is  "+ theStudent.getLastName() );
		System.out.println(theStudent.getLanguage());
		return "student-confirmation";
	}
}
