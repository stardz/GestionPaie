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
   private String natureIndemnite;
   private int tauxIndemnite;

    public Indemnite(String natureIndemnite, int tauxIndemnite) {
        this.natureIndemnite = natureIndemnite;
        this.tauxIndemnite = tauxIndemnite;
    }

    public String getNatureIndemnite() {
        return natureIndemnite;
    }

    public int getTauxIndemnite() {
        return tauxIndemnite;
    }

    public void setNatureIndemnite(String natureIndemnite) {
        this.natureIndemnite = natureIndemnite;
    }

    public void setTauxIndemnite(int tauxIndemnite) {
        this.tauxIndemnite = tauxIndemnite;
    }
   
}
