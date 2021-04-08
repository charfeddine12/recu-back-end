package com.recrutement.services;

import java.util.List;

import com.recrutement.entities.Competence;

public interface CompetenceService {

	List<Competence> getAll();
	Competence getOne(Long id);
	Competence save(Competence comptence);
	boolean delete(Long id);
	List<Competence> getByDomaine(Long id);
}
