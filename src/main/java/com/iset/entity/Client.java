package com.iset.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
@PrimaryKeyJoinColumn(name = "user_id")
public class Client extends User {
    private Integer age;
    private String sexe;
    private Double poids;
    private Double taille;
}
