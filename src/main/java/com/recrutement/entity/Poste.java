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

@Entity
@Table
public class Poste implements Serializable{

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
	private String description;
	
	@CreationTimestamp
	@Column
	private Date dateAjout;
	@UpdateTimestamp
	@Column
	private Date dateModif;

	public Poste() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Poste(Long id, String intitule, String description, Date dateAjout, Date dateModif) {
		super();
		this.id = id;
		this.intitule = intitule;
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
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
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
		return "Poste [id=" + id + ", intitule=" + intitule + ", description=" + description + ", dateAjout="
				+ dateAjout + ", dateModif=" + dateModif + "]";
	}
 

	
}
