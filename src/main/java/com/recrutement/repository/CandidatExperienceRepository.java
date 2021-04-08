package com.recrutement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entities.Candidat;
import com.recrutement.entities.CandidatExperience;
import com.recrutement.entities.Experience;
@Repository
public interface CandidatExperienceRepository extends JpaRepository<CandidatExperience, Long>{

	public List<CandidatExperience> getByCandidat(Candidat candidat);
	
	public List<CandidatExperience> getByExperience(Experience experience);
	
	public List<CandidatExperience> getByCandidatAndExperience(Candidat candidat, Experience experience);
}
