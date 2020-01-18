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

import com.recrutement.entity.Employeur;
import com.recrutement.services.EmployeurService;

@RestController
@RequestMapping("/api/employeur")
public class EmployeurController {
	private final Logger log = LoggerFactory.getLogger(EmployeurController.class);

	@Autowired
	EmployeurService employeurService;

	public EmployeurController(EmployeurService employeurService) {
		super();
		this.employeurService = employeurService;
	}

	@GetMapping("/get")
	public List<Employeur> getAllemployeurs() {
		final List<Employeur> listemployeur = employeurService.getAll();
		return listemployeur;
	}

	@GetMapping("/get/{id}")
	public Employeur getEmployeur(@PathVariable Long id) {
		log.info("REST request to get Employeur : {}", id);
		Employeur employeur = null;
		if (id != null)
			employeur = employeurService.getOne(id);
		return employeur;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteEmployeur(@PathVariable Long id) {
		log.info("REST request to delete Employeur: {}", id);
		boolean result = false;
		if (id != null)
			result = employeurService.delete(id);
		return result;
	}

	@PostMapping("/save")
	public Employeur createEmployeur(@RequestBody Employeur employeur) throws URISyntaxException {
		log.info("REST request to save Employeur : {}", employeur);

		if (employeur.getId() != null) {
			log.info("A new employeur cannot already have an ID idexists");
		} else {
			Employeur newEmployeur = employeurService.save(employeur);
			return newEmployeur;
		}
		return null;
	}

	@PutMapping("/update")
	public Employeur updateEmployeur(@RequestBody Employeur employeur) {
		log.info("REST request to update Employeur : {}", employeur);
		if (employeur.getId() != null)
			if (employeurService.getOne(employeur.getId()) != null) {

				Employeur updatedEmployeur = employeurService.save(employeur);
				return updatedEmployeur;
			}
		return null;

	}
}
