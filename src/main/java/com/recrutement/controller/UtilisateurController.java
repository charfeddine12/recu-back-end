package com.recrutement.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recrutement.entity.Utilisateur;
import com.recrutement.services.UtilisateurService;
import com.recrutement.utilties.CodeResponse;

@RestController
@RequestMapping("/api/utilisateur")
@CrossOrigin(origins = "http://localhost:4200")

public class UtilisateurController {

	private final Logger log = LoggerFactory.getLogger(UtilisateurController.class);

	@Autowired
	private UtilisateurService utilisateurService;

	private String code;

	final String username = "platrec.pfe@gmail.com";
	final String password = "platrec123456789";

	public UtilisateurController(UtilisateurService utilisateurService) {
		super();
		this.utilisateurService = utilisateurService;
	}

	@GetMapping("/get")
	public List<Utilisateur> getAllUtilisateurs() {
		final List<Utilisateur> listUtilisateur = utilisateurService.getAll();
		return listUtilisateur;
	}

	@GetMapping("/get/{id}")
	public Utilisateur getUtilisateur(@PathVariable Long id) {
		log.info("REST request to get Utilisateur : {}", id);
		Utilisateur utilisateur = null;
		if (id != null)
			utilisateur = utilisateurService.getOne(id);
		return utilisateur;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteUtilisateur(@PathVariable Long id) {
		log.info("REST request to delete Utilisateur: {}", id);
		boolean result = false;
		if (id != null)
			result = utilisateurService.delete(id);
		return result;
	}

	@PostMapping("/save")
	public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) throws URISyntaxException {
		log.info("REST request to save utilisateur : {}", utilisateur);

		if (utilisateur.getId() != null) {
			log.info("A new Utilisateur cannot already have an ID idexists");
		} else {
			Utilisateur newUtilisateur = utilisateurService.save(utilisateur);
			return newUtilisateur;
		}
		return null;
	}

	@PutMapping("/update")
	public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur) {
		log.info("REST request to update Utilisateur : {}", utilisateur);
		if (utilisateur.getId() != null)
			if (utilisateurService.getOne(utilisateur.getId()) != null) {
				Utilisateur updatedUtilisateur = utilisateurService.save(utilisateur);
				return updatedUtilisateur;
			}
		return null;

	}

	@GetMapping(value = "/authentication/{login}/{pwd}")
	public Utilisateur authentication(@PathVariable("login") String login, @PathVariable("pwd") String pwd) {
		log.info("REST request to authentificate Utilisateur with login : {} , and password :{}", login, pwd);
		return utilisateurService.authentication(login, pwd);
	}
	
	@GetMapping(value = "/findByLogin/{login}")
	public Utilisateur findByLogin(@PathVariable("login") String login) {
		log.info("REST request to fing Utilisateur by login : {}", login);
		Utilisateur utitlisateur = utilisateurService.findUserByEmail(login.toLowerCase());
		log.info("result request to fing Utilisateur by login : {}", utitlisateur);
		return utitlisateur;
		 
	}
	
	@GetMapping(value = "/sendMail/{login}")
	public Utilisateur sendMail(@PathVariable("login") String login) {
		log.info("REST request to fing Utilisateur by login : {}", login);
		Utilisateur utitlisateur = utilisateurService.findUserByEmail(login.toLowerCase());
		log.info("result request to fing Utilisateur by login : {}", utitlisateur);
		if (utitlisateur != null) {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(utitlisateur.getEmail()));
				message.setSubject("Recuperation de mot de passe");
				code = createCode();
				message.setText("Code: " + code);
				Transport.send(message);
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
		return utitlisateur;
		 
	}
	
	private String createCode() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	@GetMapping(value="/getcode", produces = MediaType.APPLICATION_JSON_VALUE)
	public CodeResponse getCode() {
		return new CodeResponse(code);
	}
}
