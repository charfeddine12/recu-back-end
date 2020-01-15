package com.recrutement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recrutement.entity.Utilisateur;

@Repository
public interface UtilisateurRepositroy extends JpaRepository<Utilisateur, Long> {

	@Query("select utilisateur from Utilisateur utilisateur where utilisateur.email=:email")
	Utilisateur findByEmail(@Param("email") String email);

}
