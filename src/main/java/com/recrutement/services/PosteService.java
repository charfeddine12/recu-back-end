package com.recrutement.services;

import java.util.List;

import com.recrutement.entity.Poste;

public interface PosteService {

	List<Poste> getAll();
	Poste getOne(Long id);
	Poste save(Poste poste);
	void delete(Long id);
}
