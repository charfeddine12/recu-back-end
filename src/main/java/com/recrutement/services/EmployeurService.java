package com.recrutement.services;

import java.util.List;

import com.recrutement.entity.Employeur;

public interface EmployeurService {

	List<Employeur> getAll();
	Employeur getOne(Long id);
	Employeur save(Employeur employeur);
	void delete(Long id);
}
