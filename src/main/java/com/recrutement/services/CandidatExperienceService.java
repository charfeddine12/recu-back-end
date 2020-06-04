package com.recrutement.services;

import java.util.List;

import com.recrutement.entities.CandidatExperience;

public interface CandidatExperienceService {

	public CandidatExperience save(CandidatExperience candidatExperience);
	
	public CandidatExperience update(CandidatExperience candidatExperience);
	
	public CandidatExperience getById(Long id);
	
	public List<CandidatExperience> getAll();
	
	public List<CandidatExperience> getByCandidat(Long id);
	
	public List<CandidatExperience> getByExperience(Long id);
	
	public List<CandidatExperience> getByCandidatAndExperience(Long candidat, Long experience);
	
	public void delete(Long id);
}
