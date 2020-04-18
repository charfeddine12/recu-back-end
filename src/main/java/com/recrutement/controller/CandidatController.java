package com.recrutement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.recrutement.entity.Candidat;
import com.recrutement.entity.Role;
import com.recrutement.services.CandidatService;
import com.recrutement.services.EmployeurService;

@RestController
@RequestMapping("/api/candidat")
@CrossOrigin(origins = "*")
public class CandidatController {

	private final Logger log = LoggerFactory.getLogger(CandidatController.class);

	@Autowired
	CandidatService candidatService;

	@Autowired
	EmployeurService employeurService;

	@SuppressWarnings("unused")
	@Autowired
	private HttpServletRequest request;

	public CandidatController(CandidatService candidatService, EmployeurService employeurService,
			HttpServletRequest request) {
		super();
		this.candidatService = candidatService;
		this.employeurService = employeurService;
		this.request = request;

	}

	@GetMapping("/get")
	public List<Candidat> getAllCandidats() {
		final List<Candidat> listCandidat = candidatService.getAll();
		return listCandidat;
	}

	@GetMapping("/get/{id}")
	public Candidat getCandidat(@PathVariable Long id) {
		log.info("REST request to get Candidat : {}", id);
		Candidat candidat = null;
		if (id != null)
			candidat = candidatService.getOne(id);
		return candidat;
	}
	@GetMapping("/getByLogin/{login}")
	public Candidat getByLoginCandidat(@PathVariable String login) {
		log.info("REST request to get Candidat : {}", login);
		Candidat candidat = null;
		if (login != null)
			candidat = candidatService.findCandidatByEmail(login);
		return candidat;
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteCandidat(@PathVariable Long id) {
		log.info("REST request to delete candidat: {}", id);
		boolean result = false;
		if (id != null)
			result = candidatService.delete(id);
		return result;
	}

	@PostMapping("/save")
	public Candidat createCandidat(@RequestBody Candidat candidat) throws IOException {

		if (candidat.getId() != null) {
			log.info("A new candidat cannot already have an ID", "userManagement", "idexists");
		} else if (!employeurService.findOneByEmail(candidat.getEmail().toLowerCase())
				|| !candidatService.findOneByEmail(candidat.getEmail().toLowerCase())) {
			log.info("A new candidat cannot already have an Email : {}", candidat.getEmail());
		} else {
			candidat.setRole(Role.CANDIDAT);
			Candidat newCandidat = candidatService.save(candidat);
			return newCandidat;
		}
		return null;
	}

	@PutMapping("/update")
	public Candidat updateCandidat(@RequestBody Candidat candidat) {
		log.info("REST request to update candidat : {}", candidat);
		boolean result = candidatService.findOneByEmail(candidat.getEmail());
		if (result) {
			log.info("A new candidat cannot already have an Email : {}", candidat.getEmail());
			return null;
		} else {
			Candidat updatedCandidat = candidatService.save(candidat);

			return updatedCandidat;
		}

	}

	@PostMapping(value = "/uploadfile")
	public boolean handleFileUpload(@RequestParam("file") MultipartFile file,
			@RequestParam(value = "mail", required = true) String email,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "type", required = false) String type) {
		log.info("A new save file :{}, with email :{} ,and id :{} : {}",file.getOriginalFilename(),email,id);

		if (!file.isEmpty()) {
			try {
				Candidat candidat = candidatService.getOne(Long.valueOf(id));
				if(type.equals("PHOTO")) {
					candidat.setPhoto(file.getBytes());
					candidatService.save(candidat);	
				}else if (type.equals("CV")) {
					candidat.setPiece_jointe(file.getBytes());
					candidatService.save(candidat);	
				}

				log.info("A canddd: {}",candidat);

				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	

}
