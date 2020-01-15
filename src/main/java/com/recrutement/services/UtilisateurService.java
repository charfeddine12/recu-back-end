package com.recrutement.services;

import java.util.List;

import com.recrutement.entity.Utilisateur;

public interface UtilisateurService {

	List<Utilisateur> getAll();
	Utilisateur getOne(Long id);
	Utilisateur save(Utilisateur utilisateur);
	boolean delete(Long id);
	boolean findOneByEmail(String email);
}
