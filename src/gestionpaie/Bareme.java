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
    private int indiceMediane;
    private int iep;
    private int icr;

    public Bareme(int indiceMediane, int iep, int icr) {
        this.indiceMediane = indiceMediane;
        this.iep = iep;
        this.icr = icr;
    }

    public int getIndiceMediane() {
        return indiceMediane;
    }

    public int getIep() {
        return iep;
    }

    public int getIcr() {
        return icr;
    }

    public void setIndiceMediane(int indiceMediane) {
        this.indiceMediane = indiceMediane;
    }

    public void setIep(int iep) {
        this.iep = iep;
    }

    public void setIcr(int icr) {
        this.icr = icr;
    }
    
}
