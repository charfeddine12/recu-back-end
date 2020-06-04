package com.recrutement.services;

import java.util.List;

import com.recrutement.entities.CandidatLangues;

public interface CandidatLangueService {
	
	public CandidatLangues save(CandidatLangues candidatLangue);

	public CandidatLangues update(CandidatLangues candidatLangue);

	public CandidatLangues getById(Long id);

	public List<CandidatLangues> getAll();

	public List<CandidatLangues> getByCandidat(Long id);

	public List<CandidatLangues> getByLangue(Long id);

	public List<CandidatLangues> getByCandidatAndLangue(Long candidat, Long langue);

	public void delete(Long id);

}
