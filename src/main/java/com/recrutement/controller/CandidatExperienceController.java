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

import com.recrutement.entities.CandidatExperience;
import com.recrutement.services.CandidatExperienceService;

@RestController
@RequestMapping("/api/candidatExperience")
@CrossOrigin(origins = "*")
public class CandidatExperienceController {
	
	@Autowired
	private CandidatExperienceService candidatExperienceService;

	@PostMapping("/save")
	public CandidatExperience save(@RequestBody CandidatExperience candidatExperience) {
		return candidatExperienceService.save(candidatExperience);
	}

	@PutMapping("/update")
	public CandidatExperience update(@RequestBody CandidatExperience candidatExperience) {
		return candidatExperienceService.update(candidatExperience);
	}

	@GetMapping("/get/{id}")
	public CandidatExperience getById(@PathVariable("id")Long id) {
		return candidatExperienceService.getById(id);
	}

	@GetMapping("/get")
	public List<CandidatExperience> getAll(){
		return candidatExperienceService.getAll();
	}

	@GetMapping("/byCandidat/{candidat}")
	public List<CandidatExperience> getByCandidat(@PathVariable("candidat")Long id){
		return candidatExperienceService.getByCandidat(id);
	}

	@GetMapping("/byExperience/{experience}")
	public List<CandidatExperience> getByExperience(@PathVariable("experience")Long id){
		return candidatExperienceService.getByExperience(id);
	}

	@GetMapping("/byCandidatExperience/{candidat}/{experience}")
	public List<CandidatExperience> getByCandidatAndExperience(@PathVariable("candidat")Long candidat, @PathVariable("experience")Long experience){
		return candidatExperienceService.getByCandidatAndExperience(candidat, experience);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id")Long id) {
		candidatExperienceService.delete(id);
	}

}
