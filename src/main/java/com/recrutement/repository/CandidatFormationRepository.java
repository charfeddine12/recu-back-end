package com.recrutement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entities.Candidat;
import com.recrutement.entities.CandidatFormation;
import com.recrutement.entities.Formation;
@Repository
public interface CandidatFormationRepository extends JpaRepository<CandidatFormation, Long> {
	
	public List<CandidatFormation> getByCandidat(Candidat candidat);
	
	public List<CandidatFormation> getByFormation(Formation formation);
	
	public List<CandidatFormation> getByCandidatAndFormation(Candidat candidat, Formation formation);

}
