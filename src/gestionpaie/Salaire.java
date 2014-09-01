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
public class Salaire {
    private int idSalaire;
    private double salaire_base;
    private double salaire_poste;
    private double salaire_imposable;
    private double salaire_net;  

    public Salaire(int idSalaire, double salaire_base, double salaire_poste, double salaire_imposable, double salaire_net) {
        this.idSalaire = idSalaire;
        this.salaire_base = salaire_base;
        this.salaire_poste = salaire_poste;
        this.salaire_imposable = salaire_imposable;
        this.salaire_net = salaire_net;
    }

    public int getIdSalaire() {
        return idSalaire;
    }

    public void setIdSalaire(int idSalaire) {
        this.idSalaire = idSalaire;
    }

    public double getSalaire_base() {
        return salaire_base;
    }

    public void setSalaire_base(double salaire_base) {
        this.salaire_base = salaire_base;
    }

    public double getSalaire_poste() {
        return salaire_poste;
    }

    public void setSalaire_poste(double salaire_poste) {
        this.salaire_poste = salaire_poste;
    }

    public double getSalaire_imposable() {
        return salaire_imposable;
    }

    public void setSalaire_imposable(double salaire_imposable) {
        this.salaire_imposable = salaire_imposable;
    }

    public double getSalaire_net() {
        return salaire_net;
    }

    public void setSalaire_net(double salaire_net) {
        this.salaire_net = salaire_net;
    }
    

   
   
}
