package org.example.devoirblanc.Dao;

import org.example.devoirblanc.Model.Membre;

import org.example.devoirblanc.Model.Incident;

import java.util.List;
import java.util.Set;

public interface MembreDao {
    void insererMembre(Membre membre);          // Insérer un membre
    List<Membre> listerMembres();              // Lister tous les membres
    List<Incident> chargerListIncidents(String idMembre); // Charger la liste des incidents d'un membre
}
