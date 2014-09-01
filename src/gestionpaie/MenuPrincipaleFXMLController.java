/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpaie;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class MenuPrincipaleFXMLController implements Initializable {

    /**
     * ******************* LA CONFIGURATION *************************************
     */
    @FXML
    ComboBox categorieConf;
    @FXML
    ComboBox echelonConf;
    @FXML
    ComboBox libIndim;
    @FXML
    ComboBox libRet;
    @FXML
    ComboBox libPrime;
    @FXML
    ComboBox libFonct;
    @FXML
    ComboBox nomBanque;
    @FXML
    TextField indicereel;
    @FXML
    TextField ptsEchelon;
    @FXML
    TextField indiceBrut;
    @FXML
    TextField tauxInd;
    @FXML
    TextField valInd;
    @FXML
    TextField tauxRet;
    @FXML
    TextField valRet;
    @FXML
    TextField durePrime;
    @FXML
    TextField tauxPrime;
    @FXML
    Button validerBareme;
    @FXML
    Button validerInd;
    @FXML
    Button validerRet;
    @FXML
    Button validerPrime;
    @FXML
    Button validerFonct;
    @FXML
    Button validerBanque;

    /**
     * ******************* Fin conf *********************************************
     */
    @FXML
     Accordion fonctionnaireAccordion1;
    @FXML
    Accordion fonctionnaireAccordion2;
    @FXML
    Accordion fonctionnaireAccordion3;
    public static Accordion accordion ;
    private static ArrayList<Fonctionnaire> listesFonctionnaire;
    private static ArrayList<FonctionnairePane> fonctionnairePanes;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void insererFonctionaireOnAction(ActionEvent event) throws IOException {
        Main.root2 = FXMLLoader.load(getClass().getResource("FicheFonctionnaire1FXML.fxml"));
        Main.scene2 = new Scene(Main.root2);
        Main.primaryStage2.setScene(Main.scene2);
        Main.primaryStage2.show();

    }

    @FXML
    private void rechercherFonctionaireOnAction(ActionEvent event) throws IOException {
        Main.root2 = FXMLLoader.load(getClass().getResource("RechercherFonctionaireFXML.fxml"));
        Main.scene2 = new Scene(Main.root2);
        Main.primaryStage2.setScene(Main.scene2);
        Main.primaryStage2.show();

    }

    @FXML
    private void modifierFonctionnaireOnAction(ActionEvent event) throws IOException {

        Main.root2 = FXMLLoader.load(getClass().getResource("ModifierFonctionnaire1FXML.fxml"));
        Main.scene2 = new Scene(Main.root2);
        Main.primaryStage2.setScene(Main.scene2);
        Main.primaryStage2.show();

    }

    @FXML
    private void supprimerFonctionnaireOnAction(ActionEvent event) throws IOException {
        
        Main.root2 = FXMLLoader.load(getClass().getResource("SupprimerFonctionnaireFXML.fxml"));
        Main.scene2 = new Scene(Main.root2);
        Main.primaryStage2.setScene(Main.scene2);
        Main.primaryStage2.show();

    }

    @FXML
    private void actualiserOnAction(ActionEvent event) throws IOException {
        
        accordion.getPanes().remove(0, accordion.getPanes().size());
        for (FonctionnairePane pane : fonctionnairePanes) {

           // fonctionnaireAccordion2.getPanes().add(pane);
            fonctionnaireAccordion1.getPanes().add(pane);
           // fonctionnaireAccordion3.getPanes().add(pane);

        }
        accordion=fonctionnaireAccordion1 ;
    }
    @FXML
    private void salaireSelectionne(ActionEvent event) throws IOException {
           ConnexionBdd cnx=new ConnexionBdd();
           cnx.connecter();
           if(categorieConf.getValue()==null||echelonConf.getValue()==null) return;
           Bareme bareme=cnx.getBareme(categorieConf.getValue().toString()+"/"+ echelonConf.getValue().toString());
           indicereel.setText(""+bareme.getIndiceCategorie());
           ptsEchelon.setText(""+bareme.getIndiceEchelon());
           indiceBrut.setText(""+bareme.getIndiceCategorie()+bareme.getIndiceEchelon());
           cnx.deconnecter();
        
    }
    @FXML
    private void indemniteSelectionne(ActionEvent event) throws IOException {
          ConnexionBdd cnx=new ConnexionBdd();
           cnx.connecter();
           if(libIndim.getValue()==null) return;
           Indemnite indemnite=cnx.getInimnete(libIndim.getValue().toString());
           if(indemnite.getTaux_indemnite()<=200)tauxInd.setText(""+indemnite.getTaux_indemnite());
           else valInd.setText(""+indemnite.getLibelle_indemnite());
            cnx.deconnecter();
    }
    @FXML
    private void primeSelectionne(ActionEvent event) throws IOException {
         /*  ConnexionBdd cnx=new ConnexionBdd();
           cnx.connecter();
           if(libPrime.getValue()==null) return;
           Prime prime=cnx.getInimnete(libIndim.getValue().toString());
           if(indemnite.getTaux_indemnite()<=200)tauxInd.setText(""+indemnite.getLibelle_indemnite());
           else valInd.setText(""+indemnite.getLibelle_indemnite());
            cnx.deconnecter();*/
    }
    @FXML
    private void retenuSelectionne(ActionEvent event) throws IOException {

    }
    @FXML
    private void banqueSelectionne(ActionEvent event) throws IOException {

    }
    @FXML
    private void fonctionSelectionne(ActionEvent event) throws IOException {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        remplirAccordions();
        //la configuration
        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        // initialisation des combobox
        int i;
        for (i = 1; i <= 17; i++) {
            if(i<10)categorieConf.getItems().add("0" + i);
            else categorieConf.getItems().add("" + i);
        }
        for (i = 0; i <= 12; i++) {
            if(i<10)echelonConf.getItems().add("0" + i);
            else echelonConf.getItems().add("" + i);
        }
        for (i = 0; i < cnx.getAllInimnete().size(); i++) {
            libIndim.getItems().add("" + cnx.getAllInimnete().get(i).getLibelle_indemnite());
        }
        for (i = 0; i < cnx.getAllRetenu().size(); i++) {
            libRet.getItems().add("" + cnx.getAllRetenu().get(i).getLibelleRetenu());
        }
        for (i = 0; i < cnx.getAllPrime().size(); i++) {
            libPrime.getItems().add("" + cnx.getAllPrime().get(i).getLibellePrime());
        }
        for (i = 0; i < cnx.getAllFonction().size(); i++) {
            libFonct.getItems().add("" + cnx.getAllFonction().get(i).getLibelleFonction());
        }
        for (i = 0; i < cnx.getAllBanque().size(); i++) {
            nomBanque.getItems().add("" + cnx.getAllBanque().get(i).getNomBanque());
        }
        
        cnx.deconnecter();

    }

    public void remplirAccordions() {
        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        fonctionnairePanes = new ArrayList<FonctionnairePane>();
        listesFonctionnaire = cnx.getAllFonctionnaire();
        cnx.deconnecter();
        for (Fonctionnaire fonctionnaire : listesFonctionnaire) {
            FonctionnairePane pane = new FonctionnairePane(fonctionnaire);
            fonctionnairePanes.add(pane);

            fonctionnaireAccordion2.getPanes().add(pane);
            fonctionnaireAccordion1.getPanes().add(pane);
            fonctionnaireAccordion3.getPanes().add(pane);

        }
        accordion=fonctionnaireAccordion1 ;
        //fonctionnaireAccordion2=fonctionnaireAccordion1 ;
        // fonctionnaireAccordion3=fonctionnaireAccordion1 ;
        

        
    }
    public static void ajouterFonctionnaireAccordion(Fonctionnaire fonctionnaire){
            listesFonctionnaire.add(fonctionnaire) ;
             FonctionnairePane pane = new FonctionnairePane(fonctionnaire);
            fonctionnairePanes.add(pane);
            accordion.getPanes().add(pane);
            
        
    }
    }
    

