package com.recrutement.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Langue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	private String code;
	@Column
	private String libelle;
	@Column
	private String niveau;
	@CreationTimestamp
	@Column
	private Date dateAjout;
	@UpdateTimestamp
	@Column
	private Date dateModif;

//	@JsonManagedReference
//	private Candidat candidat;
//	@JsonManagedReference
//	private Offre offre;
	
	public Langue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Langue(Long id, String code, String libelle, String niveau, Date dateAjout, Date dateModif) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.niveau = niveau;
		this.dateAjout = dateAjout;
		this.dateModif = dateModif;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
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
		return "Langue [id=" + id + ", code=" + code + ", libelle=" + libelle + ", niveau=" + niveau + ", dateAjout="
				+ dateAjout + ", dateModif=" + dateModif + "]";
	}
	
	
}
