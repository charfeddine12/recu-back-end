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

public class Formation implements Serializable {

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
	private String etablissement;
	@CreationTimestamp
	@Column
	private Date dateAjout;
	@UpdateTimestamp
	@Column
	private Date dateModif;

	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formation(Long id, Date debut, Date fin, String titre, String etablissement, Date dateAjout,
			Date dateModif) {
		super();
		this.id = id;
		this.debut = debut;
		this.fin = fin;
		this.titre = titre;
		this.etablissement = etablissement;
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

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
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
		return "Formation [id=" + id + ", debut=" + debut + ", fin=" + fin + ", titre=" + titre + ", etablissement="
				+ etablissement + ", dateAjout=" + dateAjout + ", dateModif=" + dateModif + "]";
	}

}
