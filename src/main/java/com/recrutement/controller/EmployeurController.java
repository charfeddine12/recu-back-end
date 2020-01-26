package com.recrutement.controller;

import java.io.File;
import java.net.URISyntaxException;
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
import com.recrutement.entity.Employeur;
import com.recrutement.services.CandidatService;
import com.recrutement.services.EmployeurService;

import net.bytebuddy.implementation.bytecode.Throw;

@RestController
@RequestMapping("/api/employeur")
@CrossOrigin(origins = "*")
public class EmployeurController {
	private final Logger log = LoggerFactory.getLogger(EmployeurController.class);

	@Autowired
	EmployeurService employeurService;

	@Autowired
	CandidatService candidatService;

	@Autowired
	private HttpServletRequest request;
	
	public EmployeurController(EmployeurService employeurService, CandidatService candidatService,HttpServletRequest request) {
		super();
		this.employeurService = employeurService;
		this.candidatService = candidatService;
		this.request = request;
	}

	@GetMapping("/get")
	public List<Employeur> getAllemployeurs() {
		final List<Employeur> listemployeur = employeurService.getAll();
		return listemployeur;
	}

	@GetMapping("/get/{id}")
	public Employeur getEmployeur(@PathVariable Long id) {
		log.info("REST request to get Employeur : {}", id);
		Employeur employeur = null;
		if (id != null)
			employeur = employeurService.getOne(id);
		return employeur;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteEmployeur(@PathVariable Long id) {
		log.info("REST request to delete Employeur: {}", id);
		boolean result = false;
		if (id != null)
			result = employeurService.delete(id);
		return result;
	}

	@PostMapping("/save")
	public Employeur createEmployeur(@RequestBody Employeur employeur) throws Exception {
		log.info("REST request to save Employeur : {}", employeur);
		log.info("A nddddddd  : {}", employeurService.findOneByEmail(employeur.getEmail().toLowerCase()));
		log.info("A ndddcxcxcxc  : {} ", candidatService.findOneByEmail(employeur.getEmail().toLowerCase()));

		if (employeur.getId() != null) {
			log.info("A new employeur cannot already have an ID idexists");
		} else if (!employeurService.findOneByEmail(employeur.getEmail().toLowerCase())
				|| !candidatService.findOneByEmail(employeur.getEmail().toLowerCase())) {
			log.info("A new Employeur cannot already have an Email : {}", employeur.getEmail());

			throw new Exception("A new Employeur cannot already have an Email");
		} else {
			Employeur newEmployeur = employeurService.save(employeur);
			return newEmployeur;
		}
		return null;
	}

	@PutMapping("/update")
	public Employeur updateEmployeur(@RequestBody Employeur employeur) {
		log.info("REST request to update Employeur : {}", employeur);
		if (employeur.getId() != null)
			if (employeurService.getOne(employeur.getId()) != null) {

				Employeur updatedEmployeur = employeurService.save(employeur);
				return updatedEmployeur;
			}
		return null;

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
				realPathtoUploads += "\\" +"Employeur";
				if (!new File(realPathtoUploads).exists()) {
					new File(realPathtoUploads).mkdir();
				}
				String folder = realPathtoUploads +"\\" + email;

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
