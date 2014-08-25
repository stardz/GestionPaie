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

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class FicheFonctionnaire1FXMLController implements Initializable {


    
    @FXML
    private ChoiceBox choiceSituationFamiliale ;
    /**
     * Initializes the controller class.
     */
    @FXML
    private void suivantOnAction(ActionEvent event) throws IOException {
        Main.root2 = FXMLLoader.load(getClass().getResource("FicheFonctionnaire2FXML.fxml"));
        Main.scene2 = new Scene(Main.root2);
        Main.primaryStage2.setScene(Main.scene2);
        Main.primaryStage2.show();

    }

    @FXML
    private void annulerOnAction(ActionEvent event) throws IOException {
        Main.primaryStage2.hide();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
