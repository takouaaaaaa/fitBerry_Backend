package com.iset.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientProfileDTO {
    private Long id;
    private String email;
    private Integer age;
    private String sexe;
    private Double poids;
    private Double taille;
    private String objectifs;
    private String allergies;
    private String maladiesChroniques;
    private String niveauActivite;
    private Double imc; // Calculé automatiquement
    private String categorieImc; // Calculé automatiquement
    private boolean profilComplet; // True si tous les champs obligatoires sont remplis

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public String getCategorieImc() {
        return categorieImc;
    }

    public void setCategorieImc(String categorieImc) {
        this.categorieImc = categorieImc;
    }

    public boolean isProfilComplet() {
        return profilComplet;
    }

    public void setProfilComplet(boolean profilComplet) {
        this.profilComplet = profilComplet;
    }
}
