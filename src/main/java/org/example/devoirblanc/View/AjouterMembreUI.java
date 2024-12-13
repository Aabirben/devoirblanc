package org.example.devoirblanc.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.devoirblanc.Dao.MembreDao;
import org.example.devoirblanc.DaoImpl.MembreDaoImpl;
import org.example.devoirblanc.Model.Membre;

import java.util.UUID;

public class AjouterMembreUI extends Application {

    private MembreDao membreDao = new MembreDaoImpl();

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label lblTitle = new Label("Ajouter un nouveau membre");
        lblTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label lblNom = new Label("Nom:");
        TextField txtNom = new TextField();

        Label lblPrenom = new Label("Prénom:");
        TextField txtPrenom = new TextField();

        Label lblPhone = new Label("Phone:");
        TextField txtPhone = new TextField();

        Button btnInserer = new Button("Insérer");

        btnInserer.setOnAction(event -> {
            String nom = txtNom.getText().trim();
            String prenom = txtPrenom.getText().trim();
            String phone = txtPhone.getText().trim();

            if (nom.isEmpty() || prenom.isEmpty() || phone.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Tous les champs sont requis !");
                alert.show();
            } else {
                try {
                    // Générer un identifiant aléatoire sous format String
                    String id = UUID.randomUUID().toString();

                    // Créer l'objet Membre
                    Membre membre = new Membre(id, nom, prenom, "", phone);

                    // Insérer l'enregistrement dans la base de données
                    membreDao.insererMembre(membre);

                    Alert success = new Alert(Alert.AlertType.INFORMATION, "Membre ajouté avec succès !");
                    success.show();

                    // Nettoyer les champs après insertion
                    txtNom.clear();
                    txtPrenom.clear();
                    txtPhone.clear();

                } catch (Exception ex) {
                    Alert error = new Alert(Alert.AlertType.ERROR, "Erreur : " + ex.getMessage());
                    error.show();
                }
            }
        });

        gridPane.add(lblTitle, 0, 0, 2, 1);
        gridPane.add(lblNom, 0, 1);
        gridPane.add(txtNom, 1, 1);
        gridPane.add(lblPrenom, 0, 2);
        gridPane.add(txtPrenom, 1, 2);
        gridPane.add(lblPhone, 0, 3);
        gridPane.add(txtPhone, 1, 3);
        gridPane.add(btnInserer, 1, 4);

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setTitle("Ajouter un nouveau membre");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
