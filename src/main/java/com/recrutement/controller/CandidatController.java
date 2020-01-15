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

import com.recrutement.entity.Candidat;
import com.recrutement.entity.Role;
import com.recrutement.services.CandidatService;

@RestController
@RequestMapping("/api/candidat")
public class CandidatController {

	private final Logger log = LoggerFactory.getLogger(CandidatController.class);

	@Autowired
	CandidatService candidatService;

	public CandidatController(CandidatService candidatService) {
		super();
		this.candidatService = candidatService;
	}

	@GetMapping("/get")
	public List<Candidat> getAllCandidats() {
		final List<Candidat> listCandidat = candidatService.getAll();
		return listCandidat;
	}

	@GetMapping("/get/{id}")
	public Candidat getCandidat(@PathVariable Long id) {
		log.debug("REST request to get Candidat : {}", id);
		Candidat candidat = null;
		if (id != null)
			candidat = candidatService.getOne(id);
		return candidat;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteCandidat(@PathVariable Long id) {
		log.debug("REST request to delete candidat: {}", id);
		boolean result = false;
		if (id != null)
			result = candidatService.delete(id);
		return result;
	}

	@SuppressWarnings("static-access")
	@PostMapping("/save")
	public Candidat createCandidat(@RequestBody Candidat candidat) throws URISyntaxException {
		log.debug("REST request to save candidat : {}", candidat);

		if (candidat.getId() != null) {
			log.debug("A new candidat cannot already have an ID", "userManagement", "idexists");
		} else if (candidatService.findOneByEmail(candidat.getEmail().toLowerCase())) {
			log.debug("A new candidat cannot already have an Email : {}", candidat.getEmail());
		} else {
			candidat.setRole(Role.CANDIDAT.name());
			Candidat newCandidat = candidatService.save(candidat);
			return newCandidat;
		}
		return null;
	}

	@PutMapping("/update")
	public Candidat updateCandidat(@RequestBody Candidat candidat) {
		log.debug("REST request to update candidat : {}", candidat);
		boolean result = candidatService.findOneByEmail(candidat.getEmail());
		if (result) {
			log.debug("A new candidat cannot already have an Email : {}", candidat.getEmail());
			return null;
		} else {
			Candidat updatedCandidat = candidatService.save(candidat);

			return updatedCandidat;
		}

	}
}
