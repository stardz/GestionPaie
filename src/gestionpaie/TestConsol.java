/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionpaie;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 *
 * @author Oop
 */
public class TestConsol {
    public static void main(String[] args) throws IOException, BiffException, WriteException{
        
        Fonctionnaire fonctionnaire =new Fonctionnaire(12354698, "Lattali", "Ahmed", "MASCULIN", 
                "Celebataire", "Celebatiare", "Setif", "Hdhab", 5, 3,2 ,new Long("13625"),new Long("56985"));
        SalaireManager.imprimerFichePaie(fonctionnaire);
        // Desktop.getDesktop().print(new File("fichepaie.xls"));
    }
}
