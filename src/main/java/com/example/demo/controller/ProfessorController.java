package com.example.demo.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.service.StudentServiceImpl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProfessorController {
	
	
	@GetMapping("/professor/profile")
	public String professorProfile(Model model) {
		//List<Responsible> listStudents = studenttrepo.findAll();
		//model.addAttribute("responsible",repo.getAllResponsibles());
		return "/professor/profile";
	}
	@Autowired
	private StudentServiceImpl repo;
	

	@GetMapping("/professor/progress")
	public String getAllStudentttt(Model model) {	
		
	List<String> nameList= repo.getAllStudents().stream().map(x->x.getLastName()).collect(Collectors.toList());
	List<Long> ageList = repo.getAllStudents().stream().map(x-> x.getId()).collect(Collectors.toList());
	model.addAttribute("name", nameList);
	model.addAttribute("age", ageList);
	return "/professor/progress";
	
	}
	@GetMapping("/professor/meeting")
	public String getCalender() {
		
		return"professor/index";
	}
}
