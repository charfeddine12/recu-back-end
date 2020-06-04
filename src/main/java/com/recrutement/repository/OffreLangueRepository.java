package com.recrutement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recrutement.entities.Offre;
import com.recrutement.entities.OffreLangue;

@Repository
public interface OffreLangueRepository extends JpaRepository<OffreLangue, Long>{

	@Query("select ol from OffreLangue ol where offre.id= :id")
	public List<OffreLangue> getByOffre(@Param("id")Long id);

	@Query("select ol from OffreLangue ol where langue.id= :id")
	public List<OffreLangue> getByLangue(@Param("id")Long id);

	public void deleteByOffre(Offre offre);
	

}
