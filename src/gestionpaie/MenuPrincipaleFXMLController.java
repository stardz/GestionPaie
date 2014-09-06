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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
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
public class MenuPrincipaleFXMLController implements Initializable {

    /**
     * ******************* LA CONFIGURATION
     * *************************************
     */
    @FXML
    PieChart pieChart;
    @FXML
    TabPane tabPane;
    @FXML
    ComboBox valTauxInd;
    @FXML
    ComboBox valTauxRet;
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
     * ******************* Fin conf
     * *********************************************
     */
    @FXML
    Accordion fonctionnaireAccordion1;
    @FXML
    Accordion fonctionnaireAccordion2;
    @FXML
    Accordion fonctionnaireAccordion3;
    public static Accordion accordion1;
    public static Accordion accordion2;
    public static Accordion accordion3;
    public static ArrayList<Fonctionnaire> listesFonctionnaire;
    public static ArrayList<FonctionnairePane> fonctionnairePanes;

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

        int i = 0;
        while (i < accordion1.getPanes().size() && !accordion1.getPanes().get(i).isExpanded()) {
            i++;
        }
        if (i < accordion1.getPanes().size()) {

            Main.root2 = FXMLLoader.load(getClass().getResource("ModifierFonctionnaire1FXML.fxml"));
            Main.scene2 = new Scene(Main.root2);
            Main.primaryStage2.setScene(Main.scene2);
            Main.primaryStage2.show();
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

    @FXML
    private void supprimerFonctionnaireOnAction(ActionEvent event) throws IOException {

        int i = 0;
        while (i < accordion1.getPanes().size() && !accordion1.getPanes().get(i).isExpanded()) {
            i++;
        }
        if (i < accordion1.getPanes().size()) {

            ConnexionBdd cnx = new ConnexionBdd();
            cnx.connecter();
            cnx.supprimer(fonctionnairePanes.get(i).getFonctionnaire().getNss());
            //  System.out.println("\nNSS :"+fonctionnairePanes.get(j).getFonctionnaire().getNss());
            // System.out.println("\n size accordion1 :"+accordion1.getPanes().size() ) ;
            // System.out.println("\n size accordion1 :"+ fonctionnairePanes.size()) ;
            cnx.deconnecter();
            accordion1.getPanes().remove(i);
            accordion2.getPanes().remove(i);
            accordion3.getPanes().remove(i);
            fonctionnairePanes.remove(i);

        } else {
            // afficher message  selectionner un fonctionnaire
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("Vous devez selectionner un fonctionnaire  "), new Button("Ok.")).
                    alignment(Pos.CENTER).padding(new Insets(20)).build()));
            dialogStage.show();
        }

        /*Main.root2 = FXMLLoader.load(getClass().getResource("SupprimerFonctionnaireFXML.fxml"));
         Main.scene2 = new Scene(Main.root2);
         Main.primaryStage2.setScene(Main.scene2);
         Main.primaryStage2.show();*/
    }

    @FXML
    private void actualiserOnAction(ActionEvent event) throws IOException {

        accordion1.getPanes().remove(0, accordion1.getPanes().size());
        for (FonctionnairePane pane : fonctionnairePanes) {

            // fonctionnaireAccordion2.getPanes().add(pane);
            fonctionnaireAccordion1.getPanes().add(pane);
            // fonctionnaireAccordion3.getPanes().add(pane);

        }
        accordion1 = fonctionnaireAccordion1;
    }

    @FXML
    private void salaireSelectionne(ActionEvent event) throws IOException {
        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        if (categorieConf.getValue() == null || echelonConf.getValue() == null) {
            return;
        }
        Bareme bareme = cnx.getBareme(categorieConf.getValue().toString() + "/" + echelonConf.getValue().toString());
        if (bareme == null) {
            return;
        }
        indicereel.setText("" + bareme.getIndiceCategorie());
        ptsEchelon.setText("" + bareme.getIndiceEchelon());
        indiceBrut.setText("" + bareme.getIndiceCategorie() + bareme.getIndiceEchelon());
        cnx.deconnecter();

    }

    @FXML
    private void indemniteSelectionne(ActionEvent event) throws IOException {
        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        if (libIndim.getValue() == null) {
            return;
        }
        Indemnite indemnite = cnx.getInimnete(libIndim.getValue().toString());
        if (indemnite == null) {
            return;
        }
        if (indemnite.getTaux_indemnite() <= 200) {
            tauxInd.setText("" + indemnite.getTaux_indemnite());
        } else {
            valInd.setText("" + indemnite.getTaux_indemnite());
        }
        cnx.deconnecter();
    }

    @FXML
    private void primeSelectionne(ActionEvent event) throws IOException {
        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        if (libPrime.getValue() == null) {
            return;
        }
        Prime prime = cnx.getPrime(libPrime.getValue().toString());
        if (prime == null) {
            return;
        }
        tauxPrime.setText("" + prime.getTauxPrime());
        durePrime.setText("" + prime.getDurePrime());
        cnx.deconnecter();
    }

    @FXML
    private void retenuSelectionne(ActionEvent event) throws IOException {
        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        if (libRet.getValue() == null) {
            return;
        }
        Retenu retenu = cnx.getRetenu(libRet.getValue().toString());
        if (retenu == null) {
            return;
        }
        if (retenu.getTauxRetenu() <= 200) {
            tauxRet.setText("" + retenu.getTauxRetenu());
        } else {
            valRet.setText("" + retenu.getTauxRetenu());
        }
        cnx.deconnecter();
    }

    @FXML
    private void validerBareme(ActionEvent event) throws IOException {
        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        if (categorieConf.getValue() == null || echelonConf.getValue() == null || indicereel.getText() == null
                || indiceBrut.getText() == null || ptsEchelon.getText() == null) {
            return;
        }

        if (cnx.getBareme(categorieConf.getValue().toString() + "/" + echelonConf.getValue().toString()) == null) {
            cnx.insertBareme(new Bareme(categorieConf.getValue().toString() + "/" + echelonConf.getValue().toString(),
                    Integer.parseInt(indicereel.getText()), Integer.parseInt(ptsEchelon.getText())));
        } else {
            cnx.modifierBarem(new Bareme(categorieConf.getValue().toString() + "/" + echelonConf.getValue().toString(),
                    Integer.parseInt(indicereel.getText()), Integer.parseInt(ptsEchelon.getText())));
        }
        cnx.deconnecter();
    }

    @FXML
    private void validerIndemnite(ActionEvent event) throws IOException {
        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        if (libIndim.getValue() == null) {
            return;
        }
        if (valTauxInd.getValue().toString().equals("Taux")) {
            if (tauxInd.getText() == null) {
                return;
            }
            if (cnx.getInimnete(libIndim.getValue().toString()) == null) {
                cnx.insertIndemnite(new Indemnite(cnx.getAllInimnete().size() + 1, Integer.parseInt(tauxInd.getText()),
                        libIndim.getValue().toString()));
            } else {
                cnx.modifierTable("indemnite", "taux_ind", tauxInd.getText(), "libelle_ind='" + libIndim.getValue().toString() + "'");
            }

        } else if (valTauxInd.getValue().toString().equals("Valeure")) {
            if (valInd.getText() == null) {
                return;
            }
            if (cnx.getInimnete(libIndim.getValue().toString()) == null) {
                cnx.insertIndemnite(new Indemnite(cnx.getAllInimnete().size() + 1, Integer.parseInt(valInd.getText()),
                        libIndim.getValue().toString()));
            } else {
                cnx.modifierTable("indemnite", "taux_ind", valInd.getText(), "libelle_indimnite='" + libIndim.getValue().toString() + "'");
            }
        } else {
            return;
        }
        cnx.deconnecter();
    }

    @FXML
    private void validerRetenu(ActionEvent event) throws IOException {
        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        if (libRet.getValue() == null) {
            return;
        }
        if (valTauxRet.getValue().toString().equals("Taux")) {
            if (tauxRet.getText() == null) {
                return;
            }
            if (cnx.getRetenu(libRet.getValue().toString()) == null) {
                cnx.insertRetenu(new Retenu(cnx.getAllRetenu().size() + 1, libRet.getValue().toString(), Integer.parseInt(tauxRet.getText())
                ));
            } else {
                cnx.modifierTable("retenu", "taux_ret", tauxRet.getText(), "libelle_ret='" + libRet.getValue().toString() + "'");
            }

        } else if (valTauxRet.getValue().toString().equals("Valeure")) {
            if (valRet.getText() == null) {
                return;
            }
            if (cnx.getRetenu(libRet.getValue().toString()) == null) {
                cnx.insertRetenu(new Retenu(cnx.getAllRetenu().size() + 1, libRet.getValue().toString(), Integer.parseInt(valRet.getText())
                ));
            } else {
                cnx.modifierTable("retenu", "taux_ret", valRet.getText(), "libelle_ret='" + libRet.getValue().toString() + "'");
            }
        } else {
            return;
        }
        cnx.deconnecter();
    }

    @FXML
    private void validerPrime(ActionEvent event) throws IOException {
        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        if (libPrime.getValue() == null || durePrime.getText() == null || tauxPrime.getText() == null) {
            return;
        }
        if (cnx.getPrime(libPrime.getValue().toString()) == null) {
            cnx.insertPrime(new Prime(cnx.getAllPrime().size() + 1, Integer.parseInt(durePrime.getText()), Integer.parseInt(tauxPrime.getText()),
                    libPrime.getValue().toString()));
        } else {
            cnx.modifierTable("prime", "dure_mois_prm", durePrime.getText(), " libelle_prime='" + libPrime.getValue().toString() + "'");
            cnx.modifierTable("prime", "taux_prm", tauxPrime.getText(), " libelle_prime='" + libPrime.getValue().toString() + "'");
        }
        cnx.deconnecter();
    }

    @FXML
    private void validerBanque(ActionEvent event) throws IOException {
        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        if (nomBanque.getValue().toString() == null) {
            return;
        }
        cnx.insertBanque(new Banque(cnx.getAllBanque().size() + 1, nomBanque.getValue().toString()));
        cnx.deconnecter();
    }

    @FXML
    private void validerFonction(ActionEvent event) throws IOException {
        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        if (libFonct.getValue().toString() == null) {
            return;
        }
        cnx.insertFonction(new Fonction(cnx.getAllFonction().size() + 1, libFonct.getValue().toString()));
        cnx.deconnecter();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        remplirAccordions();
        pieChart.getData().add(new PieChart.Data("a", 50));
        pieChart.getData().add(new PieChart.Data("b", 50));
        pieChart.setLabelLineLength(10);
        pieChart.setLegendSide(Side.BOTTOM);


    }

    public void remplirAccordions() {
        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        fonctionnairePanes = new ArrayList<FonctionnairePane>();
        listesFonctionnaire = cnx.getAllFonctionnaire();

        for (Fonctionnaire fonctionnaire : listesFonctionnaire) {
            ArrayList<Fonction> listefonctions = cnx.getAllFonction(fonctionnaire.getNss());

            Banque banque = cnx.getBanque(fonctionnaire.getNss());

            FonctionnairePane pane = new FonctionnairePane(fonctionnaire, banque.getNomBanque(), listefonctions.get(listefonctions.size() - 1).getLibelleFonction());
            FonctionnairePane pane1 = new FonctionnairePane(fonctionnaire, banque.getNomBanque(), listefonctions.get(listefonctions.size() - 1).getLibelleFonction());
            FonctionnairePane pane2 = new FonctionnairePane(fonctionnaire, banque.getNomBanque(), listefonctions.get(listefonctions.size() - 1).getLibelleFonction());
            fonctionnairePanes.add(pane);
            fonctionnaireAccordion2.getPanes().add(pane);
            fonctionnaireAccordion1.getPanes().add(pane1);
            fonctionnaireAccordion3.getPanes().add(pane2);
        }
        accordion1 = fonctionnaireAccordion1;
        accordion2 = fonctionnaireAccordion2;
        accordion3 = fonctionnaireAccordion3;
        cnx.deconnecter();
        //fonctionnaireAccordion2=fonctionnaireAccordion1 ;
        // fonctionnaireAccordion3=fonctionnaireAccordion1 ;

    }

    public static void ajouterFonctionnaireAccordion(Fonctionnaire fonctionnaire, String libeleBanque, String libeleFonction) {
        listesFonctionnaire.add(fonctionnaire);
        FonctionnairePane pane1 = new FonctionnairePane(fonctionnaire, libeleBanque, libeleFonction);
        FonctionnairePane pane2 = new FonctionnairePane(fonctionnaire, libeleBanque, libeleFonction);
        FonctionnairePane pane3 = new FonctionnairePane(fonctionnaire, libeleBanque, libeleFonction);
        fonctionnairePanes.add(pane1);
        accordion1.getPanes().add(pane1);
        accordion2.getPanes().add(pane2);
        accordion3.getPanes().add(pane3);

    }
    public void configuration(){
                //la configuration
        ConnexionBdd cnx = new ConnexionBdd();
        cnx.connecter();
        // initialisation des combobox
        valTauxInd.getItems().add("Taux");
        valTauxInd.getItems().add("Valeure");
        valTauxRet.getItems().add("Taux");
        valTauxRet.getItems().add("Valeure");
        int i;
        for (i = 1; i <= 17; i++) {
            if (i < 10) {
                categorieConf.getItems().add("0" + i);
            } else {
                categorieConf.getItems().add("" + i);
            }
        }
        for (i = 0; i <= 12; i++) {
            if (i < 10) {
                echelonConf.getItems().add("0" + i);
            } else {
                echelonConf.getItems().add("" + i);
            }
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
    /*  public void listenPanesChanged() {
     tabPane.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
     @Override
     public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
     // do something...
     }
     });
     }*/
}
