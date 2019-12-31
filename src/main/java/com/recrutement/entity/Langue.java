package com.recrutement.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class Langue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	private String libelle;
	private String niveau;
	@CreationTimestamp
	private Date dateAjout;
	@UpdateTimestamp
	private Date dateModif;
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
