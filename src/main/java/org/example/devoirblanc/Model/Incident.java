package org.example.devoirblanc.Model;

import java.sql.Timestamp;
import java.util.Objects;

public class Incident {
    private String reference;
    private Timestamp time;
    private String status;
    private String idMembre; // Clé étrangère

    // Constructeurs
    public Incident() {
    }

    public Incident(String reference, Timestamp time, String status, String idMembre) {
        this.reference = reference;
        this.time = time;
        this.status = status;
        this.idMembre = idMembre;
    }

    // Getters et Setters
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(String idMembre) {
        this.idMembre = idMembre;
    }

}
