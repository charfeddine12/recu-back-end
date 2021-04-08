package com.recrutement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recrutement.entities.Candidat;

@Repository
public interface CandidatRepositroy extends JpaRepository<Candidat, Long> {

	@Query("select candidat from Candidat candidat where candidat.email=:email")
	public Candidat findByEmail(@Param("email") String email);
	@Query("select candidat from Candidat candidat where candidat.email = :email and candidat.password = :password")
	Candidat authentication(@Param("email")String email, @Param("password")String password);
	
	@Query("select candidat from Candidat candidat where candidat.id IN (:listCandidatsIds)")
	public List<Candidat> getCandidatsByIds(@Param("listCandidatsIds") List<Long> listCandidatsIds);
	
	

	
}
