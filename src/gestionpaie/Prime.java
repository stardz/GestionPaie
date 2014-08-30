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
public class Prime {
   private int idPrime;
   private int tauxPrime;
   private int durePrime;

    public Prime(int idPrime, int tauxPrime, int durePrime) {
        this.idPrime = idPrime;
        this.tauxPrime = tauxPrime;
        this.durePrime = durePrime;
    }

    public int getIdPrime() {
        return idPrime;
    }

    public void setIdPrime(int idPrime) {
        this.idPrime = idPrime;
    }

    public int getTauxPrime() {
        return tauxPrime;
    }

    public void setTauxPrime(int tauxPrime) {
        this.tauxPrime = tauxPrime;
    }

    public int getDurePrime() {
        return durePrime;
    }

    public void setDurePrime(int durePrime) {
        this.durePrime = durePrime;
    }
   
    
}
