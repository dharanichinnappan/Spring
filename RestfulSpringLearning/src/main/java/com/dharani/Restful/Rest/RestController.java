package com.dharani.Restful.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/test")
public class RestController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
}
