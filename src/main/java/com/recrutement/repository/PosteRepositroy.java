package com.recrutement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entity.Poste;
@Repository
public interface PosteRepositroy extends JpaRepository<Poste, Long> {

}
