package gestionpaie;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oop
 */
public class PrimeDeRendement extends Prime{
    private int tauxPrimeRendement;
    public PrimeDeRendement(Date datePrime,int tauxPrimeRendement) {
        super(datePrime);
        this.tauxPrimeRendement=tauxPrimeRendement;
    }

    public int getTauxPrimeScolarite() {
        return tauxPrimeRendement;
    }

    public void setTauxPrimeScolarite(int tauxPrimeScolarite) {
        this.tauxPrimeRendement = tauxPrimeScolarite;
    }
}
