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
    private int indiceCategorie;
    private int indiceEchelon;

    public Bareme(String categorieEchelon, int indiceCategorie, int indiceEchelon) {
        this.categorieEchelon = categorieEchelon;
        this.indiceCategorie = indiceCategorie;
        this.indiceEchelon = indiceEchelon;
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
    public double getSalaireDeBase(){
        return (this.indiceCategorie+this.indiceEchelon)*45;
    }

    public int getIndiceCategorie() {
        return indiceCategorie;
    }

    public int getIndiceEchelon() {
        return indiceEchelon;
    }
    
}
