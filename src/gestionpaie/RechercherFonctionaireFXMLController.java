/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpaie;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    public static Fonctionnaire fonctionnaireRecherche;
    public static Fonctionnaire fonctionnaireTrouve;

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
        fonctionnaireRecherche = new Fonctionnaire();
        if (!nss.getText().isEmpty()) {
            fonctionnaireRecherche.setNss(Integer.parseInt(nss.getText()));
        }
        if (!numCompte.getText().isEmpty()) {
            fonctionnaireRecherche.setNumCompte(Long.parseLong(numCompte.getText()));
        }
        if (!numMutuelle.getText().isEmpty()) {
            fonctionnaireRecherche.setNumMutuelle(Long.parseLong(numMutuelle.getText()));
        }

        if (!nom.getText().isEmpty()) {
            fonctionnaireRecherche.setNomFonctionnaire(nom.getText());
        }

        if (!prenom.getText().isEmpty()) {
            fonctionnaireRecherche.setPrenomFonctionnaire(prenom.getText());
        }

        if (feminin.isSelected()) {
            fonctionnaireRecherche.setSexe("Feminin");
        } else {
            fonctionnaireRecherche.setSexe("Feminin");
        }
        /*if(!=dateRecrut.get)
        //fonctionnaireRecherche.setDateRecrutement(dateRecrut.getValue().toString());
        if (!situationFamiliale.getValue().isEmpty()) {
            fonctionnaireRecherche.setSituationFamiliale(situationFamiliale.getValue());
        }
        if (!status.getValue().isEmpty()) {
            fonctionnaireRecherche.setStatus(status.getValue());
        }*/

        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        fonctionnaireTrouve = cnx.getFonctionnaire(fonctionnaireRecherche.getNss());

        MenuPrincipaleFXMLController.accordion1.getPanes().remove(0, MenuPrincipaleFXMLController.accordion1.getPanes().size());
         MenuPrincipaleFXMLController.accordion2.getPanes().remove(0, MenuPrincipaleFXMLController.accordion2.getPanes().size());
          MenuPrincipaleFXMLController.accordion3.getPanes().remove(0, MenuPrincipaleFXMLController.accordion3.getPanes().size());
        if (fonctionnaireTrouve != null) {
            Banque banque=cnx.getBanque(fonctionnaireTrouve.getNss()) ;
            ArrayList<Fonction> listeFonction=cnx.getAllFonction(fonctionnaireTrouve.getNss()) ;
            MenuPrincipaleFXMLController.accordion1.getPanes().add(new FonctionnairePane(fonctionnaireTrouve , banque.getNomBanque(),listeFonction.get(0).getLibelleFonction()));
            MenuPrincipaleFXMLController.accordion2.getPanes().add(new FonctionnairePane(fonctionnaireTrouve , banque.getNomBanque(),listeFonction.get(0).getLibelleFonction()));
            MenuPrincipaleFXMLController.accordion3.getPanes().add(new FonctionnairePane(fonctionnaireTrouve , banque.getNomBanque(),listeFonction.get(0).getLibelleFonction()));
        }

        cnx.deconnecter();

        Main.primaryStage2.hide();

    }
    @FXML
    private void annulerOnAction(ActionEvent event) throws IOException {
        Main.primaryStage2.hide();

    }

}
