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

import com.recrutement.entity.Langue;
import com.recrutement.services.LangueService;

@RestController
@RequestMapping("/api/langue")
@CrossOrigin(origins = "http://localhost:4200")

public class LangueController {

	private final Logger log = LoggerFactory.getLogger(LangueController.class);

	@Autowired
	LangueService langueService;

	public LangueController(LangueService langueService) {
		super();
		this.langueService = langueService;
	}

	@GetMapping("/get")
	public List<Langue> getAllLangues() {
		final List<Langue> listLangue = langueService.getAll();
		return listLangue;
	}

	@GetMapping("/get/{id}")
	public Langue getLangue(@PathVariable Long id) {
		log.info("REST request to get Langue : {}", id);
		Langue langue = null;
		if (id != null)
			langue = langueService.getOne(id);
		return langue;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteLangue(@PathVariable Long id) {
		log.info("REST request to delete Langue: {}", id);
		boolean result = false;
		if (id != null)
			result = langueService.delete(id);
		return result;
	}

	@PostMapping("/save")
	public Langue createLangue(@RequestBody Langue langue) throws URISyntaxException {
		log.info("REST request to save Langue : {}", langue);

		if (langue.getId() != null) {
			log.info("A new langue cannot already have an ID idexists");
		} else {
			Langue newLangue = langueService.save(langue);
			return newLangue;
		}
		return null;
	}

	@PutMapping("/update")
	public Langue updateLangue(@RequestBody Langue langue) {
		log.info("REST request to update Langue : {}", langue);
		if (langue.getId() != null)
			if (langueService.getOne(langue.getId()) != null) {

				Langue updatedLangue = langueService.save(langue);
				return updatedLangue;
			}
		return null;

	}
}
