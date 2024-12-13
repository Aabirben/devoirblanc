package org.example.devoirblanc.DaoImpl;

import org.example.devoirblanc.Dao.MembreDao;
import org.example.devoirblanc.Model.Membre;
import org.example.devoirblanc.Model.Incident;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class MembreDaoImpl implements MembreDao {
    private final String url = "jdbc:mysql://localhost:3306/devoirblanc";
    private final String username = "root";
    private final String password = "";

    @Override
    public void insererMembre(Membre membre) {
        String query = "INSERT INTO Membre (id, nom, prenom, email, phone) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, membre.getId());
            statement.setString(2, membre.getNom());
            statement.setString(3, membre.getPrenom());
            statement.setString(4, membre.getEmail());
            statement.setString(5, membre.getPhone());
            statement.executeUpdate();
            System.out.println("Membre inséré : " + membre.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Membre> listerMembres() {
        List<Membre> membres = new ArrayList<>();
        String query = "SELECT * FROM Membre";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Membre membre = new Membre();
                membre.setId(resultSet.getString("id"));
                membre.setNom(resultSet.getString("nom"));
                membre.setPrenom(resultSet.getString("prenom"));
                membre.setEmail(resultSet.getString("email"));
                membre.setPhone(resultSet.getString("phone"));
                membres.add(membre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return membres;
    }

    @Override
    public List<Incident> chargerListIncidents(String idMembre) {
        List<Incident> incidents = new ArrayList<>();
        String query = "SELECT * FROM Incident WHERE id_membre = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, idMembre);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Incident incident = new Incident();
                    incident.setReference(resultSet.getString("reference"));
                    incident.setTime(resultSet.getTimestamp("time"));
                    incident.setStatus(resultSet.getString("status"));
                    incident.setIdMembre(resultSet.getString("id_membre"));
                    incidents.add(incident);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incidents;
    }


    public List<Membre> chargerListeMembre(String nomFichier) {
        Set<Membre> membres = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] elements = ligne.split(",");

                if (elements.length == 4) {
                    String nom = elements[0].trim();
                    String prenom = elements[1].trim();
                    String email = elements[2].trim();
                    String phone = elements[3].trim();

                    Membre membre = new Membre(UUID.randomUUID().toString(), nom, prenom, email, phone);

                    membres.add(membre);  // Utilise Set pour éviter les doublons
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(membres);
    }
    public static void main(String[] args) {
        MembreDaoImpl dao = new MembreDaoImpl();
        List<Membre> membres = dao.chargerListeMembre("membres.csv");

        for (Membre membre : membres) {
            System.out.println("Nom : " + membre.getNom() + ", Prénom : " + membre.getPrenom() +
                    ", Email : " + membre.getEmail() + ", Phone : " + membre.getPhone());
        }
    }

}
