package com.recrutement.entities;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
//there are problem if we don't have this annotation  for the lazy loading via the hibernate proxy object. Got around it by annotating the class having lazy loaded private properties with
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Cacheable(false)
public class Candidat extends Utilisateur {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	private String nom;
	
	@Column
	private String prenom;

	@Column
	private Date dateNaissance;
	
	@Column
	private String diplome;
	
	@Column
	private String tel;
	
	@Column
	private String titre;
	
	@Column
	private String adresse;
	
	@Column
	private String nationalite;

	@Column(length = 1000000)
	private  String photo;
	
	@Column(length = 1000000)
	private String pieceJointe;

	public Candidat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidat(String nom, String prenom, String photo, Date dateNaissance, String diplome, String piecejointe,
			String tel, String titre, String adresse, String nationalite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.diplome = diplome;
		this.tel = tel;
		this.titre = titre;
		this.adresse = adresse;
		this.nationalite = nationalite;
		this.photo = photo;
		this.pieceJointe = piecejointe;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPieceJointe() {
		return pieceJointe;
	}

	public void setPieceJointe(String pieceJointe) {
		this.pieceJointe = pieceJointe;
	}


}
