package org.example.devoirblanc.Controller;

import org.example.devoirblanc.Dao.MembreDao;
import org.example.devoirblanc.DaoImpl.MembreDaoImpl;
import org.example.devoirblanc.Model.Membre;

public class AjouterMembreController {
    private MembreDao membreDao;

    public AjouterMembreController() {
        membreDao = new MembreDaoImpl();
    }

    public void ajouterMembre(String nom, String prenom, String phone) {
        Membre membre = new Membre();
        membre.setId(java.util.UUID.randomUUID().toString()); // Générer un ID unique
        membre.setNom(nom);
        membre.setPrenom(prenom);
        membre.setPhone(phone);

        membreDao.insererMembre(membre);
    }
}
