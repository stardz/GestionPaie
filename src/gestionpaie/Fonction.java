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
    private String libelleFonction;

    public Fonction(String libelleFonction) {
        this.libelleFonction = libelleFonction;
    }

    public void setLibelleFonction(String libelleFonction) {
        this.libelleFonction = libelleFonction;
    }

    public String getLibelleFonction() {
        return libelleFonction;
    }
    public int getCodeFonction(){
        if(this.libelleFonction.equals("ING")){
           return 1; 
        }else if(this.libelleFonction.equals("TS")){
            return 2;
        }else if(this.libelleFonction.equals("T")){
            return 3;
        }else{
            return 4;
        }
    }
    
}
