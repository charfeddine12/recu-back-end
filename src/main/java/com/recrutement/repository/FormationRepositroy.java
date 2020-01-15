package com.recrutement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entity.Formation;

@Repository
public interface FormationRepositroy extends JpaRepository<Formation, Long> {

}
