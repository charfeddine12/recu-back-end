package com.recrutement.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Offre implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@Column
	private String niveauExperience;
	@CreationTimestamp
	@Column
	private Date dateAjout;
	@UpdateTimestamp
	@Column
	private Date dateModif;
	
	@ManyToOne
	@JsonManagedReference
	private Domaine domaine;
	
	@OneToMany
	@JsonBackReference
	private List<Poste> postes;
	
	@OneToMany
	@JsonBackReference
	private List<Langue> langues;
	
	@ManyToMany(mappedBy = "offres")
	List<Candidat> candidats;

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
			Date dateAjout, Date dateModif, Domaine domaine, List<Poste> postes,List<Langue> langues) {
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
		this.postes = postes;
		this.langues = langues;
	}
	
	
	public Offre(Long id, String niveauEtude, String fonction, String horaire, String salaire, String niveauExperience,
			Date dateAjout, Date dateModif, Domaine domaine, List<Poste> postes, List<Langue> langues,
			List<Candidat> candidats) {
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
		this.postes = postes;
		this.langues = langues;
		this.candidats = candidats;
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
	public List<Poste> getPoste() {
		return postes;
	}
	public void setPoste(List<Poste> poste) {
		this.postes = poste;
	}
	public List<Poste> getPostes() {
		return postes;
	}
	public void setPostes(List<Poste> postes) {
		this.postes = postes;
	}
	public List<Langue> getLangues() {
		return langues;
	}
	public void setLangues(List<Langue> langues) {
		this.langues = langues;
	}
	public List<Candidat> getCandidats() {
		return candidats;
	}
	public void setCandidats(List<Candidat> candidats) {
		this.candidats = candidats;
	}
	@Override
	public String toString() {
		return "Offre [id=" + id + ", niveauEtude=" + niveauEtude + ", fonction=" + fonction + ", horaire=" + horaire
				+ ", salaire=" + salaire + ", niveauExperience=" + niveauExperience + ", dateAjout=" + dateAjout
				+ ", dateModif=" + dateModif + ", domaine=" + domaine + ", postes=" + postes + ", langues=" + langues
				+ ", candidats=" + candidats + "]";
	}

}
