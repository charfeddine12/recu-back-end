package com.recrutement.services;

import java.util.List;
import java.util.Optional;

import com.recrutement.entities.Offre;
import com.recrutement.entities.OffreLangue;

public interface OffreLangueService {
	
	public OffreLangue save(OffreLangue offreLangue);
	
	public OffreLangue update(OffreLangue offreLangue);
	
	public List<OffreLangue> getAll();
	
	public void delete(Long id);
	
	public Optional<OffreLangue> getById(Long id);
	
	public List<OffreLangue> getByOffre(Long id);
	
	public List<OffreLangue> getByLangue(Long id);

	public void deleteByOffre(Offre offre); 	

}
