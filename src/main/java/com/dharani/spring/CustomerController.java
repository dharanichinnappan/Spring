package com.dharani.spring;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customerController")
public class CustomerController {
	
	
		 //add an initbinder class to trim inout strings 
		 //to remove leading and trailing white spaces 
		 //to resolve issue of validation passing white spaces 
		@InitBinder	
		
		//This method will be called for every input from web to controller.
		public void InitBinder(WebDataBinder webDataBinder) {
			// StringTrimmerEditor removes leading and trailing whitespaces. Defined in Spring API.
			StringTrimmerEditor editor = new StringTrimmerEditor(true); /*--> true means trim whitespace to null*/
			webDataBinder.registerCustomEditor(String.class, editor);
		}
	
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		Customer customer=new Customer();
		model.addAttribute("OurCustomer", customer);		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	// Spring will store the result of validation in BindingResult
	public String processForm(@Valid @ModelAttribute("OurCustomer") Customer theCustomer, BindingResult bindingResult ) {
		
		if(bindingResult.hasErrors()){
			
			return "customer-form";
		}
		else {
			return "customer-confirmation";
		}
		
	}
}
