/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionpaie;

import java.awt.print.Pageable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oop
 */
public class SalaireManager {
    int grilleSalaire[][]={
        {200,10,20,30,40,50,60,70,80,90,100,110,120},
        {219,11,22,33,44,55,66,77,88,99,110,120,131},
        {240,12,24,36,48,60,72,84,96,108,120,132,144},
        {263,13,26,39,53,66,79,92,105,118,132,145,158},
        {288,14,29,43,58,72,86,101,115,130,144,158,173},
        {315,16,32,47,63,79,95,110,126,142,158,173,189},
        {348,17,35,52,70,87,104,122,139,157,174,191,209},
        {379,19,38,57,76,95,114,133,152,171,190,208,225},
        {418,21,42,63,84,105,125,146,167,188,209,230,251},
        {453,23,45,68,91,113,136,159,181,204,227,249,272},
        {498,25,50,75,100,125,149,174,199,224,249,274,299},
        {537,27,54,81,107,134,161,188,215,242,269,295,322},
        {578,29,58,87,116,145,173,202,231,260,289,318,347},
        {621,31,62,93,124,155,186,217,248,279,311,342,373},
        {666,33,67,100,133,167,200,233,266,300,333,366,400},
        {713,36,71,107,143,178,214,250,285,321,357,392,428},
        {762,38,76,114,152,191,229,267,305,343,381,419,457},      
    };
    static void calculerPaie(Fonctionnaire fonctionnaire){
        
    }
    static void imprimerFichePaie(Fonctionnaire fonctionnaire){
        
    }
    static void calculerRappel(Fonctionnaire fonctionnaire,Date dateDebut){
        
    }
    static void imprimerFicheRappel(Fonctionnaire fonctionnaire,Date dateDebut){
        
    }
    public double getSalaireDeBase(Fonctionnaire fonctionnaire){
        /*
        Bareme bareme= get bareme du fonctionnaire;
        return (grilleSalaire[bareme.getCategorie()-1][bareme.getEchelon()]+grilleSalaire[bareme.getCategorie()-1][0])*45;
        */
        
        return 0;
    }
    // Les indimnités
    public double getIEP(Fonctionnaire fonctionnaire){
        /*
        Bareme bareme= get bareme du fonctionnaire;
        return bareme.getCategorie*45;
        */
        return 0;
    }
    public double getIFC(Fonctionnaire fonctionnaire){
        Bareme bareme = null;
        /*
        Bareme bareme= get bareme du fonctionnaire;
        */
        if(bareme.getCategorie()>=1&&bareme.getCategorie()<=6){
            return 3200;          
        }else if(bareme.getCategorie()>=7&&bareme.getCategorie()<=8){
            return 2500;            
        }else if(bareme.getCategorie()>=9&&bareme.getCategorie()<=10){
            return 2000;
        }else{
            return 1500;
        }
    }
    public double getSalaireBrut(Fonctionnaire fonctionnaire){
        // sb + les indimnités
        return this.getSalaireDeBase(fonctionnaire)+this.getIEP(fonctionnaire)+this.getIFC(fonctionnaire);
    }
    // Les allocations
    public double getAllocation(Fonctionnaire fonctionnaire){
        if(this.getSalaireBrut(fonctionnaire)>15000){
            return fonctionnaire.getEnfantCharg()*300;
        }else if(fonctionnaire.getEnfantCharg()<=5){
            return fonctionnaire.getEnfantCharg()*600;
        }else{
            return ((5*600)+300*(fonctionnaire.getEnfantCharg()-5));
        }
    }
    // Les Retenus
    public double getMutuelle(Fonctionnaire fonctionnaire){
        return this.getSalaireBrut(fonctionnaire)*0.01;
    }
    
    public double getSecSociale(Fonctionnaire fonctionnaire){
        return this.getSalaireBrut(fonctionnaire)*0.09;
    }
    public double getIrg(Fonctionnaire fonctionnaire){
        if(this.getSalaireBrut(fonctionnaire)>=15000&&this.getSalaireBrut(fonctionnaire)<22500){
            return this.getSalaireBrut(fonctionnaire)*0.2 -3000;
        }else if(this.getSalaireBrut(fonctionnaire)>=22500&&this.getSalaireBrut(fonctionnaire)<28750){
            return this.getSalaireBrut(fonctionnaire)*0.12 -1200;
        }else if(this.getSalaireBrut(fonctionnaire)>=28750&&this.getSalaireBrut(fonctionnaire)<30000){
            return this.getSalaireBrut(fonctionnaire)*0.2 -3500;
        }else if(this.getSalaireBrut(fonctionnaire)>=30000&&this.getSalaireBrut(fonctionnaire)<120000){
            return this.getSalaireBrut(fonctionnaire)*0.30 -6500;
        }else {
            return this.getSalaireBrut(fonctionnaire)*0.35 -12500;
        }

    }
}
