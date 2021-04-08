package com.recrutement.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="candidat_langues")
public class CandidatLangues implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="langue_id")
	private Langue langue;
	
	@ManyToOne
	@JoinColumn(name="candidat_id")
	private Candidat candidat;
	
	private int niveau;

	public CandidatLangues() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CandidatLangues(Long id, Langue langue, Candidat candidat, int niveau) {
		super();
		this.id = id;
		this.langue = langue;
		this.candidat = candidat;
		this.niveau = niveau;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Langue getLangue() {
		return langue;
	}

	public void setLangue(Langue langue) {
		this.langue = langue;
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}



	public int getNiveau() {
		return niveau;
	}



	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
	

}
