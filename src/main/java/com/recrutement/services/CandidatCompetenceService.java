package com.recrutement.services;

import java.util.List;

import com.recrutement.entities.CandidatCompetences;

public interface CandidatCompetenceService {
	
	public CandidatCompetences save(CandidatCompetences candidatCompetence);

	public CandidatCompetences update(CandidatCompetences candidatCompetence);

	public CandidatCompetences getById(Long id);

	public List<CandidatCompetences> getAll();

	public List<CandidatCompetences> getByCandidat(Long id);

	public List<CandidatCompetences> getByCompetence(Long id);

	public List<CandidatCompetences> getByCandidatAndCompetence(Long candidat, Long competence);

	public void delete(Long id);

}
