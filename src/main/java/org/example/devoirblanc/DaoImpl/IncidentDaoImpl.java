package org.example.devoirblanc.DaoImpl;

import org.example.devoirblanc.Dao.IncidentDao;
import org.example.devoirblanc.Model.Incident;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IncidentDaoImpl implements IncidentDao {
    private List<Incident> incidents = new ArrayList<>();

    @Override
    public void inserer(Incident i) {
        // Ajouter un incident unique
        incidents.add(i);
        System.out.println("Incident inséré : " + i.getReference());
    }

    @Override
    public void inserer(Set<Incident> incidentSet) {
        // Ajouter un ensemble d'incidents
        incidents.addAll(incidentSet);
        System.out.println(incidentSet.size() + " incidents insérés.");
    }


}
