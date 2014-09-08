/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpaie;

import static gestionpaie.MenuPrincipaleFXMLController.accordion2;
import java.io.IOException;
import java.net.URL;
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
public class PaiementMensuelleFXMLController implements Initializable {
      Salaire salaire;
    @FXML
    private TextField nss;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField numCompte;
    @FXML
    private TextField salaireBase ;
    @FXML
    private TextField salaireImpose;
    @FXML
    private TextField salairePost;
    @FXML
    private TextField salaireNet;
    private Fonctionnaire f ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        int i = 0;
        while (i < accordion2.getPanes().size() && !accordion2.getPanes().get(i).isExpanded()) {
            i++;
        }
        if (i < accordion2.getPanes().size()) {
            ConnexionBdd cnx = new ConnexionBdd();
            cnx.connecter();
            f=MenuPrincipaleFXMLController.fonctionnairePanes.get(i).getFonctionnaire() ;
            salaire = SalaireManager.calculerSalaire(f, cnx);
            nss.setText(f.getNss().toString());
            nom.setText(f.getNomFonctionnaire());
            prenom.setText(f.getPrenomFonctionnaire());
            numCompte.setText(f.getNumCompte().toString());
            salaireBase.setText(((Double)salaire.getSalaire_base()).toString());
            salairePost.setText(((Double)salaire.getSalaire_poste()).toString());
            salaireImpose.setText(((Double)salaire.getSalaire_imposable()).toString());
            salaireNet.setText(((Double)salaire.getSalaire_net()).toString());
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
        SalaireManager.imprimerFichePaie(f,
                salaire,
                cnx);
        cnx.deconnecter();
    }

}
