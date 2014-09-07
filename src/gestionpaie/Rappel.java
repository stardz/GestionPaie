/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionpaie;

import java.util.Date;

/**
 *
 * @author Oop
 */
public class Rappel {
   
    private double valeurRappel;
    private Date debutRappel;

    public Rappel() {
    }

    public Rappel( double valeurRappel, Date debutRappel) {
       
        this.valeurRappel = valeurRappel;
        this.debutRappel = debutRappel;
    }

    

    public double getValeurRappel() {
        return valeurRappel;
    }

    public void setValeurRappel(double valeurRappel) {
        this.valeurRappel = valeurRappel;
    }

    public Date getDebutRappel() {
        return debutRappel;
    }

    public void setDebutRappel(Date debutRappel) {
        this.debutRappel = debutRappel;
    }
    
}
