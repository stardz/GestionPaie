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
    private TextField nss;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private RadioButton masculin;
    @FXML
    private RadioButton feminin;
    @FXML
    private ComboBox<String> choiceSituationFamiliale;
    @FXML
    private TextField enfantsEnCharge;
    @FXML
    private TextField enfantScolarise;
    @FXML
    private TextField enfantPlus10Ans;
    @FXML
    private TextField adresseVille;
    @FXML
    private TextField adresseRue;
    public static Fonctionnaire fonctionnaire;
    public static Bareme Barem;
    public static Fonction fonction;
    public static Banque banque;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        choiceSituationFamiliale.getItems().add("Marié");
        choiceSituationFamiliale.getItems().add("Célibataire");
        choiceSituationFamiliale.getItems().add("divorsé");

    }

    @FXML
    private void suivantOnAction(ActionEvent event) throws IOException {
        fonctionnaire = new Fonctionnaire();
        if (!nss.getText().isEmpty()) {
            fonctionnaire.setNss(Integer.parseInt(nss.getText()));
        }
        if (!nom.getText().isEmpty()) {
            fonctionnaire.setNomFonctionnaire(nom.getText());
        }
        if (!prenom.getText().isEmpty()) {
            fonctionnaire.setPrenomFonctionnaire(prenom.getText());
        }

        if (feminin.isSelected()) {
            fonctionnaire.setSexe("Feminin");
        } else {
            fonctionnaire.setSexe("Masculin");
        }
        // System.out.println("si " + choiceSituationFamiliale.getValue());
        if (!choiceSituationFamiliale.getValue().isEmpty()) {
            fonctionnaire.setSituationFamiliale(choiceSituationFamiliale.getValue());
        }
        if (!adresseRue.getText().isEmpty()) {
            fonctionnaire.setRue(adresseRue.getText());
        }
        if (!enfantsEnCharge.getText().isEmpty()) {
            fonctionnaire.setEnfantCharg(Integer.parseInt(enfantsEnCharge.getText()));
        }
        if (!enfantScolarise.getText().isEmpty()) {
            fonctionnaire.setEnfantScolarise(Integer.parseInt(enfantScolarise.getText()));
        }
        if (!enfantPlus10Ans.getText().isEmpty()) {
            fonctionnaire.setEnfantPlusDixAns(Integer.parseInt(enfantPlus10Ans.getText()));
        }
        if (!adresseVille.getText().isEmpty()) {
            fonctionnaire.setVile(adresseVille.getText());
        }

        /*System.out.println("\n  NSS :"+ fonctionnaire.getNss() +" / enfan en charge : "+fonctionnaire.getEnfantCharg());
         System.out.println("\n Nom :"+fonctionnaire.getNomFonctionnaire()+" /  enfant scolarise :"+fonctionnaire.getEnfantScolarise());
         System.out.println("\n Prenom :"+fonctionnaire.getPrenomFonctionnaire()+" / enfant+10ans : "+ fonctionnaire.getEnfantPlusDixAns());
         System.out.println("\n Sexe :"+fonctionnaire.getSexe()+ "/ ville : "+ fonctionnaire.getVile());
         System.out.println("\n situation familiale : "+fonctionnaire.getSituationFamiliale()+" /  rue :"+fonctionnaire.getRue());*/
        Main.root2 = FXMLLoader.load(getClass().getResource("FicheFonctionnaire2FXML.fxml"));
        Main.scene2 = new Scene(Main.root2);
        Main.primaryStage2.setScene(Main.scene2);
        Main.primaryStage2.show();

    }

    @FXML
    private void annulerOnAction(ActionEvent event) throws IOException {
        Main.primaryStage2.hide();

    }

    @FXML
    private void retourOnAction(ActionEvent event) throws IOException {
        /// Vérification du mot de passe
        Main.root2 = FXMLLoader.load(getClass().getResource("FicheFonctionnaire1FXML.fxml"));
        Main.scene2 = new Scene(Main.root2);
        Main.primaryStage2.setScene(Main.scene2);
        Main.primaryStage2.show();

    }
}
