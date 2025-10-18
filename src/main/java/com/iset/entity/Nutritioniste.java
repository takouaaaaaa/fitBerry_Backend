package com.iset.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "nutritionistes")
@PrimaryKeyJoinColumn(name = "user_id")
public class Nutritioniste extends User {
    
	@Column(nullable = false)
    private String nom;
	
	@Column(nullable = false)
    private String prenom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}
