package com.recrutement.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Experience implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	private Date debut;
	@Column
	private Date fin;
	@Column
	private String titre;
	@Column
	private String employeur;
	@Column
	private String lieu;
	@Column
	private String description;
	@CreationTimestamp
	@Column
	private Date dateAjout;
	@UpdateTimestamp
	@Column
	private Date dateModif;
//	@JsonBackReference
//	private Candidat candidat;

	public Experience() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Experience(Long id, Date debut, Date fin, String titre, String employeur, String lieu, String description,
			Date dateAjout, Date dateModif) {
		super();
		this.id = id;
		this.debut = debut;
		this.fin = fin;
		this.titre = titre;
		this.employeur = employeur;
		this.lieu = lieu;
		this.description = description;
		this.dateAjout = dateAjout;
		this.dateModif = dateModif;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getEmployeur() {
		return employeur;
	}

	public void setEmployeur(String employeur) {
		this.employeur = employeur;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Exeperience [id=" + id + ", debut=" + debut + ", fin=" + fin + ", titre=" + titre + ", employeur="
				+ employeur + ", lieu=" + lieu + ", description=" + description + ", dateAjout=" + dateAjout
				+ ", dateModif=" + dateModif + "]";
	}

}
