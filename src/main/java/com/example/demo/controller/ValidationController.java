package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entity.Validation;
import com.example.demo.service.ValidationServiceImpl;

@Controller
public class ValidationController {	
	//Yassin Talssis
	@Autowired
	private ValidationServiceImpl repo;
	public ValidationController() {
		
	}
	public ValidationController(ValidationServiceImpl repo) {
		super();
		this.repo = repo;
	}
	@PostMapping("/admin/validation")
	public String saveStudent(@ModelAttribute("validation") Validation validation) {
		repo.saveValidation(validation);
		return "redirect:/admin/validation";
	}
	
	@GetMapping("/admin/validation")
	public String listValidations(Model model) {
			model.addAttribute("validation", repo.getAllValidations());
			return "/admin/validation";
		}

	@GetMapping("/validation/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id, Model model) {
		repo.deleteValidationById(id);
		return "redirect:/admin/validation";
	}
}
