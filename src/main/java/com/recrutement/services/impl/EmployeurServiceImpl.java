package com.recrutement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entity.Employeur;
import com.recrutement.repository.EmployeurRepositroy;
import com.recrutement.services.EmployeurService;

@Service
public class EmployeurServiceImpl implements EmployeurService {

	@Autowired
	EmployeurRepositroy employeurRepository;

	public EmployeurServiceImpl(EmployeurRepositroy employeurRepository) {
		super();
		this.employeurRepository = employeurRepository;
	}

	@Override
	public List<Employeur> getAll() {
		return employeurRepository.findAll();
	}

	@Override
	public Employeur getOne(Long id) {
		if (id != null)
			return employeurRepository.getOne(id);
		return new Employeur();
	}

	@Override
	public Employeur save(Employeur employeur) {
		if (employeur != null)
			return employeurRepository.save(employeur);
		return null;
	}

	@Override
	public boolean delete(Long id) {

		if (id != null)
			employeurRepository.deleteById(id);
		if (employeurRepository.getOne(id) != null)
			return false;
		return true;
	}
	@Override
	public boolean findOneByEmail(String email) {
		if (email != null) {
			if (employeurRepository.findByEmail(email) == null)
				return true;
		}
		return false;

	}
}
