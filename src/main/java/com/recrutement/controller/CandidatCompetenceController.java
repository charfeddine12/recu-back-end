package com.recrutement.controller;

import java.util.List;

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

import com.recrutement.entities.CandidatCompetences;
import com.recrutement.services.CandidatCompetenceService;

@RestController
@RequestMapping("/api/candidatCompetence")
@CrossOrigin(origins = "*")
public class CandidatCompetenceController {
	
	@Autowired
	private CandidatCompetenceService candidatCompetenceService;
	
	@PostMapping("/save")
	public CandidatCompetences save(@RequestBody CandidatCompetences candidatCompetence) {
		return candidatCompetenceService.save(candidatCompetence);
	}

	@PutMapping("/update")
	public CandidatCompetences update(@RequestBody CandidatCompetences candidatCompetence) {
		return candidatCompetenceService.update(candidatCompetence);
	}

	@GetMapping("/get/{id}")
	public CandidatCompetences getById(@PathVariable("id")Long id) {
		return candidatCompetenceService.getById(id);
	}

	@GetMapping("/get")
	public List<CandidatCompetences> getAll(){
		return candidatCompetenceService.getAll();
	}

	@GetMapping("/byCandidat/{candidat}")
	public List<CandidatCompetences> getByCandidat(@PathVariable("candidat")Long id){
		return candidatCompetenceService.getByCandidat(id);
	}

	@GetMapping("/byCompetence/{competence}")
	public List<CandidatCompetences> getByCompetence(@PathVariable("competence")Long id) {
		return candidatCompetenceService.getByCompetence(id);
	}

	@GetMapping("/byCandidatCompetence/{candidat}/{competence}")
	public List<CandidatCompetences> getByCandidatAndCompetence(@PathVariable("candidat")Long candidat, @PathVariable("competence")Long competence){
		return candidatCompetenceService.getByCandidatAndCompetence(candidat, competence);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id")Long id) {
		candidatCompetenceService.delete(id);
	}

}
