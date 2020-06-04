package com.recrutement.services;

import java.util.List;
import java.util.Optional;

import com.recrutement.entities.Candidature;

public interface CandidatureService {
	
	public Candidature save(Candidature candidature);
	
	public Candidature update(Candidature candidature);
	
	public Optional<Candidature> findById(Long id);
	
	public List<Candidature> findAll();
	
	public List<Candidature> findByOffre(Long id);
	
	public List<Candidature> findByCandidat(Long id);

	public void deleteByOffreAndCandidat(Long offre, Long candidat);

}
