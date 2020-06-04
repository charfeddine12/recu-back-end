package com.recrutement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entities.Poste;
import com.recrutement.repository.PosteRepositroy;
import com.recrutement.services.PosteService;

@Service
public class PosteServiceImpl implements PosteService {

	@Autowired
	PosteRepositroy posteRepositroy;

	public PosteServiceImpl(PosteRepositroy posteRepositroy) {
		super();
		this.posteRepositroy = posteRepositroy;
	}

	@Override
	public List<Poste> getAll() {
		return posteRepositroy.findAll();

	}

	@Override
	public Poste getOne(Long id) {
		if (id != null)
			return posteRepositroy.getOne(id);
		return new Poste();
	}

	@Override
	public Poste save(Poste poste) {
		if (poste != null)
			return posteRepositroy.save(poste);
		return null;
	}

	@Override
	public boolean delete(Long id) {
		if (id != null)
			posteRepositroy.deleteById(id);
		if (posteRepositroy.getOne(id) != null)
			return false;
		return true;
	}

}
