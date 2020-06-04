package com.recrutement.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entities.CandidatFormation;
import com.recrutement.repository.CandidatFormationRepository;
import com.recrutement.repository.CandidatRepositroy;
import com.recrutement.repository.FormationRepositroy;
import com.recrutement.services.CandidatFormationService;

@Service
public class CandidatFormationServiceImpl implements CandidatFormationService {

	@Autowired
	private CandidatFormationRepository candidatFormationRepository;

	@Autowired
	private CandidatRepositroy candidatRepositroy;

	@Autowired
	private FormationRepositroy formationRepository;

	@Override
	public CandidatFormation save(CandidatFormation candidatFormation) {
		return candidatFormationRepository.save(candidatFormation);
	}

	@Override
	public CandidatFormation update(CandidatFormation candidatFormation) {
		return candidatFormationRepository.save(candidatFormation);
	}

	@Override
	public CandidatFormation getById(Long id) {
		if (candidatFormationRepository.findById(id).isPresent()) {
			return candidatFormationRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public List<CandidatFormation> getAll() {
		return candidatFormationRepository.findAll();
	}

	@Override
	public List<CandidatFormation> getByCandidat(Long id) {
		if (candidatRepositroy.findById(id).isPresent()) {
			return candidatFormationRepository.getByCandidat(candidatRepositroy.findById(id).get());
		}
		return new ArrayList<CandidatFormation>();
	}

	@Override
	public List<CandidatFormation> getByFormation(Long id) {
		if (formationRepository.findById(id).isPresent()) {
			return candidatFormationRepository.getByFormation(formationRepository.findById(id).get());
		}
		return new ArrayList<CandidatFormation>();
	}

	@Override
	public List<CandidatFormation> getByCandidatAndFormation(Long candidat, Long formation) {
		if (formationRepository.findById(formation).isPresent() && candidatRepositroy.findById(candidat).isPresent()) {
			return candidatFormationRepository.getByCandidatAndFormation(candidatRepositroy.findById(candidat).get(), formationRepository.findById(formation).get());
		}
		return new ArrayList<CandidatFormation>();
	}

	@Override
	public void delete(Long id) {
		candidatFormationRepository.deleteById(id);
	}

}
