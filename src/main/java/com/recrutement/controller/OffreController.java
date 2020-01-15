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

import com.recrutement.entity.Offre;
import com.recrutement.services.OffreService;

@RestController
@RequestMapping("/api/offre")
public class OffreController {

	private final Logger log = LoggerFactory.getLogger(OffreController.class);

	@Autowired
	OffreService offreService;

	public OffreController(OffreService offreService) {
		super();
		this.offreService = offreService;
	}

	@GetMapping("/get")
	public List<Offre> getAllOffres() {
		final List<Offre> listOffre = offreService.getAll();
		return listOffre;
	}

	@GetMapping("/get/{id}")
	public Offre getOffre(@PathVariable Long id) {
		log.debug("REST request to get Offre : {}", id);
		Offre offre = null;
		if (id != null)
			offre = offreService.getOne(id);
		return offre;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteOffre(@PathVariable Long id) {
		log.debug("REST request to delete Offre: {}", id);
		boolean result = false;
		if (id != null)
			result = offreService.delete(id);
		return result;
	}

	@SuppressWarnings("static-access")
	@PostMapping("/save")
	public Offre createOffre(@RequestBody Offre offre) throws URISyntaxException {
		log.debug("REST request to save Offre : {}", offre);

		if (offre.getId() != null) {
			log.debug("A new Offre cannot already have an ID idexists");
		} else {
			Offre newOffre = offreService.save(offre);
			return newOffre;
		}
		return null;
	}

	@PutMapping("/update")
	public Offre updateOffre(@RequestBody Offre offre) {
		log.debug("REST request to update Offre : {}", offre);
		if (offre.getId() != null)
			if (offreService.getOne(offre.getId()) != null) {

				Offre updatedOffre = offreService.save(offre);
				return updatedOffre;
			}
		return null;

	}
}
