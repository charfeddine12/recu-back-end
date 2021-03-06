package com.recrutement.services;

import java.util.List;

import com.recrutement.entities.Langue;

public interface LangueService {

	List<Langue> getAll();
	Langue getOne(Long id);
	Langue save(Langue langue);
	boolean delete(Long id);
}
