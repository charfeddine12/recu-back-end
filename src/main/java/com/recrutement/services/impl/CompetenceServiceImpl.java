package com.recrutement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entities.Competence;
import com.recrutement.repository.CompetenceRepositroy;
import com.recrutement.services.CompetenceService;

@Service
public class CompetenceServiceImpl implements CompetenceService {

	@Autowired
	CompetenceRepositroy competenceRepositroy;

	public CompetenceServiceImpl(CompetenceRepositroy competenceRepositroy) {
		super();
		this.competenceRepositroy = competenceRepositroy;
	}

	@Override
	public List<Competence> getAll() {
		return competenceRepositroy.findAll();
	}

	@Override
	public Competence getOne(Long id) {
		if (id != null)
			return competenceRepositroy.getOne(id);
		return new Competence();
	}

	@Override
	public Competence save(Competence comptence) {
		if (comptence != null)
			return competenceRepositroy.save(comptence);
		return null;
	}

	@Override
	public boolean delete(Long id) {
		if (id != null)
			competenceRepositroy.deleteById(id);
		if (competenceRepositroy.getOne(id) != null)
			return false;
		return true;
	}

	@Override
	public List<Competence> getByDomaine(Long id) {
		return competenceRepositroy.getByDomaine(id);
	}

}
