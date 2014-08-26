/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpaie;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class FicheFonctionnaire2FXMLController implements Initializable {

    @FXML
    private ComboBox codeFonction ;
    @FXML
    private ComboBox status ;
    @FXML
    private int categorie ;
    @FXML
    private int echelon ;
    @FXML
    private  String codeBanque;
    @FXML
    private int numCompte ;
    @FXML
    private  int numMutuelle ;
    @FXML
    private String codeIRG ;
    @FXML
    private  DatePicker dateRecrutement;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        codeFonction.getItems().add("Ing") ;
        codeFonction.getItems().add("TS") ;
        codeFonction.getItems().add("T") ;
        status.getItems().add("Tutulaire") ;
        status.getItems().add("Vacataire") ;
        dateRecrutement.setValue(LocalDate.MIN);
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
        Main.primaryStage2.hide();

    }

    @FXML
    private void enregistrerOnAction(ActionEvent event) throws IOException {
        /// Sauvegarde des données dans la BDD
        Fonctionnaire f=FicheFonctionnaire1FXMLController.f ;
        f.setStatus(status.getValue().toString());

    }

}
