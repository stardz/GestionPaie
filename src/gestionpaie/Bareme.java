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
    private int iep;
    private int icr;

    public Bareme(String categorieEchelon, int iep, int icr) {
        this.categorieEchelon = categorieEchelon;
        this.iep = iep;
        this.icr = icr;
    }

    public String getcategorieEchelon() {
        return categorieEchelon;
    }

    public int getIep() {
        return iep;
    }

    public int getIcr() {
        return icr;
    }

    public void setcategorieEchelon(String categorieEchelon) {
        this.categorieEchelon = categorieEchelon;
    }

    public void setIep(int iep) {
        this.iep = iep;
    }

    public void setIcr(int icr) {
        this.icr = icr;
    }
    public int getCategorie(){
        return Integer.parseInt(this.categorieEchelon.split("/")[0]) ;
    }
    public int getEchelon(){
        return Integer.parseInt(this.categorieEchelon.split("/")[1]) ;
    }
}
