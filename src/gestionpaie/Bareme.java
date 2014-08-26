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
public class Bareme {
    private String categorieEchelon;


    public Bareme(String categorieEchelon) {
        this.categorieEchelon = categorieEchelon;

    }


    public String getcategorieEchelon() {
        return categorieEchelon;
    }

    public void setcategorieEchelon(String categorieEchelon) {
        this.categorieEchelon = categorieEchelon;
    }

    public int getCategorie(){
        return Integer.parseInt(this.categorieEchelon.split("/")[0]) ;
    }
    public int getEchelon(){
        return Integer.parseInt(this.categorieEchelon.split("/")[1]) ;
    }
}
