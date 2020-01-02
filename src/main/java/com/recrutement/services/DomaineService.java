package com.recrutement.services;

import java.util.List;

import com.recrutement.entity.Domaine;

public interface DomaineService {

	List<Domaine> getAll();
	Domaine getOne(Long id);
	Domaine save(Domaine domaine);
	void delete(Long id);
}
