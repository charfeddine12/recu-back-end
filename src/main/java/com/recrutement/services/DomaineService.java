package com.recrutement.services;

import java.util.List;

import com.recrutement.entities.Domaine;

public interface DomaineService {

	List<Domaine> getAll();
	Domaine getOne(Long id);
	Domaine save(Domaine domaine);
	boolean delete(Long id);
}
