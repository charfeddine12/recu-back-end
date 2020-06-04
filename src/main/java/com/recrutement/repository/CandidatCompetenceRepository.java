package com.recrutement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entities.Candidat;
import com.recrutement.entities.CandidatCompetences;
import com.recrutement.entities.Competence;
@Repository
public interface CandidatCompetenceRepository extends JpaRepository<CandidatCompetences, Long>{

	public List<CandidatCompetences> getByCandidat(Candidat candidat);
	
	public List<CandidatCompetences> getByCompetence(Competence competence);
	
	public List<CandidatCompetences> getByCandidatAndCompetence(Candidat candidat, Competence competence);
}
