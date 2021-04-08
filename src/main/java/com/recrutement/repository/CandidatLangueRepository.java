package com.recrutement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entities.Candidat;
import com.recrutement.entities.CandidatLangues;
import com.recrutement.entities.Langue;
@Repository
public interface CandidatLangueRepository extends JpaRepository<CandidatLangues, Long>{
	
	public List<CandidatLangues> getByCandidat(Candidat candidat);
	
	public List<CandidatLangues> getByLangue(Langue langue);
	
	public List<CandidatLangues> getByCandidatAndLangue(Candidat candidat, Langue langue);

}
