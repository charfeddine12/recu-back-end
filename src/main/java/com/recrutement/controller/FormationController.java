package com.recrutement.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recrutement.entity.Formation;
import com.recrutement.services.FormationService;

@RestController
@RequestMapping("/api/formation")
public class FormationController {

	private final Logger log = LoggerFactory.getLogger(FormationController.class);

	@Autowired
	FormationService formationService;

	public FormationController(FormationService formationService) {
		super();
		this.formationService = formationService;
	}

	@GetMapping("/get")
	public List<Formation> getAllFormations() {
		final List<Formation> listFormation = formationService.getAll();
		return listFormation;
	}

	@GetMapping("/get/{id}")
	public Formation getFormation(@PathVariable Long id) {
		log.debug("REST request to get Formation : {}", id);
		Formation formation = null;
		if (id != null)
			formation = formationService.getOne(id);
		return formation;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteFormation(@PathVariable Long id) {
		log.debug("REST request to delete Formation: {}", id);
		boolean result = false;
		if (id != null)
			result = formationService.delete(id);
		return result;
	}

	@PostMapping("/save")
	public Formation createFormation(@RequestBody Formation formation) throws URISyntaxException {
		log.debug("REST request to save Formation : {}", formation);

		if (formation.getId() != null) {
			log.debug("A new Formation cannot already have an ID idexists");
		} else {
			Formation newFormation = formationService.save(formation);
			return newFormation;
		}
		return null;
	}

	@PutMapping("/update")
	public Formation updateFormation(@RequestBody Formation formation) {
		log.debug("REST request to update Formation : {}", formation);
		if (formation.getId() != null)
			if (formationService.getOne(formation.getId()) != null) {

				Formation updatedFormation = formationService.save(formation);
				return updatedFormation;
			}
		return null;

	}
}
