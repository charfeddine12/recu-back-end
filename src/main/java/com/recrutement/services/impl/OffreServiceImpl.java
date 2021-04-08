package com.recrutement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entities.Offre;
import com.recrutement.repository.OffreRepositroy;
import com.recrutement.services.CandidatService;
import com.recrutement.services.EmployeurService;
import com.recrutement.services.OffreService;

@Service
public class OffreServiceImpl implements OffreService {


	@Autowired
	OffreRepositroy offreRepository;

	@Autowired
	CandidatService candidatService;
	
	@Autowired
	EmployeurService employeurService;
	
	public OffreServiceImpl(OffreRepositroy offreRepository,CandidatService candidatService,EmployeurService employeurService) {
		super();
		this.offreRepository = offreRepository;
		this.candidatService=candidatService;
		this.employeurService=employeurService;
	}

	@Override
	public List<Offre> getAll() {
		return offreRepository.findAll();
	}

	@Override
	public Offre getOne(Long id) {
		if (id != null)
			return offreRepository.getOne(id);
		return new Offre();
	}

	@Override
	public Offre save(Offre offre) {
		if (offre != null)
			return offreRepository.save(offre);
		return null;
	}

	@Override
	public boolean delete(Long id) {
		if (id != null)
			offreRepository.deleteById(id);
		if (offreRepository.getOne(id) != null)
			return false;
		return true;
	}

	@Override
	public List<Offre> getByEmploye(Long id) {
		return offreRepository.getByEmployeur(id);
	}


}
