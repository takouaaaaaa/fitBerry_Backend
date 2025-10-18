package com.iset.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
    private Long id;
    private String titre;
    private String description;
    private String imageURL;
    private Long auteurId;
    private String auteurNom;
    private String auteurPrenom;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public Long getAuteurId() {
		return auteurId;
	}
	public void setAuteurId(Long auteurId) {
		this.auteurId = auteurId;
	}
	public String getAuteurNom() {
		return auteurNom;
	}
	public void setAuteurNom(String auteurNom) {
		this.auteurNom = auteurNom;
	}
	public String getAuteurPrenom() {
		return auteurPrenom;
	}
	public void setAuteurPrenom(String auteurPrenom) {
		this.auteurPrenom = auteurPrenom;
	}
    
}