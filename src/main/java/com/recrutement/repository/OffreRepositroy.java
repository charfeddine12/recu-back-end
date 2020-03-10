package com.recrutement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recrutement.entity.Offre;

@Repository
public interface OffreRepositroy extends JpaRepository<Offre, Long> {

	@Query("select offre from Offre offre where offre.id=:id")
	List<Offre> findOffreByEmployeurId(@Param("id") Long id);

}
