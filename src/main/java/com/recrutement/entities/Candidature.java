package com.recrutement.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.recrutement.entity.types.Etat;

@Entity
@Table(name="candidature")
public class Candidature implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Etat etat;
	
	@ManyToOne
	private Offre offre;
	
	@ManyToOne
	private Candidat candidat;

	public Candidature() {
		super();
	}

	

	public Candidature(Long id, Etat etat, Offre offre, Candidat candidat) {
		super();
		this.id = id;
		this.etat = etat;
		this.offre = offre;
		this.candidat = candidat;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}



	public Etat getEtat() {
		return etat;
	}



	public void setEtat(Etat etat) {
		this.etat = etat;
	}



	@Override
	public String toString() {
		return "Candidature [id=" + id + ", etat=" + etat + ", offre=" + offre + ", candidat=" + candidat + "]";
	}

	

}
