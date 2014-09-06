/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionpaie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private ArrayList<HashMap<String,Double>> indemniteVal;
    private ArrayList<HashMap<String,Double>> retenuVal;
    

    public Salaire(int idSalaire, double salaire_base, double salaire_poste, double salaire_imposable, double salaire_net) {
        this.idSalaire = idSalaire;
        this.salaire_base = salaire_base;
        this.salaire_poste = salaire_poste;
        this.salaire_imposable = salaire_imposable;
        this.salaire_net = salaire_net;
    }
    @SuppressWarnings("empty-statement")
   public Salaire(){
       int tab[];
       indemniteVal=new ArrayList<HashMap<String,Double>>();
       indemniteVal.add(new HashMap<String,Double>());
       indemniteVal.add(new HashMap<String,Double>());
       indemniteVal.add(new HashMap<String,Double>());
       retenuVal=new ArrayList<HashMap<String,Double>>();
       retenuVal.add(new HashMap<String,Double>());
       retenuVal.add(new HashMap<String,Double>());
       retenuVal.add(new HashMap<String,Double>());
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

    public ArrayList<HashMap<String, Double>> getIndemniteVal() {
        return indemniteVal;
    }

    public void setIndemniteVal(ArrayList<HashMap<String, Double>> indemniteVal) {
        this.indemniteVal = indemniteVal;
    }

    public ArrayList<HashMap<String, Double>> getRetenuVal() {
        return retenuVal;
    }

    public void setRetenuVal(ArrayList<HashMap<String, Double>> retenuVal) {
        this.retenuVal = retenuVal;
    }
    public void printSalaire(){
        System.out.println("==================== Salaire =====================");
        System.out.println("\n Salaire de base = "+salaire_base);
        System.out.println(""+indemniteVal.get(0).toString());
        System.out.println("\n Salaire de poste = "+salaire_poste);
        System.out.println(""+indemniteVal.get(1).toString());
        System.out.println(""+retenuVal.get(0).toString());
        System.out.println("\n Salaire imposable = "+salaire_imposable);
        System.out.println(""+indemniteVal.get(2).toString());
        System.out.println(""+retenuVal.get(1).toString());
        System.out.println("\n Salaire net = "+salaire_net);
    }
    

   
   
}
