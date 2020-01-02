package com.recrutement.services;

import java.util.List;

import com.recrutement.entity.Experience;

public interface ExperienceService {

	List<Experience> getAll();
	Experience getOne(Long id);
	Experience save(Experience experience);
	void delete(Long id);
}
