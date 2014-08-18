/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionpaie;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Oop
 */
public class Fonctionnaire {
    private IntegerProperty nss;
    private StringProperty nomFonctionnaire;
    private StringProperty prenomFonctionnaire;
    private StringProperty sexe;
    private StringProperty situationConjoint;
    private IntegerProperty enfantCharg;
    private IntegerProperty enfantScolarise;
    private IntegerProperty enfantPlusDixAns;
    private LongProperty numMutuelle;
    private LongProperty numCompte;

    public Fonctionnaire(Integer nss, String nomFonctionnaire, String prenomFonctionnaire, String sexe, String situationConjoint, Integer enfantCharg, Integer enfantScolarise, Integer enfantPlusDixAns, Long numMutuelle, Long numCompte) {
        this.nss = new SimpleIntegerProperty(nss);
        this.nomFonctionnaire = new SimpleStringProperty(nomFonctionnaire);
        this.prenomFonctionnaire = new SimpleStringProperty(prenomFonctionnaire);
        this.sexe =new SimpleStringProperty(sexe) ;
        this.situationConjoint =new SimpleStringProperty(situationConjoint) ;
        
        this.enfantCharg = new SimpleIntegerProperty(enfantCharg);
        this.enfantScolarise = new SimpleIntegerProperty(enfantScolarise);
        this.enfantPlusDixAns = new SimpleIntegerProperty(enfantPlusDixAns);
        this.numMutuelle = new SimpleLongProperty(numMutuelle);
        this.numCompte =new SimpleLongProperty(numCompte) ;
    }
    
    
    
}
