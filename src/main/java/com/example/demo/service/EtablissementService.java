package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Etablissement;


public interface EtablissementService {
	List<Etablissement> getAllEtablissement();
	
	Etablissement saveEtablissement(Etablissement student);
	
	Etablissement getEtablissementById(int id);
	
	Etablissement updateEtablissement(Etablissement student);
	
	void deleteEtablissementById(int id);

	void deleteById(int id);

	
}
