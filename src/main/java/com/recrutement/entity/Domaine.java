package com.recrutement.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class Domaine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String intitule;
	@CreationTimestamp
	private Date dateAjout;
	@UpdateTimestamp
	private Date dateModif;
	
	@OneToMany(mappedBy = "domaine")
	@JsonBackReference
	List<Offre> offres;
	public Domaine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Domaine(Long id, String intitule, Date dateAjout, Date dateModif) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.dateAjout = dateAjout;
		this.dateModif = dateModif;
	}
	
	
	public Domaine(Long id, String intitule, Date dateAjout, Date dateModif, List<Offre> offres) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.dateAjout = dateAjout;
		this.dateModif = dateModif;
		this.offres = offres;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
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
	
	
	public List<Offre> getOffres() {
		return offres;
	}
	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}
	@Override
	public String toString() {
		return "Domaine [id=" + id + ", intitule=" + intitule + ", dateAjout=" + dateAjout + ", dateModif=" + dateModif
				+ ", offres=" + offres + "]";
	}

}
