package org.example.devoirblanc.Model;

import java.util.Objects;

import java.util.Objects;

public class Membre {
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String phone;

    // Constructeur par défaut
    public Membre() {
    }

    // Constructeur avec tous les champs
    public Membre(String id, String nom, String prenom, String email, String phone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Redéfinition de equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membre membre = (Membre) o;
        return id.equals(membre.id);
    }

    // Redéfinition de hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
