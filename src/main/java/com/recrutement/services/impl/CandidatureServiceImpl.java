package com.recrutement.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entities.Candidature;
import com.recrutement.entity.types.Etat;
import com.recrutement.repository.CandidatRepositroy;
import com.recrutement.repository.CandidatureRepository;
import com.recrutement.repository.OffreRepositroy;
import com.recrutement.services.CandidatureService;

@Service
@Transactional
public class CandidatureServiceImpl implements CandidatureService{
	
	@Autowired
	private CandidatureRepository candidatureRepository;
	
	@Autowired
	private CandidatRepositroy candidatRepository;
	
	@Autowired
	private OffreRepositroy offreRepository;

	@Override
	public Candidature save(Candidature candidature) {
		candidature.setEtat(Etat.EN_ATTENTE);
		return candidatureRepository.save(candidature);
	}

	@Override
	public Candidature update(Candidature candidature) {
		return candidatureRepository.save(candidature);
	}

	@Override
	public Optional<Candidature> findById(Long id) {
		return candidatureRepository.findById(id);
	}

	@Override
	public List<Candidature> findAll() {
		return candidatureRepository.findAll();
	}

	@Override
	public List<Candidature> findByOffre(Long id) {
		return candidatureRepository.getByOffre(offreRepository.getOne(id));
	}

	@Override
	public List<Candidature> findByCandidat(Long id) {
		return candidatureRepository.getByCandidat(candidatRepository.getOne(id));
	}

	@Override
	public void deleteByOffreAndCandidat(Long offre, Long candidat) {
		candidatureRepository.deleteByOffreAndCandidat(offreRepository.getOne(offre), candidatRepository.getOne(candidat));
		
	}

}
