package com.recrutement.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entities.Offre;
import com.recrutement.entities.OffreLangue;
import com.recrutement.repository.OffreLangueRepository;
import com.recrutement.services.OffreLangueService;

@Service
@Transactional
public class OffreLangueServiceImpl implements OffreLangueService{
	
	@Autowired
	private OffreLangueRepository offreLangueRepository;

	@Override
	public OffreLangue save(OffreLangue offreLangue) {
		return offreLangueRepository.save(offreLangue);
	}

	@Override
	public OffreLangue update(OffreLangue offreLangue) {
		return offreLangueRepository.save(offreLangue);
	}

	@Override
	public List<OffreLangue> getAll() {
		return offreLangueRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		offreLangueRepository.deleteById(id);
		
	}

	@Override
	public Optional<OffreLangue> getById(Long id) {
		return offreLangueRepository.findById(id);
	}

	@Override
	public List<OffreLangue> getByOffre(Long id) {
		return offreLangueRepository.getByOffre(id);
	}

	@Override
	public List<OffreLangue> getByLangue(Long id) {
		return offreLangueRepository.getByLangue(id);
	}

	@Override
	public void deleteByOffre(Offre offre) {
		offreLangueRepository.deleteByOffre(offre);
		
	}

}
