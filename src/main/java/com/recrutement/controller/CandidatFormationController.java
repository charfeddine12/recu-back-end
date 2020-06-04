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

import com.recrutement.entities.CandidatFormation;
import com.recrutement.services.CandidatFormationService;

@RestController
@RequestMapping("/api/candidatFormation")
@CrossOrigin(origins = "*")
public class CandidatFormationController {
	
	@Autowired
	private CandidatFormationService candidatFormationService;

	@PostMapping("/save")
	public CandidatFormation save(@RequestBody CandidatFormation candidatFormation) {
		return candidatFormationService.save(candidatFormation);
	}

	@PutMapping("/update")
	public CandidatFormation update(@RequestBody CandidatFormation candidatFormation) {
		return candidatFormationService.update(candidatFormation);
	}

	@GetMapping("/get/{id}")
	public CandidatFormation getById(@PathVariable("id")Long id) {
		return candidatFormationService.getById(id);
	}

	@GetMapping("/get")
	public List<CandidatFormation> getAll(){
		return candidatFormationService.getAll();
	}

	@GetMapping("/byCandidat/{id}")
	public List<CandidatFormation> getByCandidat(@PathVariable("id") Long id){
		return candidatFormationService.getByCandidat(id);
	}

	@GetMapping("/byFormation/{id}")
	public List<CandidatFormation> getByFormation(@PathVariable Long id){
		return candidatFormationService.getByFormation(id);
	}

	@GetMapping("/byCandidatFormation/{candidat}/{formation}")
	public List<CandidatFormation> getByCandidatAndFormation(@PathVariable("candidat")Long candidat, @PathVariable("formation")Long formation){
		return candidatFormationService.getByCandidatAndFormation(candidat, formation);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id")Long id) {
		candidatFormationService.delete(id);
	}
}
