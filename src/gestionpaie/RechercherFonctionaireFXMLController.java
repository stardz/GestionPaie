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
import javafx.fxml.Initializable ;
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
    private TextField  nss;
    @FXML
    private TextField  numCompte;
    @FXML
    private TextField numMutuelle;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom ;
    @FXML
    private DatePicker dateRecrut ;
    @FXML
    private ComboBox  codeFonction;
    @FXML
    private ComboBox situationFamiliale ;
    @FXML
    private RadioButton masculin;
    @FXML
    private RadioButton feminin;
    @FXML
    private TextField codeBanque ;
    public static Fonctionnaire fonctionnaire ;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }
    
    @FXML
    private void rechercherOnAction(ActionEvent event) throws IOException {
        /// Afficher les resultats de recherche
        fonctionnaire =new Fonctionnaire() ;
        fonctionnaire.setNss(Integer.parseInt(nss.getText()));
        fonctionnaire.setNomFonctionnaire(nom.getText());
        fonctionnaire.setPrenomFonctionnaire(prenom.getText());
        Main.primaryStage2.hide();

    }

    @FXML
    private void annulerOnAction(ActionEvent event) throws IOException {
        Main.primaryStage2.hide();

    }



}
