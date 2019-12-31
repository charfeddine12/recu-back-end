package com.recrutement.entity;

import java.io.File;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Candidat extends Utilisateur {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private File photo;
	private Date dateNaissance;
	private String diplome;
	private File piece_jointe;
	private String tel;
	private String titre;
	private String adresse;
	private String nationalite;
	
	public Candidat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidat(Long id, String nom, String prenom, File photo, Date dateNaissance, String diplome,
			File piece_jointe, String tel, String titre, String adresse, String nationalite) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.dateNaissance = dateNaissance;
		this.diplome = diplome;
		this.piece_jointe = piece_jointe;
		this.tel = tel;
		this.titre = titre;
		this.adresse = adresse;
		this.nationalite = nationalite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
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

	public File getPiece_jointe() {
		return piece_jointe;
	}

	public void setPiece_jointe(File piece_jointe) {
		this.piece_jointe = piece_jointe;
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

	@Override
	public String toString() {
		return "Candidat [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", photo=" + photo + ", dateNaissance="
				+ dateNaissance + ", diplome=" + diplome + ", piece_jointe=" + piece_jointe + ", tel=" + tel
				+ ", titre=" + titre + ", adresse=" + adresse + ", nationalite=" + nationalite + "]";
	}
	
	
}
