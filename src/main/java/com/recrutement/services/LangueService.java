package com.recrutement.services;

import java.util.List;

import com.recrutement.entity.Langue;

public interface LangueService {

	List<Langue> getAll();
	Langue getOne(Long id);
	Langue save(Langue langue);
	void delete(Long id);
}
