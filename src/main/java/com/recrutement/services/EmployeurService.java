package com.recrutement.services;

import java.util.List;

import com.recrutement.entities.Employeur;

public interface EmployeurService {

	List<Employeur> getAll();
	Employeur getOne(Long id);
	Employeur save(Employeur employeur);
	boolean delete(Long id);
	boolean findOneByEmail(String lowerCase);
	Employeur findEmployeurByEmail(String login);
}
