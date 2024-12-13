package org.example.devoirblanc.Dao;

import org.example.devoirblanc.Model.Incident;

import java.util.Set;

public interface IncidentDao {
    void inserer(Incident i);      // Insérer un seul incident
    void inserer(Set<Incident> incidents); // Insérer plusieurs incidents
}
