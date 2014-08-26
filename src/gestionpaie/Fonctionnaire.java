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
    private StringProperty status;
    private StringProperty situationFamiliale;
    private StringProperty ville;
    private StringProperty rue;
    
    private IntegerProperty enfantCharg;
    private IntegerProperty enfantScolarise;
    private IntegerProperty enfantPlusDixAns;
    private LongProperty numMutuelle;
    private LongProperty numCompte;

    public Fonctionnaire(Integer nss, String nomFonctionnaire, String prenomFonctionnaire, String sexe, String situationConjoint,String situationFamiliale,String ville,String rue, Integer enfantCharg, Integer enfantScolarise, Integer enfantPlusDixAns, Long numMutuelle, Long numCompte) {
        this.nss = new SimpleIntegerProperty(nss);
        this.nomFonctionnaire = new SimpleStringProperty(nomFonctionnaire);
        this.prenomFonctionnaire = new SimpleStringProperty(prenomFonctionnaire);
        this.sexe = new SimpleStringProperty(sexe);
        this.status = new SimpleStringProperty(situationConjoint);
        this.situationFamiliale = new SimpleStringProperty(situationFamiliale);
        this.rue = new SimpleStringProperty(rue);
        this.ville = new SimpleStringProperty(ville);

        this.enfantCharg = new SimpleIntegerProperty(enfantCharg);
        this.enfantScolarise = new SimpleIntegerProperty(enfantScolarise);
        this.enfantPlusDixAns = new SimpleIntegerProperty(enfantPlusDixAns);
        this.numMutuelle = new SimpleLongProperty(numMutuelle);
        this.numCompte = new SimpleLongProperty(numCompte);
    }

    public Fonctionnaire() {
        
        
    }

    public void setNss(Integer nss) {
        this.nss = new SimpleIntegerProperty(nss);
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

    public Integer getNss() {
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
 
    
}
