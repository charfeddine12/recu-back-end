package com.recrutement.services;

import java.util.List;

import com.recrutement.entity.Offre;

public interface OffreService {

	List<Offre> getAll();
	Offre getOne(Long id);
	Offre save(Offre offre);
	boolean delete(Long id);
	boolean postuler(String id, String login);
	List<Offre> findOffreByEmployeurId(String id);
}
