package com.iset.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateClientProfileRequest {
    
    @NotNull(message = "L'âge est obligatoire")
    @Min(value = 1, message = "L'âge doit être supérieur à 0")
    private Integer age;
    
    @NotBlank(message = "Le sexe est obligatoire")
    private String sexe; // "Homme" ou "Femme"
    
    @NotNull(message = "Le poids est obligatoire")
    @Min(value = 1, message = "Le poids doit être supérieur à 0")
    private Double poids; // en kg
    
    @NotNull(message = "La taille est obligatoire")
    @Min(value = 1, message = "La taille doit être supérieure à 0")
    private Double taille; // en cm
    
    private String objectifs; // Objectifs nutritionnels (optionnel)
    
    private String allergies; // Allergies alimentaires (optionnel)
    
    private String maladiesChroniques; // Maladies chroniques (optionnel)
    
    private String niveauActivite; // Sédentaire, Modéré, Actif, Très actif (optionnel)

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public Double getTaille() {
        return taille;
    }

    public void setTaille(Double taille) {
        this.taille = taille;
    }

    public String getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(String objectifs) {
        this.objectifs = objectifs;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMaladiesChroniques() {
        return maladiesChroniques;
    }

    public void setMaladiesChroniques(String maladiesChroniques) {
        this.maladiesChroniques = maladiesChroniques;
    }

    public String getNiveauActivite() {
        return niveauActivite;
    }

    public void setNiveauActivite(String niveauActivite) {
        this.niveauActivite = niveauActivite;
    }
}
