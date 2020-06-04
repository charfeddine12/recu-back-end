package com.recrutement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.recrutement.entities.Utilisateur;
import com.recrutement.entity.types.Role;
import com.recrutement.services.UtilisateurService;

@SpringBootApplication
public class StartApplication implements CommandLineRunner{
	
	@Autowired
	private UtilisateurService utilisateurService;

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	} 

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
	
	@Override
	public void run(String... args) throws Exception {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setEmail("platrec.pfe@gmail.com");
		utilisateur.setPassword("admin");
		utilisateur.setRole(Role.ADMIN);
		if (!(utilisateurService.findOneByEmail("platrec.pfe@gmail.com"))) {
			utilisateurService.save(utilisateur);
		}
	}
}
