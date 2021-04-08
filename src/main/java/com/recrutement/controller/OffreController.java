package com.recrutement.controller;

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

import com.recrutement.entities.Offre;
import com.recrutement.services.CandidatService;
import com.recrutement.services.EmployeurService;
import com.recrutement.services.OffreService;

@RestController
@RequestMapping("/api/offre")
@CrossOrigin(origins = "*")
public class OffreController {

	private final Logger log = LoggerFactory.getLogger(OffreController.class);

	@Autowired
	OffreService offreService;

	@Autowired
	CandidatService candidatService;

	@Autowired
	EmployeurService employeurService;

	public OffreController(OffreService offreService, CandidatService candidatService) {
		super();
		this.offreService = offreService;
		this.candidatService = candidatService;
	}

	@GetMapping("/get")
	public List<Offre> getAllOffres() {
		log.info("REST request to get all Offre : {}");

		final List<Offre> listOffre = offreService.getAll();
		return listOffre;
	}

	@GetMapping("/get/{id}")
	public Offre getOffre(@PathVariable Long id) {
		log.info("REST request to get Offre : {}", id);
		Offre offre = null;
		if (id != null)
			offre = offreService.getOne(id);
		return offre;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteOffre(@PathVariable Long id) {
		log.info("REST request to delete Offre: {}", id);
		boolean result = false;
		if (id != null)
			result = offreService.delete(id);
		return result;
	}

	@PostMapping("/save")
	public Offre createOffre(@RequestBody Offre offre){
		log.info("REST request to save Offre : {}", offre);
			Offre newOffre = offreService.save(offre);
			return newOffre;
	}

	@PutMapping("/update")
	public Offre updateOffre(@RequestBody Offre offre) {
		if (offre.getId() != null)
			if (offreService.getOne(offre.getId()) != null) {

				Offre updatedOffre = offreService.save(offre);
				return updatedOffre;
			}
		return null;

	}

	@GetMapping("/getMyOffres/{id}")
	public List<Offre> getMyOffres(@PathVariable Long id) {
		return offreService.getByEmploye(id);
	}
}
