package com.recrutement.services;

import java.util.List;

import com.recrutement.entities.Experience;

public interface ExperienceService {

	List<Experience> getAll();
	Experience getOne(Long id);
	Experience save(Experience experience);
	boolean delete(Long id);
}
