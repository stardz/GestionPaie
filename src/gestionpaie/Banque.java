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
public class Banque {
   private String nomBanque;

    public Banque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    public String getNomBanque() {
        return nomBanque;
    }

    public void setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }
   
}
