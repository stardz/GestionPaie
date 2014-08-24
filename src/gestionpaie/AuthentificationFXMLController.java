/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpaie;

import static gestionpaie.Main.root1;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Oop
 */
public class AuthentificationFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField nomUtilisateur;
    @FXML
    TextField motdePasse;

    @FXML
    private void connexion(ActionEvent event) throws IOException {
        /// Vérification du mot de passe
        Main.root1 = FXMLLoader.load(getClass().getResource("MenuPrincipale1FXML.fxml"));
        Main.scene1 = new Scene(root1);
        Main.primaryStage1.setScene(Main.scene1);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
