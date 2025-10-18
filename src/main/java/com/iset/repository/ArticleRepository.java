package com.iset.repository;

import com.iset.entity.Article;
import com.iset.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	 List<Article> findByAuteur(User auteur);
	    
	    // Trouver tous les articles d'un nutritionniste par son ID
	    List<Article> findByAuteurId(Long auteurId);
	    
	    // Trouver un article par ID et auteur (pour vérifier les permissions)
	    List<Article> findByIdAndAuteur(Long id, User auteur);
	
}