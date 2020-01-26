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

import com.recrutement.entity.Domaine;
import com.recrutement.services.DomaineService;

@RestController
@RequestMapping("/api/domaine")
@CrossOrigin(origins = "http://localhost:4200")

public class DomaineController {

	private final Logger log = LoggerFactory.getLogger(DomaineController.class);

	@Autowired
	DomaineService domaineService;

	public DomaineController(DomaineService domaineService) {
		super();
		this.domaineService = domaineService;
	}

	@GetMapping("/get")
	public List<Domaine> getAllDomaines() {
		final List<Domaine> listDomaine = domaineService.getAll();
		return listDomaine;
	}

	@GetMapping("/get/{id}")
	public Domaine getDomaine(@PathVariable Long id) {
		log.info("REST request to get Domaine : {}", id);
		Domaine domaine = null;
		if (id != null)
			domaine = domaineService.getOne(id);
		return domaine;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteDomaine(@PathVariable Long id) {
		log.info("REST request to delete competence: {}", id);
		boolean result = false;
		if (id != null)
			result = domaineService.delete(id);
		return result;
	}

	@PostMapping("/save")
	public Domaine createDomaine(@RequestBody Domaine domaine) throws URISyntaxException {
		log.info("REST request to save candidat : {}", domaine);

		if (domaine.getId() != null) {
			log.info("A new candidat cannot already have an ID idexists");
		} else {
			Domaine newDomaine = domaineService.save(domaine);
			return newDomaine;
		}
		return null;
	}

	@PutMapping("/update")
	public Domaine updateDomaine(@RequestBody Domaine domaine) {
		log.info("REST request to update candidat : {}", domaine);
		if (domaine.getId() != null)
			if (domaineService.getOne(domaine.getId()) != null) {

				Domaine updatedDomaine = domaineService.save(domaine);
				return updatedDomaine;
			}
		return null;

	}
}
