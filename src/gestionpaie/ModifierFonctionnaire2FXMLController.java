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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class ModifierFonctionnaire2FXMLController implements Initializable {

    @FXML
    private ChoiceBox fonctionCombo;
    @FXML
    private ComboBox statusCombo;
    @FXML
    private TextField categorie;
    @FXML
    private TextField echelon;
    @FXML
    private ComboBox banquesCombo;
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

    @FXML
    private void retourOnAction(ActionEvent event) throws IOException {
        /// Vérification du mot de passe
        Main.root2 = FXMLLoader.load(getClass().getResource("ModifierFonctionnaire1FXML.fxml"));
        Main.scene2 = new Scene(Main.root2);
        Main.primaryStage2.setScene(Main.scene2);
        Main.primaryStage2.show();

    }

    @FXML
    private void annulerOnAction(ActionEvent event) throws IOException {
        Main.primaryStage2.hide();

    }

    @FXML
    private void confirmerOnAction(ActionEvent event) throws IOException {
        /// Sauvegarde des données dans la BDD
        Main.primaryStage2.hide();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
