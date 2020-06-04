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
@Table(name="candidat_formations")
public class CandidatFormation implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="formation_id")
	private Formation formation;
	
	@ManyToOne
	@JoinColumn(name="candidat_id")
	private Candidat candidat;

	public CandidatFormation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CandidatFormation(Long id, Formation formation, Candidat candidat) {
		super();
		this.id = id;
		this.formation = formation;
		this.candidat = candidat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}
	
	
}
