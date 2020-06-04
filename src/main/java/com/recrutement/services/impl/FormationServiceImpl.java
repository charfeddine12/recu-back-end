package com.recrutement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entities.Formation;
import com.recrutement.repository.FormationRepositroy;
import com.recrutement.services.FormationService;

@Service
public class FormationServiceImpl implements FormationService{

	@Autowired
	FormationRepositroy formationRepositroy;
	
	
	public FormationServiceImpl(FormationRepositroy formationRepositroy) {
		super();
		this.formationRepositroy = formationRepositroy;
	}

	@Override
	public List<Formation> getAll() {
		return formationRepositroy.findAll();
	}

	@Override
	public Formation getOne(Long id) {
		if (id != null)
			return formationRepositroy.getOne(id);
		return new Formation();
	}

	@Override
	public Formation save(Formation formation) {
		if (formation != null)
			return formationRepositroy.save(formation);
		return null;
	}

	@Override
	public boolean delete(Long id) {
		if (id != null)
			formationRepositroy.deleteById(id);
		if (formationRepositroy.getOne(id) != null)
			return false;
		return true;
	}

}
