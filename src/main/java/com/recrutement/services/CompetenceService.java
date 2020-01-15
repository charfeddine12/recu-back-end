package com.recrutement.services;

import java.util.List;

import com.recrutement.entity.Competence;

public interface CompetenceService {

	List<Competence> getAll();
	Competence getOne(Long id);
	Competence save(Competence comptence);
	boolean delete(Long id);
}
