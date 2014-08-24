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
import javax.print.attribute.standard.DialogTypeSelection;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class FicheFonctionnaire2FXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
       @FXML
        private void retourOnAction(ActionEvent event) throws IOException {        
        /// Vérification du mot de passe
        Main.root2 = FXMLLoader.load(getClass().getResource("FicheFonctionnaire1FXML.fxml"));        
        Main.scene2 =new Scene(Main.root2); 
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
        Main.primaryStage2.hide();
        
    } 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
