package com.iset.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Articles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String titre;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = true)
    private String imageURL;
    
    @ManyToOne
    @JoinColumn(name = "auteur_id")
    private User auteur; // Nutritioniste who wrote the article
    
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<Commentaire> commentaires = new HashSet<>();
    
}
