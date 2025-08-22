package com.productapp.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api")
public class HelloController {
	
	@Value("${db.type}")
	private String type;
	
	
	@GetMapping(path="profile")
	public String hello() {
		return type;
	}
	
	@GetMapping(path="hello/{name}")
	public String hello(@PathVariable("name") String name) {
		return "hello all oracle champs "+ name;
	}
	//RequestParam
	@GetMapping(path="hello2")
	public String hello2(@RequestParam("name")String name, 
			@RequestParam("city")String city) {
		return "hello all oracle champs "+ name+ " : "+ city;
	}
}
