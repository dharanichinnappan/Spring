package com.dharani.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("mainFormController")
public class FormController {
	
	@RequestMapping("showForm")
	public String showForm() {
		return "students-form";
	}

	@RequestMapping("processForm")
	public String processForm() {
		return "show-details";
	}
	
	//editting jsp page attribute and adding to model  and displaing it in a jsp page using HttpServletRequest
	@RequestMapping("editForm")
	public String editForm(HttpServletRequest request,Model model) {
		
		String name=request.getParameter("studentName");
		name=name.toUpperCase();
		String result = "Hi" +" "+ name;
		model.addAttribute("message",result);
		return "show-details";
	}
	
	//editting jsp page attribute and adding to model  and displaing it in a jsp page using @RequestParam
		@RequestMapping("editFormUsing@RequestParam")
		public String editForm(@RequestParam ("studentName") String name,Model model) {
			
			//String name=request.getParameter("studentName"); --> This is done behing the scene because of using @RequestParam
			name=name.toUpperCase();
			String result = "Hi" +" "+ name +"   ---> done by @RequestParam ";
			model.addAttribute("message",result);
			return "show-details";
		}
		
		
	}
