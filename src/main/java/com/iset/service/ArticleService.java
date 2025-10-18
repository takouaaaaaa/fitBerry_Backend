package com.iset.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iset.DTO.ArticleDTO;
import com.iset.DTO.CreateArticleRequest;
import com.iset.entity.Article;
import com.iset.entity.Nutritioniste;
import com.iset.entity.User;
import com.iset.repository.ArticleRepository;
import com.iset.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {
    
    private final ArticleRepository articleRepository ;
    private final UserRepository userRepository;
    
    
    public ArticleService(ArticleRepository articleRepository, UserRepository userRepository) {
		super();
		this.articleRepository = articleRepository;
		this.userRepository = userRepository;
	}

	// Créer un article
    @Transactional
    public ArticleDTO createArticle(CreateArticleRequest request, Long nutritionnisteId) {
        User nutritionniste = userRepository.findById(nutritionnisteId)
                .orElseThrow(() -> new RuntimeException("Nutritionniste non trouvé"));
        
        if (nutritionniste.getRole() != User.Role.NUTRITIONNISTE) {
            throw new RuntimeException("Seul un nutritionniste peut créer un article");
        }
        
        Article article = new Article();
        article.setTitre(request.getTitre());
        article.setDescription(request.getDescription());
        article.setImageURL(request.getImageURL());
        article.setAuteur(nutritionniste);
        
        Article savedArticle = articleRepository.save(article);
        return convertToDTO(savedArticle);
    }
    
    // Mettre à jour un article
    @Transactional
    public ArticleDTO updateArticle(Long articleId, CreateArticleRequest request, Long nutritionnisteId) {
        User nutritionniste = userRepository.findById(nutritionnisteId)
                .orElseThrow(() -> new RuntimeException("Nutritionniste non trouvé"));
        
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article non trouvé"));
        
        // Vérifier que le nutritionniste est l'auteur de l'article
        if (!article.getAuteur().getId().equals(nutritionnisteId)) {
            throw new RuntimeException("Vous n'êtes pas autorisé à modifier cet article");
        }
        
        article.setTitre(request.getTitre());
        article.setDescription(request.getDescription());
        article.setImageURL(request.getImageURL());
        
        Article updatedArticle = articleRepository.save(article);
        return convertToDTO(updatedArticle);
    }
    
    // Supprimer un article
    @Transactional
    public void deleteArticle(Long articleId, Long nutritionnisteId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article non trouvé"));
        
        // Vérifier que le nutritionniste est l'auteur de l'article
        if (!article.getAuteur().getId().equals(nutritionnisteId)) {
            throw new RuntimeException("Vous n'êtes pas autorisé à supprimer cet article");
        }
        
        articleRepository.delete(article);
    }
    
    // Récupérer tous les articles
    public List<ArticleDTO> getAllArticles() {
        return articleRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    // Récupérer un article par ID
    public ArticleDTO getArticleById(Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article non trouvé"));
        return convertToDTO(article);
    }
    
    // Récupérer tous les articles d'un nutritionniste
    public List<ArticleDTO> getArticlesByNutritionniste(Long nutritionnisteId) {
        return articleRepository.findByAuteurId(nutritionnisteId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    // Convertir Article en ArticleDTO
    private ArticleDTO convertToDTO(Article article) {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(article.getId());
        dto.setTitre(article.getTitre());
        dto.setDescription(article.getDescription());
        dto.setImageURL(article.getImageURL());
        dto.setAuteurId(article.getAuteur().getId());
        
        // Si l'auteur est un Nutritioniste, récupérer nom et prénom
        if (article.getAuteur() instanceof Nutritioniste) {
            Nutritioniste nutritioniste = (Nutritioniste) article.getAuteur();
            dto.setAuteurNom(nutritioniste.getNom());
            dto.setAuteurPrenom(nutritioniste.getPrenom());
        }
        
        return dto;
    }
}