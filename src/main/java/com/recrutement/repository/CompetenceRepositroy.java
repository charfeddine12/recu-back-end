package com.recrutement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entity.Competence;

@Repository
public interface CompetenceRepositroy extends JpaRepository<Competence, Long> {

}
