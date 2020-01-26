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

import com.recrutement.entity.Competence;
import com.recrutement.services.CompetenceService;

@RestController
@RequestMapping("/api/competence")
@CrossOrigin(origins = "http://localhost:4200")

public class CompetenceController {

	private final Logger log = LoggerFactory.getLogger(CompetenceController.class);

	@Autowired
	CompetenceService competenceService;

	public CompetenceController(CompetenceService competenceService) {
		super();
		this.competenceService = competenceService;
	}

	@GetMapping("/get")
	public List<Competence> getAllCompetences() {
		final List<Competence> listCompetence = competenceService.getAll();
		return listCompetence;
	}

	@GetMapping("/get/{id}")
	public Competence getCompetence(@PathVariable Long id) {
		log.info("REST request to get competence : {}", id);
		Competence competence = null;
		if (id != null)
			competence = competenceService.getOne(id);
		return competence;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteCompetence(@PathVariable Long id) {
		log.info("REST request to delete competence: {}", id);
		boolean result = false;
		if (id != null)
			result = competenceService.delete(id);
		return result;
	}

	@PostMapping("/save")
	public Competence createCompetence(@RequestBody Competence competence) throws URISyntaxException {
		log.info("REST request to save candidat : {}", competence);

		if (competence.getId() != null) {
			log.info("A new candidat cannot already have an ID", "userManagement", "idexists");
		} else {
			Competence newCompetence = competenceService.save(competence);
			return newCompetence;
		}
		return null;
	}

	@PutMapping("/update")
	public Competence updateCompetence(@RequestBody Competence competence) {
		log.info("REST request to update candidat : {}", competence);
		if (competence.getId() != null)
			if (competenceService.getOne(competence.getId()) != null) {

				Competence updatedCompetence = competenceService.save(competence);
				return updatedCompetence;
			}
		return null;

	}
}
