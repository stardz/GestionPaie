/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionpaie;

import java.io.IOException;
import java.sql.Date;



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
        Salaire salaire=new Salaire(100, 20, 20, 20, 20);
        ConnexionBdd cnx=new ConnexionBdd();
        cnx.connecter();
        
        System.out.println(cnx.getAllSalaireDu(new Long("12354698"),Date.valueOf("1900-2-2")).get(0).getIdSalaire()+"");
        cnx.deconnecter();
        
    }
}
