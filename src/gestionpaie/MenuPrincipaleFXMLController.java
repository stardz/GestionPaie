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

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class MenuPrincipaleFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
        @FXML
        private void insererFonctionaireOnAction(ActionEvent event) throws IOException {        
        /// Vérification du mot de passe
        Main.root2 = FXMLLoader.load(getClass().getResource("FicheFonctionnaire1FXML.fxml"));        
        Main.scene2 =new Scene(Main.root2); 
        Main.primaryStage2.setScene(Main.scene2);
        Main.primaryStage2.show();
        
    }
        @FXML
        private void rechercherFonctionaireOnAction(ActionEvent event) throws IOException {        
        /// Vérification du mot de passe
        Main.root2 = FXMLLoader.load(getClass().getResource("RechercherFonctionaireFXML.fxml"));        
        Main.scene2 =new Scene(Main.root2); 
        Main.primaryStage2.setScene(Main.scene2);
        Main.primaryStage2.show();
        
    }
        
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
