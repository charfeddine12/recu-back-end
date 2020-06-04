package com.recrutement.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="candidat_experience")
public class CandidatExperience implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="candidat_id")
	private Candidat candidat;
	
	@ManyToOne
	@JoinColumn(name="experience_id")
	private Experience experience;
	
	@Column
	private int duree;

	public CandidatExperience() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CandidatExperience(Long id, Candidat candidat, Experience experience, int duree) {
		super();
		this.id = id;
		this.candidat = candidat;
		this.experience = experience;
		this.duree = duree;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	

}
