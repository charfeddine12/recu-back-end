package com.recrutement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entity.Experience;

@Repository
public interface ExperienceRepositroy  extends JpaRepository<Experience, Long> {

}
