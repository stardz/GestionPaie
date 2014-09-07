/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpaie;

import static gestionpaie.MenuPrincipaleFXMLController.accordion1;
import static gestionpaie.MenuPrincipaleFXMLController.listesFonctionnaire;
import java.awt.Menu;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class ModifierFonctionnaire2FXMLController implements Initializable {

    @FXML
    private ComboBox<String> fonctionCombo;
    @FXML
    private ComboBox<String> statusCombo;
    @FXML
    private TextField categorie;
    @FXML
    private TextField echelon;
    @FXML
    private ComboBox<String> banquesCombo;
    @FXML
    private TextField numCompte;
    @FXML
    private TextField numMutuelle;
    @FXML
    private TextField codeIRG;
    @FXML
    private DatePicker dateRecrutement;
    @FXML
    private MenuButton retenusMenu;
    @FXML
    private MenuButton indimnitésMenu;

    @FXML
    private void retourOnAction(ActionEvent event) throws IOException {
        /// Vérification du mot de passe
        Main.root2 = FXMLLoader.load(getClass().getResource("ModifierFonctionnaire1FXML.fxml"));
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

        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        ArrayList<Banque> listeBanques = cnx.getAllBanque();
        ArrayList<Retenu> listeRetenus = cnx.getAllRetenu();
        ArrayList<Indemnite> listeIndemnites = cnx.getAllInimnete();
        ArrayList<Fonction> listeFonctions = cnx.getAllFonction();
        cnx.deconnecter();
        for (Banque banque : listeBanques) {
            banquesCombo.getItems().add(banque.getNomBanque());

        }
        for (Fonction fonction : listeFonctions) {
            fonctionCombo.getItems().add(fonction.getLibelleFonction());
        }
        for (Retenu retenu : listeRetenus) {
            //retenusCombo.getItems().add(retenu.getLibelleRetenu()) ;
            retenusMenu.getItems().add(new CheckMenuItem(retenu.getLibelleRetenu()));
            retenusMenu.getItems().add(new CheckMenuItem(retenu.getLibelleRetenu()));

        }

        for (Indemnite indemnite : listeIndemnites) {
            indimnitésMenu.getItems().add(new CheckMenuItem(indemnite.getLibelle_indemnite()));
            indimnitésMenu.getItems().add(new CheckMenuItem(indemnite.getLibelle_indemnite()));
        }
        statusCombo.getItems().add("Tutulaire");
        statusCombo.getItems().add("Vacataire");
        // TODO
        modifierFonctionnaire();
    }

    private void modifierFonctionnaire() {
        Fonctionnaire fonctionnaire ;
                int i = 0;
        while (i < MenuPrincipaleFXMLController.accordion1.getPanes().size() && !MenuPrincipaleFXMLController.accordion1.getPanes().get(i).isExpanded()) {
            i++;
        }
        if (i < MenuPrincipaleFXMLController.accordion1 .getPanes().size()) {
            
            

            fonctionnaire= MenuPrincipaleFXMLController.fonctionnairePanes.get(i).getFonctionnaire();
           // fonctionnaire =new Fonctionnaire(f.getNss(),f.getNomFonctionnaire(), f.getPrenomFonctionnaire(),f.getSexe(),f.getSituationFamiliale(),f.getDateRecrutement(), f.getEnfantCharg(), f.getEnfantScolarise(), f.getEnfantPlusDixAns(),f.getNumMutuelle(), f.getNumCompte(), f.getRue(),f.getVile(), f.getStatus()) ;
            afficherInformationsFonctionnaire(fonctionnaire);

        }
    }

    private void afficherInformationsFonctionnaire(Fonctionnaire fonctionnaire) {
        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        ArrayList<Fonction> listefonctions = cnx.getAllFonction(fonctionnaire.getNss());
        ArrayList<Bareme> listesBareme = cnx.getAllBareme(fonctionnaire.getNss());
        Banque banque = cnx.getBanque(fonctionnaire.getNss());
        cnx.deconnecter();
        fonctionCombo.setValue(listefonctions.get(0).getLibelleFonction());
       // System.out.println(" fonction " + listefonctions.get(listefonctions.size() - 1).getLibelleFonction());
        System.out.println(fonctionnaire.getDateRecrutement());
        banquesCombo.setValue(banque.getNomBanque());
        statusCombo.setValue(fonctionnaire.getStatus());
        dateRecrutement.setValue(LocalDate.parse(fonctionnaire.getDateRecrutement()));
        categorie.setText(listesBareme.get(listesBareme.size() - 1).getcategorieEchelon().split("/")[0]) ;
        echelon.setText(listesBareme.get(listesBareme.size() - 1).getcategorieEchelon().split("/")[1]);
        numCompte.setText(fonctionnaire.getNumCompte().toString());
        numMutuelle.setText(fonctionnaire.getNumMutuelle().toString());

    }

    @FXML
    private void confirmerOnAction(ActionEvent event) throws IOException {

        Fonctionnaire f = ModifierFonctionnaire1FXMLController.fonctionnaire;
        if (!numCompte.getText().isEmpty()) {
            f.setNumCompte(Long.parseLong(numCompte.getText()));
        }
        if (!numMutuelle.getText().isEmpty()) {
            f.setNumMutuelle(Long.parseLong(numMutuelle.getText()));
        }
        if (!statusCombo.getValue().isEmpty()) {
            f.setStatus(statusCombo.getValue().toString());

        }
        if (!dateRecrutement.getValue().toString().isEmpty()) {
            f.setDateRecrutement(dateRecrutement.getValue().toString());
        }

        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        /*  System.out.println("\n Codefonction :"+FicheFonctionnaire1FXMLController.fonction.getLibelleFonction());
         System.out.println("\n statusCombo :"+f.getStatus());
         System.out.println("\n Date de recrutement :"+f.getDateRecrutement().toString());
         System.out.println("\n banquesCombo:"+FicheFonctionnaire1FXMLController.banquesCombo.getNomBanque());
         System.out.println("\n bareme:"+FicheFonctionnaire1FXMLController.Barem.getcategorieEchelon());
         System.out.println("\n Num mutuelle:"+ f.getNumMutuelle());
         System.out.println("\n Num compte:"+ f.getNumCompte());*/
        System.out.println("id banque " + banquesCombo.getItems().indexOf(banquesCombo.getValue()) + 1);
        cnx.modifierFonctionnaire(f, banquesCombo.getItems().indexOf(banquesCombo.getValue()) + 1);
        cnx.attribuerFonction(f.getNss(), fonctionCombo.getItems().indexOf(fonctionCombo.getValue()) + 1, Date.valueOf(f.getDateRecrutement()));
        cnx.attribuerPrime(f.getNss(), 1);
        // cnx.attribuer

        for (int i = 0; i < retenusMenu.getItems().size(); i++) {
            if (((CheckMenuItem) retenusMenu.getItems().get(i)).isSelected()) {
                System.out.println("\n " + retenusMenu.getItems().get(i).getText());
                cnx.attribuerRetenu(f.getNss(), i + 1);
            }
        }
        for (int i = 0; i < indimnitésMenu.getItems().size(); i++) {
            if (((CheckMenuItem) indimnitésMenu.getItems().get(i)).isSelected()) {
                System.out.println("\n " + indimnitésMenu.getItems().get(i).getText());
                cnx.attribuerIndemnite(f.getNss(), i + 1);
            }
        }
        cnx.attribuerBareme(f.getNss(), categorie.getText() + "/" + echelon.getText(), Date.valueOf(f.getDateRecrutement()));
        int i = 0;
        while (i < accordion1.getPanes().size() && !accordion1.getPanes().get(i).isExpanded()) {
            i++;
        }
        if (i < accordion1.getPanes().size()) {
            MenuPrincipaleFXMLController.supprimerFonctionnaireAccordion(i);

        }

        MenuPrincipaleFXMLController.ajouterFonctionnaireAccordion(f, banquesCombo.getValue().toString(), fonctionCombo.getValue().toString());
        cnx.deconnecter();
        Main.primaryStage2.hide();

    }

}
