/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpaie;

import java.math.BigInteger;
import java.time.LocalDate;
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

    private LongProperty nss;
    private StringProperty nomFonctionnaire;
    private StringProperty prenomFonctionnaire;
    private StringProperty sexe;
     private StringProperty situationFamiliale;
    private StringProperty dateRecrutement ;
    private IntegerProperty enfantCharg;
    private IntegerProperty enfantScolarise;
    private IntegerProperty enfantPlusDixAns;
    private LongProperty numMutuelle;
    private LongProperty numCompte;
    private StringProperty rue; 
    private StringProperty ville;
    private StringProperty status;

    public Fonctionnaire(Long nss, String nomFonctionnaire, String prenomFonctionnaire, String sexe, String situationFamiliale, String dateRecrutement, Integer enfantCharg, Integer enfantScolarise, Integer enfantPlusDixAns, Long numMutuelle, Long numCompte, String rue, String ville, String status) {
        this.nss = new SimpleLongProperty(nss);
        this.nomFonctionnaire = new SimpleStringProperty(nomFonctionnaire);
        this.prenomFonctionnaire =  new SimpleStringProperty(prenomFonctionnaire);
        this.sexe = new SimpleStringProperty(sexe) ;
        this.situationFamiliale =new SimpleStringProperty(situationFamiliale) ;
        this.dateRecrutement =new SimpleStringProperty(dateRecrutement) ;
        this.enfantCharg = new SimpleIntegerProperty(enfantCharg);
        this.enfantScolarise = new SimpleIntegerProperty(enfantScolarise);
        this.enfantPlusDixAns = new SimpleIntegerProperty(enfantPlusDixAns);
        this.numMutuelle = new SimpleLongProperty(numMutuelle);
        this.numCompte = new SimpleLongProperty(numCompte);
        this.rue = new SimpleStringProperty(rue) ;
        this.ville = new SimpleStringProperty(ville);
        this.status =new SimpleStringProperty(status) ;
    }
   
    
      
    
    
    

    

    public Fonctionnaire() {
        
        
    }

    public void setNss(Integer nss) {
        this.nss = new SimpleLongProperty(nss);
    }

    public void setNomFonctionnaire(String nomFonctionnaire) {
        this.nomFonctionnaire = new SimpleStringProperty(nomFonctionnaire);
    }

    public void setPrenomFonctionnaire(String prenomFonctionnaire) {
        this.prenomFonctionnaire = new SimpleStringProperty(prenomFonctionnaire);
    }

    public void setSexe(String sexe) {
        this.sexe = new SimpleStringProperty(sexe);
    }

    public void setStatus(String situationConjoint) {
        this.status = new SimpleStringProperty(situationConjoint);
    }

    public void setEnfantCharg(Integer enfantCharg) {
        this.enfantCharg = new SimpleIntegerProperty(enfantCharg);
    }

    public void setEnfantScolarise(Integer enfantScolarise) {
        this.enfantScolarise =new SimpleIntegerProperty(enfantScolarise) ;
    }

    public void setEnfantPlusDixAns(Integer enfantPlusDixAns) {
        this.enfantPlusDixAns = new SimpleIntegerProperty(enfantPlusDixAns);
    }

    public void setNumMutuelle(Long numMutuelle) {
        this.numMutuelle = new SimpleLongProperty(numMutuelle);
    }

    public void setNumCompte(Long numCompte) {
        this.numCompte = new SimpleLongProperty(numCompte);
    }

    public Long getNss() {
        return nss.getValue();
    }

    public String getNomFonctionnaire() {
        return nomFonctionnaire.getValue();
    }

    public String getPrenomFonctionnaire() {
        return prenomFonctionnaire.getValue();
    }

    public String getSexe() {
        return sexe.getValue();
    }

    public String getStatus() {
        return status.getValue();
    }

    public Integer getEnfantCharg() {
        return enfantCharg.getValue();
    }

    public Integer getEnfantScolarise() {
        return enfantScolarise.getValue();
    }

    public Integer getEnfantPlusDixAns() {
        return enfantPlusDixAns.getValue();
    }

    public Long getNumMutuelle() {
        return numMutuelle.getValue();
    }

    public Long getNumCompte() {
        return numCompte.getValue();
    }

    /**
     * @return the situationFamiliale
     */
    public String getSituationFamiliale() {
        return situationFamiliale.getValue();
    }

    /**
     * @param situationFamiliale the situationFamiliale to set
     */
    public void setSituationFamiliale(String situationFamiliale) {
        this.situationFamiliale = new SimpleStringProperty(situationFamiliale) ;
    }

    /**
     * @return the ville
     */
    public String getVile() {
        return ville.getValue();
    }

    /**
     * @param vile the ville to set
     */
    public void setVile(String vile) {
        this.ville = new SimpleStringProperty(vile);
    }

    /**
     * @return the rue
     */
    public String getRue() {
        return rue.getValue();
    }

    /**
     * @param rue the rue to set
     */
    public void setRue(String rue) {
        this.rue = new SimpleStringProperty(rue) ;
    }

    /**
     * @return the dateRecrutement
     */
    public String getDateRecrutement() {
        return dateRecrutement.getValue();
    }

    /**
     * @param dateRecrutement the dateRecrutement to set
     */
    public void setDateRecrutement(String dateRecrutement) {
        this.dateRecrutement = new SimpleStringProperty(dateRecrutement);
    }
 
    
}
