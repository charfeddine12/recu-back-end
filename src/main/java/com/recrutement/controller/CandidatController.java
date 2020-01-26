package com.recrutement.controller;

import java.io.File;
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


	@Autowired
	private HttpServletRequest request;

	public CandidatController(CandidatService candidatService, EmployeurService employeurService, HttpServletRequest request) {
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
			candidat.setRole(Role.CANDIDAT.name());
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
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			@RequestParam(value = "mail", required = true) String email,
			@RequestParam(value = "id", required = false) String id) {
		log.info("getOriginalFilename = {}", file.getOriginalFilename());
		log.info("mail = {}", email);

		if (!file.isEmpty()) {
			log.info("getOriginalFilename = {}", file.getOriginalFilename());

			try {
				String uploadsDir = "image";
				String realPathtoUploads = request.getServletContext().getRealPath(uploadsDir);
				realPathtoUploads += "\\" +"Candidat";
				if (!new File(realPathtoUploads).exists()) {
					new File(realPathtoUploads).mkdir();
				}
				String folder = realPathtoUploads + "\\" + email;

				log.info("realPathtoUploads = {}", realPathtoUploads);
				if (!new File(folder).exists()) {
					log.info("folder = {}", folder);

					new File(folder).mkdir();

				}
				String orgName = file.getOriginalFilename();
				String filePath = folder + "\\" + orgName;
				log.info("filePath = {}", filePath);

				File dest = new File(filePath);
				file.transferTo(dest);
				log.info("dest.getAbsolutePath( = {}", dest.getAbsolutePath());
				Candidat candidat =candidatService.getOne(Long.valueOf(id));
				candidat.setPhoto(dest.getAbsolutePath());
				candidatService.save(candidat);
				return dest.getAbsolutePath();
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
	


}
