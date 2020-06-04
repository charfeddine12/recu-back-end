package com.recrutement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.recrutement.entities.Employeur;
import com.recrutement.entity.types.Role;
import com.recrutement.services.CandidatService;
import com.recrutement.services.EmployeurService;

@RestController
@RequestMapping("/api/employeur")
@CrossOrigin(origins = "*")
public class EmployeurController {
	private final Logger log = LoggerFactory.getLogger(EmployeurController.class);

	@Autowired
	EmployeurService employeurService;

	@Autowired
	CandidatService candidatService;

	public EmployeurController(EmployeurService employeurService, CandidatService candidatService,
			HttpServletRequest request) {
		super();
		this.employeurService = employeurService;
		this.candidatService = candidatService;
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
	public Employeur createEmployeur(@RequestBody Employeur employeur) throws Exception {
		log.info("REST request to save Employeur : {}", employeur);
		log.info("A nddddddd  : {}", employeurService.findOneByEmail(employeur.getEmail().toLowerCase()));
		log.info("A ndddcxcxcxc  : {} ", candidatService.findOneByEmail(employeur.getEmail().toLowerCase()));
		if (employeur.getId() != null) {
			log.info("A new employeur cannot already have an ID idexists");
		} else if (!employeurService.findOneByEmail(employeur.getEmail().toLowerCase())
				|| !candidatService.findOneByEmail(employeur.getEmail().toLowerCase())) {
			log.info("A new Employeur cannot already have an Email : {}", employeur.getEmail());
			throw new Exception("A new Employeur cannot already have an Email");
		} else {
			employeur.setRole(Role.EMPLOYEUR);
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

	@GetMapping("/getByLogin/{login}")
	public Employeur getByLoginEmployeur(@PathVariable String login) {
		log.info("REST request to get Employeur : {}", login);
		Employeur employeur = null;
		if (login != null)
			employeur = employeurService.findEmployeurByEmail(login);
		return employeur;
	}

	
}
