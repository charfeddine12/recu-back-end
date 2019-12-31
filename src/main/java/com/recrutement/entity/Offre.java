package com.recrutement.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class Offre implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String niveauEtude;
	private String fonction;
	private String horaire;
	private String salaire;
	private String niveauExperience;
	@CreationTimestamp
	private Date dateAjout;
	@UpdateTimestamp
	private Date dateModif;
	public Offre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Offre(Long id, String niveauEtude, String fonction, String horaire, String salaire, String niveauExperience,
			Date dateAjout, Date dateModif) {
		super();
		this.id = id;
		this.niveauEtude = niveauEtude;
		this.fonction = fonction;
		this.horaire = horaire;
		this.salaire = salaire;
		this.niveauExperience = niveauExperience;
		this.dateAjout = dateAjout;
		this.dateModif = dateModif;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNiveauEtude() {
		return niveauEtude;
	}
	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getHoraire() {
		return horaire;
	}
	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}
	public String getSalaire() {
		return salaire;
	}
	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}
	public String getNiveauExperience() {
		return niveauExperience;
	}
	public void setNiveauExperience(String niveauExperience) {
		this.niveauExperience = niveauExperience;
	}
	public Date getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}
	public Date getDateModif() {
		return dateModif;
	}
	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}
	@Override
	public String toString() {
		return "Offre [id=" + id + ", niveauEtude=" + niveauEtude + ", fonction=" + fonction + ", horaire=" + horaire
				+ ", salaire=" + salaire + ", niveauExperience=" + niveauExperience + ", dateAjout=" + dateAjout
				+ ", dateModif=" + dateModif + "]";
	}
	
	
}
