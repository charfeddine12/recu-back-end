package com.recrutement.controller;

import java.util.List;
import java.util.Optional;

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

import com.recrutement.entities.Candidature;
import com.recrutement.entity.types.Etat;
import com.recrutement.services.CandidatureService;

@RestController
@RequestMapping("/api/candidature")
@CrossOrigin(origins = "*")
public class CandidatureController {

	@Autowired
	private CandidatureService candidatureService;

	@PostMapping("/save")
	public Candidature save(@RequestBody Candidature candidature) {
		return candidatureService.save(candidature);
	}

	@PutMapping("/update")
	public Candidature update(@RequestBody Candidature candidature) {
		return candidatureService.update(candidature);
	}

	@GetMapping("/get/{i}")
	public Optional<Candidature> findById(@PathVariable("id")Long id){
		return candidatureService.findById(id);
	}

	@GetMapping("/get")
	public List<Candidature> findAll(){
		return candidatureService.findAll();
	}

	@GetMapping("/getByOffre/{id}")
	public List<Candidature> findByOffre(@PathVariable("id")Long id){
		return candidatureService.findByOffre(id);
	}

	@GetMapping("/getByCandidat/{id}")
	public List<Candidature> findByCandidat(@PathVariable("id")Long id){
		return candidatureService.findByCandidat(id);
	}
	
	@DeleteMapping("/deleteByRelations/{offre}/{candidat}")
	public void deleteByOffreAndCandidat(@PathVariable("offre")Long offre, @PathVariable("candidat")Long candidat) {
		 candidatureService.deleteByOffreAndCandidat(offre, candidat);
	}
	
	@PutMapping("/accept")
	public Candidature accept(@RequestBody Candidature candidature) {
		candidature.setEtat(Etat.ACCEPTE);
		return candidatureService.update(candidature);
	}
	
	@PutMapping("/refuse")
	public Candidature refuse(@RequestBody Candidature candidature) {
		candidature.setEtat(Etat.REFUSE);
		return candidatureService.update(candidature);
	}


}
