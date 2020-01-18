package com.recrutement.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
//there are problem if we don't have this annotation  for the lazy loading via the hibernate proxy object. Got around it by annotating the class having lazy loaded private properties with
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Candidat extends Utilisateur {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String photo;
	@Column
	private Date dateNaissance;
	@Column
	private String diplome;
	@Column
	private String piece_jointe;
	@Column
	private String tel;
	@Column
	private String titre;
	@Column
	private String adresse;
	@Column
	private String nationalite;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonBackReference(value = "formations")
	List<Formation> formations;

	@OneToMany( fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	List<Competence> competences;

	@OneToMany
	List<Experience> experiences;

	@OneToMany
	List<Langue> langues;

	@ManyToMany
	@JoinTable(name = "Candidature", joinColumns = @JoinColumn(name = "candidat_id"), inverseJoinColumns = @JoinColumn(name = "offre_id"))
	List<Offre> offres;

	public Candidat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidat(String nom, String prenom, String photo, Date dateNaissance, String diplome, String piece_jointe,
			String tel, String titre, String adresse, String nationalite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.dateNaissance = dateNaissance;
		this.diplome = diplome;
		this.piece_jointe = piece_jointe;
		this.tel = tel;
		this.titre = titre;
		this.adresse = adresse;
		this.nationalite = nationalite;
	}

	public Candidat(String nom, String prenom, String photo, Date dateNaissance, String diplome, String piece_jointe,
			String tel, String titre, String adresse, String nationalite, List<Formation> formations,
			List<Competence> competences, List<Experience> experiences, List<Langue> langues) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.dateNaissance = dateNaissance;
		this.diplome = diplome;
		this.piece_jointe = piece_jointe;
		this.tel = tel;
		this.titre = titre;
		this.adresse = adresse;
		this.nationalite = nationalite;
		this.formations = formations;
		this.competences = competences;
		this.experiences = experiences;
		this.langues = langues;
	}

	public Candidat(String nom, String prenom, String photo, Date dateNaissance, String diplome, String piece_jointe,
			String tel, String titre, String adresse, String nationalite, List<Formation> formations,
			List<Competence> competences, List<Experience> experiences, List<Langue> langues, List<Offre> offres) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.dateNaissance = dateNaissance;
		this.diplome = diplome;
		this.piece_jointe = piece_jointe;
		this.tel = tel;
		this.titre = titre;
		this.adresse = adresse;
		this.nationalite = nationalite;
		this.formations = formations;
		this.competences = competences;
		this.experiences = experiences;
		this.langues = langues;
		this.offres = offres;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public String getPiece_jointe() {
		return piece_jointe;
	}

	public void setPiece_jointe(String piece_jointe) {
		this.piece_jointe = piece_jointe;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Langue> getLangues() {
		return langues;
	}

	public void setLangues(List<Langue> langues) {
		this.langues = langues;
	}

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	@Override
	public String toString() {
		return "Candidat [nom=" + nom + ", prenom=" + prenom + ", photo=" + photo + ", dateNaissance=" + dateNaissance
				+ ", diplome=" + diplome + ", piece_jointe=" + piece_jointe + ", tel=" + tel + ", titre=" + titre
				+ ", adresse=" + adresse + ", nationalite=" + nationalite + ", formations=" + formations
				+ ", competences=" + competences + ", experiences=" + experiences + ", langues=" + langues + ", offres="
				+ offres + "]";
	}

}
