package com.recrutement.services;

import java.util.List;

import com.recrutement.entities.Poste;

public interface PosteService {

	List<Poste> getAll();
	Poste getOne(Long id);
	Poste save(Poste poste);
	boolean delete(Long id);
}
