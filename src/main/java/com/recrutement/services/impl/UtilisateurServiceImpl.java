package com.recrutement.services.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entity.Candidat;
import com.recrutement.entity.Employeur;
import com.recrutement.entity.Utilisateur;
import com.recrutement.repository.CandidatRepositroy;
import com.recrutement.repository.EmployeurRepositroy;
import com.recrutement.repository.UtilisateurRepositroy;
import com.recrutement.services.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	UtilisateurRepositroy utilisateurRepositroy;

	@Autowired
	CandidatRepositroy candidatRepositroy;

	@Autowired
	EmployeurRepositroy employeurRepositroy;

	@Autowired
	private HttpServletRequest request;

	public UtilisateurServiceImpl(UtilisateurRepositroy utilisateurRepositroy, CandidatRepositroy candidatRepositroy,
			EmployeurRepositroy employeurRepositroy, HttpServletRequest request) {
		super();
		this.utilisateurRepositroy = utilisateurRepositroy;
		this.candidatRepositroy = candidatRepositroy;
		this.employeurRepositroy = employeurRepositroy;
		this.request = request;
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

	@Override
	public Utilisateur findUserByEmail(String email) {
		Utilisateur utilisateur = null;
		if (email != null) {
			utilisateur = utilisateurRepositroy.findByEmail(email);
		}
		if (utilisateur != null) {
			return utilisateur;
		} else {
			return null;
		}

	}

	@Override
	public Utilisateur authentication(String login, String pwd) {
		Employeur employeur = null;
		Candidat candidat = null;
		if (login != null && pwd != null) {
			employeur = employeurRepositroy.authentication(login, pwd);
			if (employeur == null) {
				candidat = candidatRepositroy.authentication(login, pwd);
			}
		}
		if (candidat != null) {
			return candidat;
		} else if (employeur != null) {
			return employeur;
		} else {
			return null;
		}

	}

}
