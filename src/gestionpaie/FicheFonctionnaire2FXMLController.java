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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
    private TextField categorie ;
    @FXML
    private TextField echelon ;
    @FXML
    private  TextField codeBanque;
    @FXML
    private TextField numCompte ;
    @FXML
    private TextField numMutuelle ;
    @FXML
    private TextField codeIRG ;
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
        
        FicheFonctionnaire1FXMLController.fonction=new Fonction(codeFonction.getValue().toString()) ;
        //FicheFonctionnaire1FXMLController.Barem=new Bareme(categorie.getText()+"/"+echelon.getText());
        /// attribuerBarem()
        // attribuerFonction()
        
        
        Fonctionnaire f=FicheFonctionnaire1FXMLController.fonctionnaire ;        
        f.setNumCompte(Long.parseLong(numCompte.getText()));
        f.setNumMutuelle(Long.parseLong(numMutuelle.getText()));
        f.setStatus(status.getValue().toString());
        f.setDateRecrutement(dateRecrutement.getValue().toString()) ;
        
        
        
       /* System.out.println("\n Codefonction :"+FicheFonctionnaire1FXMLController.fonction.getLibelleFonction());
        System.out.println("\n status :"+f.getStatus());
        System.out.println("\n Date de recrutement :"+f.getDateRecrutement().toString());
        System.out.println("\n banque:"+FicheFonctionnaire1FXMLController.banque.getNomBanque());
        System.out.println("\n bareme:"+FicheFonctionnaire1FXMLController.Barem.getcategorieEchelon());
        System.out.println("\n Num mutuelle:"+ f.getNumMutuelle());
        System.out.println("\n Num compte:"+ f.getNumCompte());*/

    }

}
