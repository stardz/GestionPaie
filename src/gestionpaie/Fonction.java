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
public class Fonction {
    private int idFonction;
    private String libelleFonction;

    public Fonction(int idFonction, String libelleFonction) {
        this.idFonction = idFonction;
        this.libelleFonction = libelleFonction;
    }

    public int getIdFonction() {
        return idFonction;
    }

    public void setIdFonction(int idFonction) {
        this.idFonction = idFonction;
    }

    public String getLibelleFonction() {
        return libelleFonction;
    }

    public void setLibelleFonction(String libelleFonction) {
        this.libelleFonction = libelleFonction;
    }

    
}
