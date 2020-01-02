package com.recrutement.services;

import java.util.List;

import com.recrutement.entity.Candidat;

public interface CandidatService {

	List<Candidat> getAll();
	Candidat getOne(Long id);
	Candidat save(Candidat candidat);
	void delete(Long id);
}
