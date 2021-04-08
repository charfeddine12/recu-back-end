package com.recrutement.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entities.CandidatExperience;
import com.recrutement.repository.CandidatExperienceRepository;
import com.recrutement.repository.CandidatRepositroy;
import com.recrutement.repository.ExperienceRepositroy;
import com.recrutement.services.CandidatExperienceService;

@Service
public class CandidatExperienceServiceImpl implements CandidatExperienceService{
	
	@Autowired
	private CandidatExperienceRepository candidatExperienceRepository;
	
	@Autowired
	private CandidatRepositroy candidatRepository;
	
	@Autowired
	private ExperienceRepositroy experienceRepository;

	@Override
	public CandidatExperience save(CandidatExperience candidatExperience) {
		return candidatExperienceRepository.save(candidatExperience);
	}

	@Override
	public CandidatExperience update(CandidatExperience candidatExperience) {
		return candidatExperienceRepository.save(candidatExperience);
	}

	@Override
	public CandidatExperience getById(Long id) {
		if (candidatExperienceRepository.findById(id).isPresent()) {
			return candidatExperienceRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public List<CandidatExperience> getAll() {
		return candidatExperienceRepository.findAll();
	}

	@Override
	public List<CandidatExperience> getByCandidat(Long id) {
		if (candidatRepository.findById(id).isPresent()) {
			return candidatExperienceRepository.getByCandidat(candidatRepository.findById(id).get());
		}
		return new ArrayList<CandidatExperience>();
	}

	@Override
	public List<CandidatExperience> getByExperience(Long id) {
		if(experienceRepository.findById(id).isPresent()) {
			return candidatExperienceRepository.getByExperience(experienceRepository.findById(id).get());
		}
		return new ArrayList<CandidatExperience>();
	}

	@Override
	public List<CandidatExperience> getByCandidatAndExperience(Long candidat, Long experience) {
		if (experienceRepository.findById(experience).isPresent() && candidatRepository.findById(candidat).isPresent()) {
			return candidatExperienceRepository.getByCandidatAndExperience(candidatRepository.findById(candidat).get(), experienceRepository.findById(experience).get());
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		candidatExperienceRepository.deleteById(id);
	}

}
