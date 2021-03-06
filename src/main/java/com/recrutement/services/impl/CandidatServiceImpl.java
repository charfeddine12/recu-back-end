package com.recrutement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entities.Candidat;
import com.recrutement.repository.CandidatRepositroy;
import com.recrutement.services.CandidatService;

@Service
public class CandidatServiceImpl implements CandidatService {

	@Autowired
	private CandidatRepositroy candidatRepository;


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
	public boolean delete(Long id) {
		if (id != null) {
			candidatRepository.deleteById(id);

		}
		if (candidatRepository.getOne(id) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean findOneByEmail(String email) {
		if (email != null) {
			if (candidatRepository.findByEmail(email) == null)
				return true;
		}
		return false;

	}

	@Override
	public Candidat findCandidatByEmail(String login) {
		if (login != null) {
			return candidatRepository.findByEmail(login);
		}
		return null;

	}

}
