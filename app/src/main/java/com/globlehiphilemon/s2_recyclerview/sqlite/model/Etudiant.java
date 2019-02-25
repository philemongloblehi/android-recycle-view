package com.globlehiphilemon.s2_recyclerview.sqlite.model;

public class Etudiant {

    private Long id;
    private String nom;
    private String prenoms;
    private String commune;
    private String filiere;

    public Etudiant() {
        super();
    }

    public Etudiant(String nom, String prenoms, String commune, String filiere) {
        this.nom = nom;
        this.prenoms = prenoms;
        this.commune = commune;
        this.filiere = filiere;
    }

    public Etudiant(Long id, String nom, String prenoms, String commune, String filiere) {
        this.id = id;
        this.nom = nom;
        this.prenoms = prenoms;
        this.commune = commune;
        this.filiere = filiere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
}
