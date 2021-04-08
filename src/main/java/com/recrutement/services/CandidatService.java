package com.recrutement.services;

import java.util.List;

import com.recrutement.entities.Candidat;

public interface CandidatService {

	List<Candidat> getAll();
	Candidat getOne(Long id);
	Candidat save(Candidat candidat);
	boolean delete(Long id);
	boolean findOneByEmail(String email);
	Candidat findCandidatByEmail(String login);
}
