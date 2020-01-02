package com.recrutement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entity.Candidat;
import com.recrutement.repository.CandidatRepositroy;
import com.recrutement.services.CandidatService;

@Service
public class CandidatServiceImpl implements CandidatService {

	@Autowired
	CandidatRepositroy candidatRepository;

	public CandidatServiceImpl(CandidatRepositroy candidatRepository) {
		super();
		this.candidatRepository = candidatRepository;
	}

	@Override
	public List<Candidat> getAll() {
		return candidatRepository.findAll();
	}

	@Override
	public Candidat getOne(Long id) {
		if (id != null)
			return candidatRepository.getOne(id);
		return new Candidat();
	}

	@Override
	public Candidat save(Candidat candidat) {
		if (candidat != null)
			return candidatRepository.save(candidat);
		return null;
	}

	@Override
	public void delete(Long id) {
		if (id != null)
			candidatRepository.deleteById(id);

	}

}
