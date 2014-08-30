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
    private int id_banque;
   private String nomBanque;

    public Banque(int id_banque, String nomBanque) {
        this.id_banque = id_banque;
        this.nomBanque = nomBanque;
    }

   

    public String getNomBanque() {
        return nomBanque;
    }

    public void setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    public int getId_banque() {
        return id_banque;
    }

    public void setId_banque(int id_banque) {
        this.id_banque = id_banque;
    }
   
}
