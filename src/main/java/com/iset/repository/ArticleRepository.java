package com.iset.repository;

import com.iset.entity.Article;
import com.iset.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByAuteur(User auteur);
    List<Article> findByTitreContainingIgnoreCase(String titre);
}