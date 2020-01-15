package com.recrutement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entity.Candidat;
import com.recrutement.entity.Utilisateur;
import com.recrutement.repository.UtilisateurRepositroy;
import com.recrutement.services.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	UtilisateurRepositroy utilisateurRepositroy;

	public UtilisateurServiceImpl(UtilisateurRepositroy utilisateurRepositroy) {
		super();
		this.utilisateurRepositroy = utilisateurRepositroy;
	}

	@Override
	public List<Utilisateur> getAll() {
		return utilisateurRepositroy.findAll();
	}

	@Override
	public Utilisateur getOne(Long id) {
		if (id != null)
			return utilisateurRepositroy.getOne(id);
		return new Candidat();
	}

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		if (utilisateur != null)
			return utilisateurRepositroy.save(utilisateur);
		return null;
	}

	@Override
	public boolean delete(Long id) {
		if (id != null)
			utilisateurRepositroy.deleteById(id);
		if (utilisateurRepositroy.getOne(id) != null)
			return false;
		return true;
	}

	@Override
	public boolean findOneByEmail(String email) {
		if (email != null)
			if (utilisateurRepositroy.findByEmail(email) == null)
				return false;
		return true;

	}

}
