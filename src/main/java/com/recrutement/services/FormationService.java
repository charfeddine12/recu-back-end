package com.recrutement.services;

import java.util.List;

import com.recrutement.entities.Formation;

public interface FormationService {

	List<Formation> getAll();
	Formation getOne(Long id);
	Formation save(Formation formation);
	boolean delete(Long id);
}
