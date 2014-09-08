/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpaie;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class FicheFonctionnaire2FXMLController implements Initializable {

    @FXML
    private  ComboBox<String> fonctionCombo;
    @FXML
    private ComboBox<String> statusCombo;
    @FXML
    private TextField categorie;
    @FXML
    private TextField echelon;
    @FXML
    private ComboBox<String> banquesCombo;
    @FXML
    private TextField numCompte;
    @FXML
    private TextField numMutuelle;
    @FXML
    private TextField codeIRG;
    @FXML
    private DatePicker dateRecrutement;
    @FXML
    private MenuButton retenusMenu;
    @FXML
    private MenuButton indimnitésMenu;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        ArrayList<Banque> listeBanques = cnx.getAllBanque();
        ArrayList<Retenu> listeRetenus = cnx.getAllRetenu();
        ArrayList<Indemnite> listeIndemnites = cnx.getAllInimnete();
        ArrayList<Fonction> listeFonctions = cnx.getAllFonction();
        cnx.deconnecter();
        for (Banque banque : listeBanques) {
            banquesCombo.getItems().add(banque.getNomBanque());

        }
        for (Fonction fonction : listeFonctions) {
            fonctionCombo.getItems().add(fonction.getLibelleFonction());
        }
        for (Retenu retenu : listeRetenus) {
            //retenusCombo.getItems().add(retenu.getLibelleRetenu()) ;
            retenusMenu.getItems().add(new CheckMenuItem(retenu.getLibelleRetenu()));
           // retenusMenu.getItems().add(new CheckMenuItem(retenu.getLibelleRetenu()));

        }

        for (Indemnite indemnite : listeIndemnites) {
            indimnitésMenu.getItems().add(new CheckMenuItem(indemnite.getLibelle_indemnite()));
          //  indimnitésMenu.getItems().add(new CheckMenuItem(indemnite.getLibelle_indemnite()));
        }
        statusCombo.getItems().add("Tutulaire");
        statusCombo.getItems().add("Vacataire");
    }

    @FXML
    private void retourOnAction(ActionEvent event) throws IOException {
        /// Vérification du mot de passe
        Main.root2 = FXMLLoader.load(getClass().getResource("FicheFonctionnaire1FXML.fxml"));
        Main.scene2 = new Scene(Main.root2);
        Main.primaryStage2.setScene(Main.scene2);
        Main.primaryStage2.show();

    }

    @FXML
    private void annulerOnAction(ActionEvent event) throws IOException {
        for (int i = 0; i < retenusMenu.getItems().size(); i++) {
            if (((CheckMenuItem) retenusMenu.getItems().get(i)).isSelected()) {
                System.out.println("\n " + retenusMenu.getItems().get(i).getText());
            }
        }
        Main.primaryStage2.hide();

    }

    @FXML
    private void enregistrerOnAction(ActionEvent event) throws IOException {

        Fonctionnaire f = FicheFonctionnaire1FXMLController.fonctionnaire;
        if (!numCompte.getText().isEmpty()) {
            f.setNumCompte(Long.parseLong(numCompte.getText()));
        }
        if (!numMutuelle.getText().isEmpty()) {
            f.setNumMutuelle(Long.parseLong(numMutuelle.getText()));
        }
        if (!statusCombo.getValue().isEmpty()) {
            f.setStatus(statusCombo.getValue().toString());

        }
        if (!dateRecrutement.getValue().toString().isEmpty()) {
            f.setDateRecrutement(dateRecrutement.getValue().toString());
        }

        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        cnx.insertFonctionnaire(f, banquesCombo.getItems().indexOf(banquesCombo.getValue()) + 1);
        cnx.attribuerFonction(f.getNss(), fonctionCombo.getItems().indexOf(fonctionCombo.getValue()) + 1, Date.valueOf(f.getDateRecrutement()));
        cnx.attribuerPrime(f.getNss(), 1);
        // cnx.attribuer

        for (int i = 0; i < retenusMenu.getItems().size(); i++) {
            if (((CheckMenuItem) retenusMenu.getItems().get(i)).isSelected()) {
                System.out.println("\n " + retenusMenu.getItems().get(i).getText());
                cnx.attribuerRetenu(f.getNss(), i + 1);
            }
        }
        for (int i = 0; i < indimnitésMenu.getItems().size(); i++) {
            if (((CheckMenuItem) indimnitésMenu.getItems().get(i)).isSelected()) {
                System.out.println("\n " + indimnitésMenu.getItems().get(i).getText());
                cnx.attribuerIndemnite(f.getNss(), i + 1);
            }
        }
        cnx.attribuerBareme(f.getNss(), categorie.getText() + "/" + echelon.getText(), Date.valueOf(f.getDateRecrutement()));
        MenuPrincipaleFXMLController.ajouterFonctionnaireAccordion(f, banquesCombo.getValue().toString(), fonctionCombo.getValue().toString());
        cnx.deconnecter();
        Main.primaryStage2.hide();
    }
}
