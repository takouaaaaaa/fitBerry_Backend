package com.iset.repository;

import com.iset.entity.Commentaire;
import com.iset.entity.Article;
import com.iset.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    List<Commentaire> findByArticle(Article article);
    List<Commentaire> findByUser(User user);
    List<Commentaire> findByArticleOrderByIdDesc(Article article);
}