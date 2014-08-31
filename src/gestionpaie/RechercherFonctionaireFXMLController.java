/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpaie;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class RechercherFonctionaireFXMLController implements Initializable {

    @FXML
    private TextField nss;
    @FXML
    private TextField numCompte;
    @FXML
    private TextField numMutuelle;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private DatePicker dateRecrut;
    @FXML
    private ComboBox<String> codeFonction;
    @FXML
    private ComboBox<String> status;
    @FXML
    private ComboBox<String> situationFamiliale;
    @FXML
    private RadioButton masculin;
    @FXML
    private RadioButton feminin;
    public static Fonctionnaire fonctionnaire;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        situationFamiliale.getItems().add("Marié");
        situationFamiliale.getItems().add("Célibataire");
        situationFamiliale.getItems().add("divorsé");
        codeFonction.getItems().add("Ing");
        codeFonction.getItems().add("TS");
        codeFonction.getItems().add("T");
        status.getItems().add("Tutulaire");
        status.getItems().add("Vacataire");

        // TODO
    }

    @FXML
    private void rechercherOnAction(ActionEvent event) throws IOException {
        /// Afficher les resultats de recherche
        fonctionnaire = new Fonctionnaire();
        if (!nss.getText().isEmpty()) {
            fonctionnaire.setNss(Integer.parseInt(nss.getText()));
        }
        fonctionnaire.setNumCompte(Long.parseLong(numCompte.getText()));
        fonctionnaire.setNumMutuelle(Long.parseLong(numMutuelle.getText()));
        if (!nom.getText().isEmpty()) {
            fonctionnaire.setNomFonctionnaire(nom.getText());
        }

        if (!prenom.getText().isEmpty()) {
            fonctionnaire.setPrenomFonctionnaire(prenom.getText());
        }

        if (feminin.isSelected()) {
            fonctionnaire.setSexe("Feminin");
        } else {
            fonctionnaire.setSexe("Feminin");
        }
        fonctionnaire.setDateRecrutement(dateRecrut.getValue().toString()) ;
        if(!situationFamiliale.getValue().isEmpty()) fonctionnaire.setSituationFamiliale(situationFamiliale.getValue());
        if(!status.getValue().isEmpty())fonctionnaire.setStatus(status.getValue());
        
        /// lancer la requete de recherche
        
        Main.primaryStage2.hide();

    }

    @FXML
    private void annulerOnAction(ActionEvent event) throws IOException {
        Main.primaryStage2.hide();

    }

}
