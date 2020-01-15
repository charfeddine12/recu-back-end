package com.recrutement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recrutement.entity.Candidat;

@Repository
public interface CandidatRepositroy extends JpaRepository<Candidat, Long> {

	@Query("select candidat from Candidat candidat where candidat.email=:email")
	public Candidat findByEmail(@Param("email") String email);

}
