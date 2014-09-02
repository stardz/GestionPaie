/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpaie;

import static gestionpaie.MenuPrincipaleFXMLController.accordion;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class ModifierFonctionnaire1FXMLController implements Initializable {



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
    public static Fonctionnaire fonctionnaireInitiale;
    public static Fonctionnaire fonctionnaireModifie;

    @FXML
    private void suivantOnAction(ActionEvent event) throws IOException {
        Main.root2 = FXMLLoader.load(getClass().getResource("ModifierFonctionnaire2FXML.fxml"));
        Main.scene2 = new Scene(Main.root2);
        Main.primaryStage2.setScene(Main.scene2);
        Main.primaryStage2.show();

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
        modifierFonctionnaire();
    }

    public void modifierFonctionnaire() {
        int i = 0;
        while (i < MenuPrincipaleFXMLController.accordion.getPanes().size() && !MenuPrincipaleFXMLController.accordion.getPanes().get(i).isExpanded()) {
            i++;
        }
        if (i < MenuPrincipaleFXMLController.accordion.getPanes().size()) {
            afficherFonctionnaire(MenuPrincipaleFXMLController.fonctionnairePanes.get(i).getFonctionnaire()) ;
            ConnexionBdd cnx = new ConnexionBdd();
            cnx.connecter();
            
            
            cnx.deconnecter();


        } else {
            // afficher message  selectionner un fonctionnaire
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("Vous devez selectionner un fonctionnaire  "), new Button("Ok.")).
                    alignment(Pos.CENTER).padding(new Insets(20)).build()));
            dialogStage.show();
        }

    }
    private void afficherFonctionnaire(Fonctionnaire fonctionnaire) {
       nss.setText(fonctionnaire.getNss().toString());
    }
}
