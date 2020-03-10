package com.recrutement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

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
    @Lob
	@Column
	private byte[] photo;
	@Column
	private String pays;

	public Employeur() {
		super();
	}

	public Employeur(Long id, String nom, String presentation, String site, String adresse, String taille, String type,
			String fondation, byte[] photo, String pays) {
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "Employeur [id=" + id + ", nom=" + nom + ", presentation=" + presentation + ", site=" + site
				+ ", adresse=" + adresse + ", taille=" + taille + ", type=" + type + ", fondation=" + fondation
				+ ", photo=" + photo + ", pays=" + pays + "]";
	}

}
