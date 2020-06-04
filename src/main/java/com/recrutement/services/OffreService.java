package com.recrutement.services;

import java.util.List;

import com.recrutement.entities.Offre;

public interface OffreService {

	List<Offre> getAll();
	Offre getOne(Long id);
	Offre save(Offre offre);
	boolean delete(Long id);
	List<Offre> getByEmploye(Long id);
}
