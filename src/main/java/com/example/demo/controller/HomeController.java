package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
	@RequestMapping("/home")
	
	public String home(Model model) {
		
		model.addAttribute("title", "Home page ");
		return "index";
	}
	
	
	
}
