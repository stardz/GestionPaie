/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpaie;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class MenuPrincipaleFXMLController implements Initializable {

    
     ObservableList<Ligne> data = FXCollections.observableArrayList() ;
    @FXML
    private TableView<String[]> grid;

    private TableColumn col1;

    private TableColumn col2;

    private TableColumn col3;

    private TableColumn col4;

    private TableColumn col5;

    private TableColumn col6;

    private TableColumn col7;

    private TableColumn col8;

    private TableColumn col9;

    private TableColumn col10;

    private TableColumn col11;

    private TableColumn col12;

    private TableColumn col13;

    String[][] grilleSalaire = {
        {"200", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "110", "120"},
        {"219", "11", "22", "33", "44", "55", "66", "77", "88", "99", "110", "120", "131"},
        {"240", "12", "24", "36", "48", "60", "72", "84", "96", "108", "120", "132", "144"},
        {"263", "13", "26", "39", "53", "66", "79", "92", "105", "118", "132", "145", "158"},
        {"288", "14", "29", "43", "58", "72", "86", "101", "115", "130", "144", "158", "173"},
        {"315", "16", "32", "47", "63", "79", "95", "110", "126", "142", "158", "173", "189"},
        {"348", "17", "35", "52", "70", "87", "104", "122", "139", "157", "174", "191", "209"},
        {"379", "19", "38", "57", "76", "95", "114", "133", "152", "171", "190", "208", "225"},
        {"418", "21", "42", "63", "84", "105", "125", "146", "167", "188", "209", "230", "251"},
        {"453", "23", "45", "68", "91", "113", "136", "159", "181", "204", "227", "249", "272"},
        {"498", "25", "50", "75", "100", "125", "149", "174", "199", "224", "249", "274", "299"},
        {"537", "27", "54", "81", "107", "134", "161", "188", "215", "242", "269", "295", "322"},
        {"578", "29", "58", "87", "116", "145", "173", "202", "231", "260", "289", "318", "347"},
        {"621", "31", "62", "93", "124", "155", "186", "217", "248", "279", "311", "342", "373"},
        {"666", "33", "67", "100", "133", "167", "200", "233", "266", "300", "333", "366", "400"},
        {"713", "36", "71", "107", "143", "178", "214", "250", "285", "321", "357", "392", "428"},
        {"762", "38", "76", "114", "152", "191", "229", "267", "305", "343", "381", "419", "457"},};

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

    }

    @FXML
    private void modifierGrilleOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    private void annulerGrilleOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    private void validerGrilleOnAction(ActionEvent event) throws IOException {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

            afficherGrilleSalaire();

    }
    public void afficherGrilleSalaire(){
         
        ObservableList<String[]> data1 = FXCollections.observableArrayList();
        data1.addAll(Arrays.asList(grilleSalaire));
        
                for (int i = 0; i < grilleSalaire[0].length; i++) {
            TableColumn tc = new TableColumn(grilleSalaire[0][i]);
            final int colNo = i;
            tc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                    return new SimpleStringProperty((p.getValue()[colNo]));
                }
            });
            tc.setPrefWidth(50);
            grid.getColumns().add(tc);
            
        }
            grid.setItems(data1);
        
        
    }

}
