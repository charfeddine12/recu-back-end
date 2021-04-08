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

import com.recrutement.entities.OffreLangue;
import com.recrutement.services.OffreLangueService;
import com.recrutement.services.OffreService;

@RestController
@RequestMapping("/api/offreLangue")
@CrossOrigin(origins = "*")
public class OffreLangueController {
	
	@Autowired
	private OffreLangueService offreLangueService;
	
	@Autowired
	private OffreService offreService;
	
	@PostMapping("/save")
	public OffreLangue save(@RequestBody OffreLangue offreLangue) {
		return offreLangueService.save(offreLangue);
	}
	
	@PutMapping("/update")
	public OffreLangue update(@RequestBody OffreLangue offreLangue) {
		return offreLangueService.update(offreLangue);
	}
	
	@GetMapping("/get")
	public List<OffreLangue> getAll() {
		return offreLangueService.getAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id")Long id) {
		offreLangueService.delete(id);
	}
	
	@DeleteMapping("/delete/byOffre/{id}")
	public void deleteByOffre(@PathVariable("id")Long id) {
		offreLangueService.deleteByOffre(offreService.getOne(id));
	}
	
	@GetMapping("/get/{id}")
	public OffreLangue getById(@PathVariable("id")Long id){
		return offreLangueService.getById(id).get();
	}
	
	@GetMapping("/getByOffre/{id}")
	public List<OffreLangue> getByOffre(@PathVariable("id")Long id) {
		return offreLangueService.getByOffre(id);
	}
	
	@GetMapping("/getByLangue/{id}")
	public List<OffreLangue> getByLangue(@PathVariable("id")Long id) {
		return offreLangueService.getByLangue(id);
	}

}
