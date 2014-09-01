/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionpaie;

import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Ahmed
 */
public class FonctionnaireInfoGrid  extends VBox{

    private Label nssLabel;
    private Label nomLabel;
    private Label prenomLabel;
    private Label adresseVilleLabel;
    private Label situationFamilialeLabel ;
    
    private Label fonctionLabel ;
    private Label statusLabel ;
    private Label dateDerecrutementLabel ;
    private Label codeBanqueLabel ;
    private Label numCompteLabel ;

    private Label nssValue;
    private Label nomValue;
    private Label prenomValue;
    private Label adresseVilleValue;
    private Label situationFamilialeValue ;
    
    private Label statusValue ;
    private Label fonctionValue ;
    private Label dateDerecrutementValue ;
    private Label codeBanqueValue ;
    private Label numCompteValue ;
    
    private Fonctionnaire fonctionnaire;
    private GridPane grid;
    private GridPane grid2;
    
    
    public FonctionnaireInfoGrid(Fonctionnaire f){
        
    super(2) ;    
    this.fonctionnaire = f;
    
    Rectangle topRectangle = new Rectangle(598, 26, Color.BEIGE);
    topRectangle.setStroke(Color.BLACK);
    this.grid = new GridPane();
    this.grid2 = new GridPane();
   // this.grid.setHgap(20);
    //this.grid.setVgap(5);
    ///*************************************************************************
    this.nssLabel = new Label("NSS");
    this.nomLabel = new Label("Nom");
    this.prenomLabel = new Label("Prénom");
    this.adresseVilleLabel = new Label("Adresse");
    this.situationFamilialeLabel= new Label("Situation familiale");
    ///*************************************************************************
    this.fonctionLabel =new Label("Fonction") ;
    this.statusLabel =new Label("Status") ;
    this.dateDerecrutementLabel =new Label("Date de recrutement") ;
    this.codeBanqueLabel =new Label(" Banque") ;
    this.numCompteLabel =new Label("num Compte") ;
    ///*************************************************************************
    ///*************************************************************************
    this.nssValue = new Label(f.getNss().toString());
    this.nomValue = new Label(f.getNomFonctionnaire());
    this.prenomValue = new Label(f.getPrenomFonctionnaire());
    this.adresseVilleValue = new Label(f.getVile());
    this.situationFamilialeValue= new Label(f.getSituationFamiliale());
    ///*************************************************************************
    this.fonctionValue =new Label("Fonction") ;
    this.statusValue =new Label(f.getStatus()) ;
    this.dateDerecrutementValue =new Label(f.getDateRecrutement()) ;
    this.codeBanqueValue =new Label(" Banque") ;
    this.numCompteValue =new Label(f.getNumCompte().toString()) ;
    ///*************************************************************************
    this.grid.add(nssLabel, 0, 1);
    this.grid.add(nomLabel, 0, 2);
    this.grid.add(prenomLabel, 0, 3);
    this.grid.add(adresseVilleLabel, 0, 4);
    this.grid.add(situationFamilialeLabel, 0, 5);
    this.grid.add(nssValue, 1, 1);
    this.grid.add(nomValue, 1, 2);
    this.grid.add(prenomValue, 1, 3);
    this.grid.add(adresseVilleValue, 1, 4);
    this.grid.add(situationFamilialeValue, 1, 5);
  
    this.grid2.add(fonctionLabel, 0, 1);
    this.grid2.add(statusLabel, 2, 2);
    this.grid2.add(dateDerecrutementLabel, 0, 3);
    this.grid2.add(codeBanqueLabel, 0, 4);
    this.grid2.add(numCompteLabel, 0, 5);
    
    this.grid2.add(fonctionValue, 1, 1);
    this.grid2.add(statusValue, 1, 2);
    this.grid2.add(dateDerecrutementValue, 1, 3);
    this.grid2.add(codeBanqueValue,1, 4);
    this.grid2.add(numCompteValue, 1, 5);
    ///************************************************************************
    this.grid.setMaxHeight(60);
    this.grid2.setMaxHeight(60);
    SplitPane p=new SplitPane() ;
    p.getItems().addAll(grid,grid2) ;
    HBox hbox = new HBox(40);
    hbox.setStyle("-fx-translate-x:30px");
    
    Label titreFiche= new Label("Fiche d'informations");
    StackPane stack = new StackPane();
    stack.getChildren().addAll(topRectangle, titreFiche);
    this.getChildren().addAll(stack, p);
    }

    /**
     * @return the fonctionnaire
     */
    public Fonctionnaire getFonctionnaire() {
        return fonctionnaire;
    }
    
    
}