package com.recrutement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entity.Offre;

@Repository
public interface OffreRepositroy extends JpaRepository<Offre, Long> {

}
