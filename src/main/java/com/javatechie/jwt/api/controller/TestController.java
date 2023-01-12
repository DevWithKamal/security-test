package com.javatechie.jwt.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/test")
	public String Test() {
		return "Welcome to Test Controller";
	}

	@GetMapping("/test1")
	public String Test1() {
		return "Welcome to Test Controller new";
	}

}
