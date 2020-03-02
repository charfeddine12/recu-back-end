package com.recrutement.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Offre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 12345L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	private String niveauEtude;
	@Column
	private String fonction;
	@Column
	private String horaire;
	@Column
	private String salaire;
	@Column(name = "niveauExperience")
	private String niveauExperience;
	@CreationTimestamp
	@Column
	private Date dateAjout;
	@UpdateTimestamp
	@Column
	private Date dateModif;

	@ManyToOne
	private Domaine domaine;

	@ManyToMany
	@JoinTable(name = "offre_langues", joinColumns = @JoinColumn(name = "offre_id"), inverseJoinColumns = @JoinColumn(name = "langues_id"))
	private List<Langue> langues;

	@ManyToMany
	@JoinTable(name = "offre_competences", joinColumns = @JoinColumn(name = "offre_id"), inverseJoinColumns = @JoinColumn(name = "competences_id"))
	private List<Competence> competences;
	
	@OneToOne
	private Poste poste;
	
	@ManyToOne
	private Employeur employeur;
	
	public Offre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offre(Long id, String niveauEtude, String fonction, String horaire, String salaire, String niveauExperience,
			Date dateAjout, Date dateModif) {
		super();
		this.id = id;
		this.niveauEtude = niveauEtude;
		this.fonction = fonction;
		this.horaire = horaire;
		this.salaire = salaire;
		this.niveauExperience = niveauExperience;
		this.dateAjout = dateAjout;
		this.dateModif = dateModif;
	}

	public Offre(Long id, String niveauEtude, String fonction, String horaire, String salaire, String niveauExperience,
			Date dateAjout, Date dateModif, Domaine domaine, List<Langue> langues, List<Competence> competences,
			Poste poste, Employeur employeur) {
		super();
		this.id = id;
		this.niveauEtude = niveauEtude;
		this.fonction = fonction;
		this.horaire = horaire;
		this.salaire = salaire;
		this.niveauExperience = niveauExperience;
		this.dateAjout = dateAjout;
		this.dateModif = dateModif;
		this.domaine = domaine;
		this.langues = langues;
		this.competences = competences;
		this.poste = poste;
		this.employeur = employeur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getHoraire() {
		return horaire;
	}

	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}

	public String getSalaire() {
		return salaire;
	}

	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}

	public String getNiveauExperience() {
		return niveauExperience;
	}

	public void setNiveauExperience(String niveauExperience) {
		this.niveauExperience = niveauExperience;
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

	public List<Langue> getLangues() {
		return langues;
	}

	public void setLangues(List<Langue> langues) {
		this.langues = langues;
	}

	
	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	
	public Employeur getEmployeur() {
		return employeur;
	}

	public void setEmployeur(Employeur employeur) {
		this.employeur = employeur;
	}

	
	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}


	@Override
	public String toString() {
		return "Offre [id=" + id + ", niveauEtude=" + niveauEtude + ", fonction=" + fonction + ", horaire=" + horaire
				+ ", salaire=" + salaire + ", niveauExperience=" + niveauExperience + ", dateAjout=" + dateAjout
				+ ", dateModif=" + dateModif +"]";
	}



}
