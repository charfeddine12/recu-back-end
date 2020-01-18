package com.recrutement.entity;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Employeur extends Utilisateur {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	private String nom;
	@Column
	private String presentation;
	@Column
	private String site;
	@Column
	private String adresse;
	@Column
	private String taille;
	@Column
	private String type;
	@Column
	private String fondation;
	@Column
	private File photo;
	@Column
	private String pays;
	@OneToMany
	@JsonBackReference
	List<Offre> offres;

	public Employeur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employeur(Long id, Email email, Role role, Date dateAjout, Date dateModif) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employeur(Long id, String nom, String presentation, String site, String adresse, String taille, String type,
			String fondation, File photo, String pays) {
		super();
		this.id = id;
		this.nom = nom;
		this.presentation = presentation;
		this.site = site;
		this.adresse = adresse;
		this.taille = taille;
		this.type = type;
		this.fondation = fondation;
		this.photo = photo;
		this.pays = pays;
	}

	public Employeur(Long id, String nom, String presentation, String site, String adresse, String taille, String type,
			String fondation, File photo, String pays, List<Offre> offres) {
		super();
		this.id = id;
		this.nom = nom;
		this.presentation = presentation;
		this.site = site;
		this.adresse = adresse;
		this.taille = taille;
		this.type = type;
		this.fondation = fondation;
		this.photo = photo;
		this.pays = pays;
		this.offres = offres;
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

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFondation() {
		return fondation;
	}

	public void setFondation(String fondation) {
		this.fondation = fondation;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	@Override
	public String toString() {
		return "Employeur [id=" + id + ", nom=" + nom + ", presentation=" + presentation + ", site=" + site
				+ ", adresse=" + adresse + ", taille=" + taille + ", type=" + type + ", fondation=" + fondation
				+ ", photo=" + photo + ", pays=" + pays + ", offres=" + offres + "]";
	}

}
