/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionpaie;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 *
 * @author Oop
 */
public class TestConsol {
    public static void main(String[] args) throws IOException, BiffException, WriteException{
        
      //  Fonctionnaire fonctionnaire =new Fonctionnaire(new Long("12354698"), "Lattali", "Ahmed", "MASCULIN", 
     //           "Celebataire", "Celebatiare", "Setif", "Hdhab", 5, 3,2 ,new Long("13625"),new Long("56985"),"2001-10-14");
        // SalaireManager.imprimerFichePaie(fonctionnaire);
        // Desktop.getDesktop().print(new File("fichepaie.xls"));
       
        ConnexionBdd cnx=new ConnexionBdd();
        cnx.connecter();
        /*
        Salaire salaire=SalaireManager.calculerSalaire(cnx.getFonctionnaire(new Long("12354698")), cnx);
        salaire.printSalaire();*/
        //System.out.println("=========="+cnx.nbrFonctPar("libelle_fonction", "technicien"));
       SalaireManager.imprimerFichePaie(cnx.getFonctionnaire(new Long("12354698")),
               SalaireManager.calculerSalaire(cnx.getFonctionnaire(new Long("12354698")), cnx), cnx);
         
        cnx.deconnecter();
        
    }
}
