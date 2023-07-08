package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomePageController{
	
	public HomePageController() {
		System.out.println("in the ctor of home page controller"+LocalDateTime.now()+getClass());
	}

}
