package com.recrutement.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Cacheable(false)
public class Competence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	private String intitule;
	
	@Column
	@CreationTimestamp
	private Date dateAjout;
	
	@Column
	@UpdateTimestamp
	private Date dateModif;
	
	@ManyToOne
	private Domaine domaine;

	public Competence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Competence(Long id, String intitule, Date dateAjout, Date dateModif, Domaine domaine) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.dateAjout = dateAjout;
		this.dateModif = dateModif;
		this.domaine = domaine;
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

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	@Override
	public String toString() {
		return "Competence [id=" + id + ", intitule=" + intitule + ", dateAjout=" + dateAjout + ", dateModif="
				+ dateModif + ", domaine=" + domaine + "]";
	}

}
