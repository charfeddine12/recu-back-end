package com.recrutement.services;

import java.util.List;

import com.recrutement.entity.Formation;

public interface FormationService {

	List<Formation> getAll();
	Formation getOne(Long id);
	Formation save(Formation formation);
	void delete(Long id);
}
