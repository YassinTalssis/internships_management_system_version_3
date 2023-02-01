package com.example.demo.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entity.Etablissement;
import com.example.demo.service.EtablissementServiceImpl;


@Controller
public class EtablissementController {
	//Aissa chbaba
	@Autowired
	private EtablissementServiceImpl repo;

	public EtablissementController(EtablissementServiceImpl repo ) {
		super();
		this.repo=repo;
	}
	@GetMapping("/admin/etablissement")
	public String listEtablissement(Model model) {
		//List<Etablissement> listEtablissement = repo.getAllEtablissement();
		model.addAttribute("etablissement", repo.getAllEtablissement());
		return "/admin/etablissement";
	}
	
	@GetMapping("/admin/etablissement/new")
	public String showEtablissementNewForm(Model model) {
		//List<Etablissement> listEtablissement =repo.findAll();
		model.addAttribute("etablissement", new Etablissement());
		model.addAttribute("added", true);
		return "/admin/create_etablissement";
	}
	
	
	@PostMapping("/admin/etablissement/save")
	public String saveEtablissement(@ModelAttribute("etablissement") Etablissement etablissement) {
		repo.saveEtablissement(etablissement);
		return "redirect:/admin/etablissement";
	}
	
	@GetMapping("/admin/etablissement/edit/{id}")
	public String editEtablissementForm(@PathVariable int id, Model model) {
		model.addAttribute("etablissement", repo.getEtablissementById(id));
		return "/admin/edit_etablissement";
	}
	
	@PostMapping("/admin/etablissement/{id}")
	public String updateEtablissement(@PathVariable int id,
			@ModelAttribute("etablissement") Etablissement etablissement, Model model) {
		// get student from database by id
		Etablissement existingEtablissement = repo.getEtablissementById(id);
		existingEtablissement.setId(etablissement.getId());
		existingEtablissement.setName(etablissement.getName());
		// save updated student object
		if(existingEtablissement!=null)
				repo.updateEtablissement(etablissement);
		return "redirect:/admin/etablissement";
		}
	@GetMapping("/admin/etablissement/{id}")
	public String deleteStudent(@PathVariable int id) {
		repo.deleteEtablissementById(id);
		return "redirect:/admin/etablissement";
	}
}
