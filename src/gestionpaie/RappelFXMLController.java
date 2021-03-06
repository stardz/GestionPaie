/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpaie;

import static gestionpaie.MenuPrincipaleFXMLController.accordion3;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class RappelFXMLController implements Initializable {
    Rappel rappel ;
    @FXML
    private TextField nss;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField numCompte;
    @FXML
    private TextField debutRappel;
    @FXML
    private TextField valeurRappel;
    private Fonctionnaire f ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        int i = 0;
        while (i < accordion3.getPanes().size() && !accordion3.getPanes().get(i).isExpanded()) {
            i++;
        }
        if (i < accordion3.getPanes().size()) {
            ConnexionBdd cnx = new ConnexionBdd();
            cnx.connecter();
            f=MenuPrincipaleFXMLController.fonctionnairePanes.get(i).getFonctionnaire() ;
            rappel= SalaireManager.calculerRappel(f, Date.valueOf(f.getDateRecrutement()), cnx) ;
            nss.setText(f.getNss().toString());
            nom.setText(f.getNomFonctionnaire());
            prenom.setText(f.getPrenomFonctionnaire());
            numCompte.setText(f.getNumCompte().toString());
            debutRappel.setText(rappel.getDebutRappel().toString());
            valeurRappel.setText(((Double)rappel.getValeurRappel()).toString());

            cnx.deconnecter();
        }

        // TODO
    }
        @FXML
    private void annulerOnAction(ActionEvent event) throws IOException {
        Main.primaryStage2.hide();

    }
        @FXML
    private void confirmerOnAction(ActionEvent event) throws IOException, BiffException, WriteException {
        ConnexionBdd cnx=new ConnexionBdd();
        cnx.connecter();
        SalaireManager.imprimerFicheRappel(f,
                rappel,
                cnx);
        cnx.deconnecter();
    }

}
