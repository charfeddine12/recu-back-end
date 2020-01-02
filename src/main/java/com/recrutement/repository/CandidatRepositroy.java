package com.recrutement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entity.Candidat;

@Repository
public interface CandidatRepositroy extends JpaRepository<Candidat, Long> {

}
