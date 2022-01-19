package com.dharani.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController2 {

	
	@RequestMapping("showForm")
	public String showForm() {
		return "form";
	}
	
	
}
