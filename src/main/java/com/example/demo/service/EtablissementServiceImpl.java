


package com.example.demo.service;


import java.util.List;



import org.springframework.stereotype.Service;

import com.example.demo.entity.Etablissement;
import com.example.demo.repository.EtablissementRepository;


//import org.springframework.stereotype.Service;


@Service
public class EtablissementServiceImpl implements EtablissementService{
	
	private EtablissementRepository etablissementRepository;
	
	public EtablissementServiceImpl(EtablissementRepository etablissementRepository) {
		super();
		this.etablissementRepository = etablissementRepository;
	}
	@Override
	public List<Etablissement> getAllEtablissement() {
		return etablissementRepository.findAll();
	}

	@Override
	public Etablissement saveEtablissement(Etablissement etablissement) {
		return etablissementRepository.save(etablissement);
	}

	@Override
	public Etablissement getEtablissementById(int id) {
		return etablissementRepository.findById(id).get();
		//return null;
	}

	@Override
	public Etablissement updateEtablissement(Etablissement etablissement) {
		return etablissementRepository.save(etablissement);
	}

	@Override
	public void deleteEtablissementById(int id) {
		etablissementRepository.deleteById(id);	
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}
}