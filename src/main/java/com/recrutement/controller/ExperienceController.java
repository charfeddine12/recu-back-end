package com.recrutement.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recrutement.entity.Experience;
import com.recrutement.services.ExperienceService;

@RestController
@RequestMapping("/api/experience")
@CrossOrigin(origins = "http://localhost:4200")

public class ExperienceController {

	private final Logger log = LoggerFactory.getLogger(ExperienceController.class);

	@Autowired
	ExperienceService experienceService;

	public ExperienceController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}

	@GetMapping("/get")
	public List<Experience> getAllExperiences() {
		final List<Experience> listExperience = experienceService.getAll();
		return listExperience;
	}

	@GetMapping("/get/{id}")
	public Experience getExperience(@PathVariable Long id) {
		log.info("REST request to get Experience : {}", id);
		Experience experience = null;
		if (id != null)
			experience = experienceService.getOne(id);
		return experience;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteExperience(@PathVariable Long id) {
		log.info("REST request to delete Experience: {}", id);
		boolean result = false;
		if (id != null)
			result = experienceService.delete(id);
		return result;
	}

	@PostMapping("/save")
	public Experience createExperience(@RequestBody Experience experience) throws URISyntaxException {
		log.info("REST request to save Experience : {}", experience);

		if (experience.getId() != null) {
			log.info("A new experience cannot already have an ID idexists");
		} else {
			Experience newExperience = experienceService.save(experience);
			return newExperience;
		}
		return null;
	}

	@PutMapping("/update")
	public Experience updateExperience(@RequestBody Experience experience) {
		log.info("REST request to update Experience : {}", experience);
		if (experience.getId() != null)
			if (experienceService.getOne(experience.getId()) != null) {

				Experience updatedExperience = experienceService.save(experience);
				return updatedExperience;
			}
		return null;

	}
}
