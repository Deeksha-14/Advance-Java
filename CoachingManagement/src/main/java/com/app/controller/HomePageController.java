package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor of Home Page");
	}

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}

}
