/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionpaie;

import static gestionpaie.Main.root1;
import static gestionpaie.Main.scene1;
import static gestionpaie.Main.primaryStage1 ;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;

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
        Main.root1 = FXMLLoader.load(getClass().getResource("MenuPrincipaleFXML.fxml"));        
        Main.scene1 =new Scene(root1); 
        Main.primaryStage1.setScene(Main.scene1);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
       
    
}
