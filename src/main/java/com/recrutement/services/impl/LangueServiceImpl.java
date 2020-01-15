package com.recrutement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entity.Langue;
import com.recrutement.repository.LangueRepositroy;
import com.recrutement.services.LangueService;

@Service
public class LangueServiceImpl implements LangueService{

	@Autowired
	LangueRepositroy langueRepository;
	
	
	public LangueServiceImpl(LangueRepositroy langueRepository) {
		super();
		this.langueRepository = langueRepository;
	}

	@Override
	public List<Langue> getAll() {
		return langueRepository.findAll();

	}

	@Override
	public Langue getOne(Long id) {
		if (id != null)
			return langueRepository.getOne(id);
		return new Langue();
	}

	@Override
	public Langue save(Langue langue) {
		if (langue != null)
			return langueRepository.save(langue);
		return null;
	}

	@Override
	public boolean delete(Long id) {
		if (id != null)
			langueRepository.deleteById(id);
		if (langueRepository.getOne(id) != null)
			return false;
		return true;
	}

}
