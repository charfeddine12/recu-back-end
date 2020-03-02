package com.recrutement.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.controller.EmployeurController;
import com.recrutement.entity.Candidat;
import com.recrutement.entity.Offre;
import com.recrutement.repository.OffreRepositroy;
import com.recrutement.services.CandidatService;
import com.recrutement.services.EmployeurService;
import com.recrutement.services.OffreService;

@Service
public class OffreServiceImpl implements OffreService {

	private final Logger log = LoggerFactory.getLogger(EmployeurController.class);

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
	public boolean postuler(String id, String login) {
		Candidat candidat = candidatService.findCandidatByEmail(login);
		log.info(" get candidat : {}", candidat);

		Offre offre = offreRepository.getOne(Long.valueOf(id));
		log.info(" get offre : {}", offre);

		ArrayList<Offre> offres=new ArrayList<>();
		offres.add(offre);
		candidat.setOffres(offres);
		candidatService.save(candidat);
		return false;
	}

	@Override
	public List<Offre> findOffreByEmployeurId(String id) {
		if (id != null) {
			return employeurService.findOffreByEmployeurId(Long.valueOf(id));
		}
		return null;
	}
}
