package com.recrutement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entity.Domaine;
import com.recrutement.repository.DomaineRepositroy;
import com.recrutement.services.DomaineService;

@Service
public class DomaineServiceImpl implements DomaineService {

	@Autowired
	DomaineRepositroy domaineRepository;

	public DomaineServiceImpl(DomaineRepositroy domaineRepository) {
		super();
		this.domaineRepository = domaineRepository;
	}

	@Override
	public List<Domaine> getAll() {
		return domaineRepository.findAll();
	}

	@Override
	public Domaine getOne(Long id) {
		if (id != null)
			return domaineRepository.getOne(id);
		return new Domaine();
	}

	@Override
	public Domaine save(Domaine domaine) {
		if (domaine != null)
			return domaineRepository.save(domaine);
		return null;
	}

	@Override
	public boolean delete(Long id) {

		if (id != null)
			domaineRepository.deleteById(id);
		if (domaineRepository.getOne(id) != null)
			return false;
		return true;
	}

}
