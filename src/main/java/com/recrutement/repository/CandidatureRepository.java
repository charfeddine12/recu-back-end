package com.recrutement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entities.Candidat;
import com.recrutement.entities.Candidature;
import com.recrutement.entities.Offre;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Long> {
	
	public List<Candidature> getByOffre(Offre offre);
	
	public List<Candidature> getByCandidat(Candidat candidat);

	public void deleteByOffreAndCandidat(Offre offre, Candidat candidat);
	
	

}
