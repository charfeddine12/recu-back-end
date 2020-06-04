package com.recrutement.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entities.CandidatCompetences;
import com.recrutement.repository.CandidatCompetenceRepository;
import com.recrutement.repository.CandidatRepositroy;
import com.recrutement.repository.CompetenceRepositroy;
import com.recrutement.services.CandidatCompetenceService;

@Service
public class CandidatCompetenceServiceImpl implements CandidatCompetenceService {

	@Autowired
	private CandidatCompetenceRepository candidatCompetenceRepository;

	@Autowired
	private CandidatRepositroy candidatRepository;

	@Autowired
	private CompetenceRepositroy competenceRepository;

	@Override
	public CandidatCompetences save(CandidatCompetences candidatCompetence) {
		if (candidatCompetenceRepository.getByCompetence(candidatCompetence.getCompetence()) == null) {
			return candidatCompetenceRepository.save(candidatCompetence);
		}
		return null;
	}

	@Override
	public CandidatCompetences update(CandidatCompetences candidatCompetence) {
		return candidatCompetenceRepository.save(candidatCompetence);
	}

	@Override
	public CandidatCompetences getById(Long id) {
		if (candidatCompetenceRepository.findById(id).isPresent()) {
			return candidatCompetenceRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public List<CandidatCompetences> getAll() {
		return candidatCompetenceRepository.findAll();
	}

	@Override
	public List<CandidatCompetences> getByCandidat(Long id) {
		if (candidatRepository.findById(id).isPresent()) {
			return candidatCompetenceRepository.getByCandidat(candidatRepository.findById(id).get());
		}
		return new ArrayList<CandidatCompetences>();
	}

	@Override
	public List<CandidatCompetences> getByCompetence(Long id) {
		if (competenceRepository.findById(id).isPresent()) {
			return candidatCompetenceRepository.getByCompetence(competenceRepository.findById(id).get());
		}
		return new ArrayList<CandidatCompetences>();
	}

	@Override
	public List<CandidatCompetences> getByCandidatAndCompetence(Long candidat, Long competence) {
		if (competenceRepository.findById(competence).isPresent()
				&& candidatRepository.findById(candidat).isPresent()) {
			return candidatCompetenceRepository.getByCandidatAndCompetence(candidatRepository.findById(candidat).get(),
					competenceRepository.findById(competence).get());
		}
		return new ArrayList<CandidatCompetences>();
	}

	@Override
	public void delete(Long id) {
		candidatCompetenceRepository.deleteById(id);
	}

}
