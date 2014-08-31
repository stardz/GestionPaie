/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionpaie;

/**
 *
 * @author Oop
 */
public class Indemnite {
   private int id_indemnite;
   private int taux_indemnite;
   private String libelle_indemnite;

    public Indemnite(int id_indemnite, int taux_indemnite, String libelle_indemnite) {
        this.id_indemnite = id_indemnite;
        this.taux_indemnite = taux_indemnite;
        this.libelle_indemnite = libelle_indemnite;
    }

    public int getId_indemnite() {
        return id_indemnite;
    }

    public void setId_indemnite(int id_indemnite) {
        this.id_indemnite = id_indemnite;
    }

    public int getTaux_indemnite() {
        return taux_indemnite;
    }

    public void setTaux_indemnite(int taux_indemnite) {
        this.taux_indemnite = taux_indemnite;
    }

    public String getLibelle_indemnite() {
        return libelle_indemnite;
    }

    public void setLibelle_indemnite(String libelle_indemnite) {
        this.libelle_indemnite = libelle_indemnite;
    }

   
   
}
