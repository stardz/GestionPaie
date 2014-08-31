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
public class Retenu {
    private int idRetenu;
    private String libelleRetenu;
    private int tauxRetenu;

    public Retenu(int idRetenu, String libelleRetenu, int tauxRetenu) {
        this.idRetenu = idRetenu;
        this.libelleRetenu = libelleRetenu;
        this.tauxRetenu = tauxRetenu;
    }

    public int getIdRetenu() {
        return idRetenu;
    }

    public void setIdRetenu(int idRetenu) {
        this.idRetenu = idRetenu;
    }

    

    public String getLibelleRetenu() {
        return libelleRetenu;
    }

    public int getTauxRetenu() {
        return tauxRetenu;
    }

    public void setLibelleRetenu(String libelleRetenu) {
        this.libelleRetenu = libelleRetenu;
    }

    public void setTauxRetenu(int tauxRetenu) {
        this.tauxRetenu = tauxRetenu;
    }
    
}
