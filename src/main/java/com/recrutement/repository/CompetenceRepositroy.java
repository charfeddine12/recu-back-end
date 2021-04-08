package com.recrutement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recrutement.entities.Competence;

@Repository
public interface CompetenceRepositroy extends JpaRepository<Competence, Long> {

	@Query("select c from Competence c where c.domaine.id= :id")
	List<Competence> getByDomaine(@Param("id") Long id);

}
