package com.recrutement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entity.Langue;

@Repository
public interface LangueRepositroy extends JpaRepository<Langue, Long> {

}
