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
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class FicheFonctionnaire1FXMLController implements Initializable {

    @FXML
    private TextField identifiant ;
    @FXML
    private TextField nom ;
    @FXML
    private TextField prenom;
    @FXML
    private  RadioButton masculin;
   @FXML
    private  RadioButton feminin ;
    @FXML
    private ComboBox<String> choiceSituationFamiliale;
    @FXML
    private  TextField enfantsEnCharge;
    @FXML
    private  TextField enfantScolarise;
    @FXML
    private  TextField enfantPlus10Ans ;
    @FXML
    private  TextField  adresseVille;
    @FXML
    private  TextField  adresseRue ;

    
    
    
        /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {

        choiceSituationFamiliale.getItems().add("Marié");
        choiceSituationFamiliale.getItems().add("Célibataire");
        choiceSituationFamiliale.getItems().add("divorsé");

    }

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



}
