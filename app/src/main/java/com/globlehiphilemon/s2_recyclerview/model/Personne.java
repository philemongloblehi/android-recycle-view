package com.globlehiphilemon.s2_recyclerview.model;

import java.io.Serializable;

public class Personne implements Serializable {

    private String code;
    private String nom;
    private String prenoms;
    private String commune;

    public Personne(String code, String nom, String prenoms, String commune) {
        this.code = code;
        this.nom = nom;
        this.prenoms = prenoms;
        this.commune = commune;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    @Override
    public String toString() {
        return "Personne{" +
                "code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", prenoms='" + prenoms + '\'' +
                ", commune='" + commune + '\'' +
                '}';
    }
}
