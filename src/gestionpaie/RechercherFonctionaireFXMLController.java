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

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class RechercherFonctionaireFXMLController implements Initializable {

    @FXML
    private void rechercherOnAction(ActionEvent event) throws IOException {
        /// Afficher les resultats de recherche
        Main.primaryStage2.hide();

    }

    @FXML
    private void annulerOnAction(ActionEvent event) throws IOException {
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
