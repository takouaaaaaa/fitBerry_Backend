package com.iset.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iset.DTO.ArticleDTO;
import com.iset.DTO.CreateArticleRequest;
import com.iset.service.ArticleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ArticleController {
    
    private final ArticleService articleService;
    
    
    public ArticleController(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}

	// Créer un article (nutritionniste seulement)
    @PostMapping("/nutritionniste/{nutritionnisteId}")
    public ResponseEntity<ArticleDTO> createArticle(
            @Valid @RequestBody CreateArticleRequest request,
            @PathVariable Long nutritionnisteId) {
        try {
            ArticleDTO article = articleService.createArticle(request, nutritionnisteId);
            return ResponseEntity.status(HttpStatus.CREATED).body(article);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    // Mettre à jour un article (nutritionniste auteur seulement)
    @PutMapping("/{articleId}/nutritionniste/{nutritionnisteId}")
    public ResponseEntity<ArticleDTO> updateArticle(
            @PathVariable Long articleId,
            @Valid @RequestBody CreateArticleRequest request,
            @PathVariable Long nutritionnisteId) {
        try {
            ArticleDTO article = articleService.updateArticle(articleId, request, nutritionnisteId);
            return ResponseEntity.ok(article);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
    
    // Supprimer un article (nutritionniste auteur seulement)
    @DeleteMapping("/{articleId}/nutritionniste/{nutritionnisteId}")
    public ResponseEntity<Void> deleteArticle(
            @PathVariable Long articleId,
            @PathVariable Long nutritionnisteId) {
        try {
            articleService.deleteArticle(articleId, nutritionnisteId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
    
    // Récupérer tous les articles (accessible à tous)
    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getAllArticles() {
        List<ArticleDTO> articles = articleService.getAllArticles();
        return ResponseEntity.ok(articles);
    }
    
    // Récupérer un article par ID (accessible à tous)
    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable Long articleId) {
        try {
            ArticleDTO article = articleService.getArticleById(articleId);
            return ResponseEntity.ok(article);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Récupérer tous les articles d'un nutritionniste (accessible à tous)
    @GetMapping("/nutritionniste/{nutritionnisteId}")
    public ResponseEntity<List<ArticleDTO>> getArticlesByNutritionniste(
            @PathVariable Long nutritionnisteId) {
        List<ArticleDTO> articles = articleService.getArticlesByNutritionniste(nutritionnisteId);
        return ResponseEntity.ok(articles);
    }
    
    
// ==================== CLIENT ENDPOINTS ====================
    
    // Consulter tous les articles (accessible aux clients)
    @GetMapping("/client/all")
    public ResponseEntity<List<ArticleDTO>> getAllArticlesForClient() {
        List<ArticleDTO> articles = articleService.getAllArticles();
        return ResponseEntity.ok(articles);
    }
    
    // Consulter un article par ID (accessible aux clients)
    @GetMapping("/client/{articleId}")
    public ResponseEntity<ArticleDTO> getArticleByIdForClient(@PathVariable Long articleId) {
        try {
            ArticleDTO article = articleService.getArticleById(articleId);
            return ResponseEntity.ok(article);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Consulter les articles d'un nutritionniste spécifique (accessible aux clients)
    @GetMapping("/client/nutritionniste/{nutritionnisteId}")
    public ResponseEntity<List<ArticleDTO>> getArticlesByNutritionnisteForClient(
            @PathVariable Long nutritionnisteId) {
        List<ArticleDTO> articles = articleService.getArticlesByNutritionniste(nutritionnisteId);
        return ResponseEntity.ok(articles);
    }
}