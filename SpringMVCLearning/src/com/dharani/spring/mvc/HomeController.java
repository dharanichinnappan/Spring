package com.dharani.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
	@Controller
	public class HomeController {
		@RequestMapping("/")
		public String showPage() {
			
			return "main-menu";
		}

	}
