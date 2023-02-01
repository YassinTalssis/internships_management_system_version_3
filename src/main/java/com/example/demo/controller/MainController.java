package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserRegistrationDto;
import com.example.demo.service.UserServiceImpl;




@Controller
public class MainController {
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("title", "Home page ");
		return "index";
	}
	@RequestMapping("/signin")
	public String login(Model model) {
		model.addAttribute("title", "Home page ");
		return "login";
	}
	@RequestMapping("/signup")
	public String signup(Model model) {
		
		model.addAttribute("title", "Register Page ");
		model.addAttribute("user", new UserRegistrationDto());
		return "registration";
	}
	@GetMapping("/student/profile")
	public String user_home(Model model) {
		
		model.addAttribute("title", "Registration page ");
		return "student/profile";
	}
	/*private UserServiceImpl repo;
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "profile";
	}
	
	
	@RequestMapping("/about")
	public String about(Model model) {
		
		model.addAttribute("title", "About ");
		return "about";
	}
	@RequestMapping("/signup")
	public String signup(Model model) {
		
		model.addAttribute("title", "Register Page ");
		model.addAttribute("user", new UserRegistrationDto());
		return "registration";
	}
	@RequestMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("title", "Login Page");
		return "login";
	}
	@RequestMapping(value="/do_register",method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") UserRegistrationDto user,@RequestParam(value="agreement",
	defaultValue="false") boolean agreement,Model model) {
		try {
			if(!agreement) {
				System.out.println("You don't agree en argument!!");
			}
			User result=this.repo.save(user);
			model.addAttribute("user", result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return"registration";
	}
	@GetMapping("/profile")
	public String updateProfile(@RequestParam("firstname") String firstname,
	                            @RequestParam("lastname") String lastname,
	                            @RequestParam("email") String email,
	                            @RequestParam("avatar") MultipartFile avatar,
	                            @RequestParam("password") String password) {
		model.addAttribute("student", new User());
		//model.addAttribute("listSts", listDepartements);
		model.addAttribute("added", true);
	    return "redirect:/profile";
	}*/
}
