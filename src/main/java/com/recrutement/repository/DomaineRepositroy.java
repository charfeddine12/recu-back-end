package com.recrutement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entities.Domaine;

@Repository
public interface DomaineRepositroy extends JpaRepository<Domaine, Long> {

}
