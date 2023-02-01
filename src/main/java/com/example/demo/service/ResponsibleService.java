package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Responsible;


public interface ResponsibleService {
	
		List<Responsible> getAllResponsibles();	
		Responsible saveResponsible(Responsible respo);
		//Responsible getResponsibleById(Long id);
		Responsible updateResponsible(Responsible respo);
		void deleteResponsibleById(Long id);
		Responsible getResponsibleById(long id);
		void deleteResponsibleById(long id);
}
