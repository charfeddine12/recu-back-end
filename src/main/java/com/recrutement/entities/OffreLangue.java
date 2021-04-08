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
@Table(name="offre_langue")
public class OffreLangue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "offre_id")
	private Offre offre;
	
	@ManyToOne
	@JoinColumn(name="langues_id")
	private Langue langue;
	
	@Column
	private String niveau;

	public OffreLangue() {
		super();
	}

	public OffreLangue(Long id, Offre offre, Langue langue, String niveau) {
		super();
		this.id = id;
		this.offre = offre;
		this.langue = langue;
		this.niveau = niveau;
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

	public Langue getLangue() {
		return langue;
	}

	public void setLangue(Langue langue) {
		this.langue = langue;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return "OffreLangue [id=" + id + ", offre=" + offre + ", langue=" + langue + ", niveau=" + niveau + "]";
	}
	
	
	

}
