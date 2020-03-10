package com.recrutement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recrutement.entity.Employeur;
import com.recrutement.entity.Offre;

@Repository
public interface EmployeurRepositroy extends JpaRepository<Employeur, Long> {

	@Query("select employeur from Employeur employeur where employeur.email=:email")
	Employeur findByEmail(@Param("email") String email);
	@Query("select employeur from Employeur employeur where employeur.email = :email and employeur.password = :password")
	Employeur authentication(@Param("email")String email, @Param("password")String password);
	


}
