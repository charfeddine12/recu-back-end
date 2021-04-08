package com.recrutement.services;

import java.util.List;

import com.recrutement.entities.CandidatFormation;

public interface CandidatFormationService {
	
	public CandidatFormation save(CandidatFormation candidatFormation);

	public CandidatFormation update(CandidatFormation candidatFormation);

	public CandidatFormation getById(Long id);

	public List<CandidatFormation> getAll();

	public List<CandidatFormation> getByCandidat(Long id);

	public List<CandidatFormation> getByFormation(Long id);

	public List<CandidatFormation> getByCandidatAndFormation(Long candidat, Long formation);

	public void delete(Long id);

}
