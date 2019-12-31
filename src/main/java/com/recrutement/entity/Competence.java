package com.recrutement.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class Competence {
	@CreationTimestamp
	private Date dateAjout;
	@UpdateTimestamp
	private Date dateModif;
}
