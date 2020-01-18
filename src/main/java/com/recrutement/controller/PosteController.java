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

import com.recrutement.entity.Poste;
import com.recrutement.services.PosteService;

@RestController
@RequestMapping("/api/poste")
public class PosteController {

	private final Logger log = LoggerFactory.getLogger(PosteController.class);

	@Autowired
	PosteService posteService;

	public PosteController(PosteService posteService) {
		super();
		this.posteService = posteService;
	}

	@GetMapping("/get")
	public List<Poste> getAllPostes() {
		final List<Poste> listPoste = posteService.getAll();
		return listPoste;
	}

	@GetMapping("/get/{id}")
	public Poste getPoste(@PathVariable Long id) {
		log.info("REST request to get Poste : {}", id);
		Poste poste = null;
		if (id != null)
			poste = posteService.getOne(id);
		return poste;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deletePoste(@PathVariable Long id) {
		log.info("REST request to delete Poste: {}", id);
		boolean result = false;
		if (id != null)
			result = posteService.delete(id);
		return result;
	}

	@PostMapping("/save")
	public Poste createPoste(@RequestBody Poste poste) throws URISyntaxException {
		log.info("REST request to save poste : {}", poste);

		if (poste.getId() != null) {
			log.info("A new Poste cannot already have an ID idexists");
		} else {
			Poste newPoste = posteService.save(poste);
			return newPoste;
		}
		return null;
	}

	@PutMapping("/update")
	public Poste updatePoste(@RequestBody Poste poste) {
		log.info("REST request to update Poste : {}", poste);
		if (poste.getId() != null)
			if (posteService.getOne(poste.getId()) != null) {

				Poste updatedPoste = posteService.save(poste);
				return updatedPoste;
			}
		return null;

	}
}
