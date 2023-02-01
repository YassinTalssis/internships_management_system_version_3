package com.example.demo.controller;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.Responsible;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.ResponsibleServiceImpl;
import com.example.demo.service.UserDetailsServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Controller
public class ResponsibleController {
	//Aissa chbaba

	
	@Autowired
	private ResponsibleServiceImpl repo;
	
	@Autowired
	private UserDetailsServiceImpl userSer;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	public ResponsibleController(ResponsibleServiceImpl repo,UserDetailsServiceImpl userSer) {
		super();
		this.repo = repo;
		this.userSer=userSer;
	}

	@GetMapping("/admin/responsible/new")
	public String showNewResponsibleForm(Model model) {
		//List<Etablissement> listEtablissements =repo.getAll();
		
		model.addAttribute("responsible", new Responsible());
		//model.addAttribute("listResponsibles", listEtablissements);
		model.addAttribute("added", true);
		
		return "/admin/create_responsible";
	}
	
	@PostMapping("/admin/responsible/save")
	public String saveResponsable(@ModelAttribute("responsible") Responsible responsible) {
		repo.saveResponsible(responsible);
		userSer.save(new User(responsible.getFirstName(),responsible.getLastName(),
				responsible.getEmail(),passwordEncoder.encode(responsible.getPassword()),true,Arrays.asList(new Role("RESPONSIBLE"))));
		return "redirect:/admin/responsible";
	}
	
	@GetMapping("/admin/responsible")
	public String listResponsible(Model model) {
		//List<Responsible> listStudents = studenttrepo.findAll();
		model.addAttribute("responsible",repo.getAllResponsibles());
		return "/admin/responsible";
	}
	@GetMapping("/admin/responsible/{id}")
	public String showEditResponsibleForm(@PathVariable("id") long id, Model model) {
		Responsible responsible =repo.getResponsibleById(id);
		model.addAttribute("responsible ", responsible );
		model.addAttribute("edit", true);
		
		//List<Etablissement> listDepartements =etablissementRepo.findAll();
		
		//model.addAttribute("listDepartements", listDepartements);
		return "/admin/edit_responsible";
	}
	@GetMapping("/admin/responsible/edit/{id}")
	public String editEtablissementForm(@PathVariable long id, Model model) {
		model.addAttribute("responsible", repo.getResponsibleById(id));
		return "/admin/edit_responsible";
	}
	
	@PostMapping("/admin/responsible/{id}")
	public String updateEtablissement(@PathVariable long id,
			@ModelAttribute("responsible") Responsible responsible, Model model) {
		
		// get student from database by id
		Responsible existingResponsible = repo.getResponsibleById(id);
		existingResponsible.setId(responsible.getId());
		existingResponsible.setFirstName(responsible.getFirstName());
		// save updated student object
		if(existingResponsible!=null)
				repo.updateResponsible(responsible);
		return "redirect:/admin/responsible";
		}
	@GetMapping("/admin/responsible/delete/{id}")
	public String deleteResponsible(@PathVariable("id") long id, Model model) {
		repo.deleteResponsibleById(id);
		return "redirect:/admin/responsible";
	}
	
	@GetMapping("/responsible/profile/{id}")
	public String respo_profile(@PathVariable("id") long id, Model model) {
		model.addAttribute("profile",repo.getResponsibleById(id));
		model.addAttribute("edit", true);
		return "responsible/profile";
	}
	
}
