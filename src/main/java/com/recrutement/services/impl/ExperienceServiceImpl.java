package com.recrutement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entities.Experience;
import com.recrutement.repository.ExperienceRepositroy;
import com.recrutement.services.ExperienceService;

@Service
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	ExperienceRepositroy experienceRepository;

	public ExperienceServiceImpl(ExperienceRepositroy experienceRepository) {
		super();
		this.experienceRepository = experienceRepository;
	}

	@Override
	public List<Experience> getAll() {
		return experienceRepository.findAll();
	}

	@Override
	public Experience getOne(Long id) {
		if (id != null)
			return experienceRepository.getOne(id);
		return new Experience();
	}

	@Override
	public Experience save(Experience experience) {
		if (experience != null)
			return experienceRepository.save(experience);
		return null;
	}

	@Override
	public boolean delete(Long id) {

		if (id != null)
			experienceRepository.deleteById(id);
		if (experienceRepository.getOne(id) != null)
			return false;
		return true;
	}

}
