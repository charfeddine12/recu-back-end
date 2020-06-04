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

import com.recrutement.entities.CandidatLangues;
import com.recrutement.services.CandidatLangueService;

@RestController
@RequestMapping("/api/candidatLangue")
@CrossOrigin(origins = "*")
public class CandidatLangueController {
	
	@Autowired
	private CandidatLangueService candidatLangueService;
	
	@PostMapping("/save")
	public CandidatLangues save(@RequestBody CandidatLangues candidatLangue) {
		return candidatLangueService.save(candidatLangue);
	}

	@PutMapping("/update")
	public CandidatLangues update(@RequestBody CandidatLangues candidatLangue) {
		return candidatLangueService.update(candidatLangue);
	}

	@GetMapping("/get/{id}")
	public CandidatLangues getById(@PathVariable("id")Long id) {
		return candidatLangueService.getById(id);
	}

	@GetMapping("/get")
	public List<CandidatLangues> getAll(){
		return candidatLangueService.getAll();
	}

	@GetMapping("/byCandidat/{candidat}")
	public List<CandidatLangues> getByCandidat(@PathVariable("candidat")Long id){
		return candidatLangueService.getByCandidat(id);
	}

	@GetMapping("/byLangue/{langue}")
	public List<CandidatLangues> getByLangue(@PathVariable("langue")Long id){
		return candidatLangueService.getByLangue(id);
	}

	@GetMapping("byCandidatLangue/{candidat}/{langue}")
	public List<CandidatLangues> getByCandidatAndLangue(Long candidat, Long langue){
		return candidatLangueService.getByCandidatAndLangue(candidat, langue);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id")Long id) {
		candidatLangueService.delete(id);
	}

}
