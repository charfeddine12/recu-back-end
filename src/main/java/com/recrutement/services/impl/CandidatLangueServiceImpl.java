package com.recrutement.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entities.CandidatLangues;
import com.recrutement.repository.CandidatLangueRepository;
import com.recrutement.repository.CandidatRepositroy;
import com.recrutement.repository.LangueRepositroy;
import com.recrutement.services.CandidatLangueService;

@Service
public class CandidatLangueServiceImpl implements CandidatLangueService {

	@Autowired
	private CandidatLangueRepository candidatLangueRepository;

	@Autowired
	private CandidatRepositroy candidatRepository;

	@Autowired
	private LangueRepositroy langueRepositroy;

	@Override
	public CandidatLangues save(CandidatLangues candidatLangue) {
		return candidatLangueRepository.save(candidatLangue);
	}

	@Override
	public CandidatLangues update(CandidatLangues candidatLangue) {
		return candidatLangueRepository.save(candidatLangue);
	}

	@Override
	public CandidatLangues getById(Long id) {
		if (candidatLangueRepository.findById(id).isPresent()) {
			return candidatLangueRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public List<CandidatLangues> getAll() {
		return candidatLangueRepository.findAll();
	}

	@Override
	public List<CandidatLangues> getByCandidat(Long id) {
		if (candidatRepository.findById(id).isPresent()) {
			return candidatLangueRepository.getByCandidat(candidatRepository.findById(id).get());
		}
		return new ArrayList<CandidatLangues>();
	}

	@Override
	public List<CandidatLangues> getByLangue(Long id) {
		if (langueRepositroy.findById(id).isPresent()) {
			return candidatLangueRepository.getByLangue(langueRepositroy.findById(id).get());
		}
		return new ArrayList<CandidatLangues>();
	}

	@Override
	public List<CandidatLangues> getByCandidatAndLangue(Long candidat, Long langue) {
		if (candidatRepository.findById(candidat).isPresent() && langueRepositroy.findById(langue).isPresent()) {
			return candidatLangueRepository.getByCandidatAndLangue(candidatRepository.findById(candidat).get(),
					langueRepositroy.findById(langue).get());
		}
		return new ArrayList<CandidatLangues>();
	}

	@Override
	public void delete(Long id) {
		candidatLangueRepository.deleteById(id);
	}

}
