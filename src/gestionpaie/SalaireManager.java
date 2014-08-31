/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpaie;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import jxl.CellType;
import jxl.LabelCell;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Oop
 */
public class SalaireManager {
    
    static int grilleSalaire[][] = {
      /*1*/  {200, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120},
      /*2*/  {219, 11, 22, 33, 44, 55, 66, 77, 88, 99, 110, 120, 131},
      /*3*/  {240, 12, 24, 36, 48, 60, 72, 84, 96, 108, 120, 132, 144},
      /*4*/  {263, 13, 26, 39, 53, 66, 79, 92, 105, 118, 132, 145, 158},
      /*5*/  {288, 14, 29, 43, 58, 72, 86, 101, 115, 130, 144, 158, 173},
      /*6*/  {315, 16, 32, 47, 63, 79, 95, 110, 126, 142, 158, 173, 189},
      /*7*/  {348, 17, 35, 52, 70, 87, 104, 122, 139, 157, 174, 191, 209},
      /*8*/  {379, 19, 38, 57, 76, 95, 114, 133, 152, 171, 190, 208, 225},
      /*9*/  {418, 21, 42, 63, 84, 105, 125, 146, 167, 188, 209, 230, 251},
      /*10*/ {453, 23, 45, 68, 91, 113, 136, 159, 181, 204, 227, 249, 272},
      /*11*/ {498, 25, 50, 75, 100, 125, 149, 174, 199, 224, 249, 274, 299},
      /*12*/ {537, 27, 54, 81, 107, 134, 161, 188, 215, 242, 269, 295, 322},
      /*13*/ {578, 29, 58, 87, 116, 145, 173, 202, 231, 260, 289, 318, 347},
      /*14*/ {621, 31, 62, 93, 124, 155, 186, 217, 248, 279, 311, 342, 373},
      /*15*/ {666, 33, 67, 100, 133, 167, 200, 233, 266, 300, 333, 366, 400},
      /*16*/ {713, 36, 71, 107, 143, 178, 214, 250, 285, 321, 357, 392, 428},
      /*17*/  {762, 38, 76, 114, 152, 191, 229, 267, 305, 343, 381, 419, 457},};
    static Bareme baremTest=new Bareme("12/7",537,133);
    static Fonction fonctionTest=new Fonction("Ingénieur informatique");
    static double calculerPaie(Fonctionnaire fonctionnaire) {
            return getSalaireBrut(fonctionnaire)+getAllocation(fonctionnaire)-getSecSociale(fonctionnaire)-
                    getMutuelle(fonctionnaire)-getIrg(fonctionnaire);
    }

    static void imprimerFichePaie(Fonctionnaire fonctionnaire) throws IOException, BiffException, WriteException {
        
        Workbook existingWorkbook = Workbook.getWorkbook(new File("fichepaie.xls"));
        WritableWorkbook workbookCopy = Workbook.createWorkbook(new File("cpy.xls"), existingWorkbook);
        WritableSheet sheetToEdit = workbookCopy.getSheet("fp");
        WritableCell cell;
        Label l;
        // L'entet
        l = new Label(2,24, fonctionnaire.getNomFonctionnaire());
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
        l = new Label(6,24, fonctionnaire.getPrenomFonctionnaire());
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
        l = new Label(9,24, fonctionnaire.getNss()+"");
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
        l = new Label(2,25,SalaireManager.baremTest.getCategorie()+"");
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
         l = new Label(6,25,SalaireManager.baremTest.getEchelon()+"");
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
         l = new Label(2,26,SalaireManager.fonctionTest.getLibelleFonction());
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        // Les compasant de la paie
        l = new Label(9,31,getSalaireDeBase(fonctionnaire)+"");
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
        l = new Label(9,33,getIEP(fonctionnaire)+"");
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
        l = new Label(9,34,getIFC(fonctionnaire)+"");
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
        l = new Label(9,35,getIEP(fonctionnaire)+getIFC(fonctionnaire)+"");
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
        l = new Label(9,36,getSalaireDeBase(fonctionnaire)+getIEP(fonctionnaire)+getIFC(fonctionnaire)+"");
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
        l = new Label(9,38,getAllocation(fonctionnaire)+"");
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
        l = new Label(9,39,getSalaireBrut(fonctionnaire)+getAllocation(fonctionnaire)+"");
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
        l = new Label(9,41,getSecSociale(fonctionnaire)+"");
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
        l = new Label(9,42,getIrg(fonctionnaire)+"");
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
        l = new Label(9,43,getMutuelle(fonctionnaire)+"");
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
        l = new Label(9,44,getSecSociale(fonctionnaire)+getMutuelle(fonctionnaire)+getIrg(fonctionnaire)+"");
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
        l = new Label(8,48,calculerPaie(fonctionnaire)+"");
        cell = (WritableCell) l;
        sheetToEdit.addCell(cell);
        
  
        workbookCopy.write();
        workbookCopy.close();
        existingWorkbook.close();
       // Desktop.getDesktop().print(new File("cpy.xls"));
    }

    static void calculerRappel(Fonctionnaire fonctionnaire, Date dateDebut) {

    }

    static void imprimerFicheRappel(Fonctionnaire fonctionnaire, Date dateDebut) {

    }

    static double getSalaireDeBase(Fonctionnaire fonctionnaire) {
        // barem test <- le bareme du fonctionnaire
        ConnexionBdd connexion=new ConnexionBdd();
        connexion.connecter();
        
        connexion.deconnecter();
         return (grilleSalaire[baremTest.getCategorie()-1][baremTest.getEchelon()]+grilleSalaire[baremTest.getCategorie()-1][0])*45;

    }

    // Les indimnités

    static double getIEP(Fonctionnaire fonctionnaire) {
        
         // barem test <- le bareme du fonctionnaire
         return baremTest.getCategorie()*45;
        
    }

    static double getIFC(Fonctionnaire fonctionnaire) {
        
        /*
         Bareme bareme= get bareme du fonctionnaire;
         */
        if (baremTest.getCategorie() >= 1 && baremTest.getCategorie() <= 6) {
            return 3200;
        } else if (baremTest.getCategorie() >= 7 && baremTest.getCategorie() <= 8) {
            return 2500;
        } else if (baremTest.getCategorie() >= 9 && baremTest.getCategorie() <= 10) {
            return 2000;
        } else {
            return 1500;
        }
    }

    static double getSalaireBrut(Fonctionnaire fonctionnaire) {
        // sb + les indimnités
        return getSalaireDeBase(fonctionnaire) + getIEP(fonctionnaire) + getIFC(fonctionnaire);
    }

    // Les allocations

    static double getAllocation(Fonctionnaire fonctionnaire) {
        if (getSalaireBrut(fonctionnaire) > 15000) {
            return fonctionnaire.getEnfantCharg() * 300;
        } else if (fonctionnaire.getEnfantCharg() <= 5) {
            return fonctionnaire.getEnfantCharg() * 600;
        } else {
            return ((5 * 600) + 300 * (fonctionnaire.getEnfantCharg() - 5));
        }
    }

    // Les Retenus

    static double getMutuelle(Fonctionnaire fonctionnaire) {
        return getSalaireBrut(fonctionnaire) * 0.01;
    }

    static double getSecSociale(Fonctionnaire fonctionnaire) {
        return getSalaireBrut(fonctionnaire) * 0.09;
    }

    static double getIrg(Fonctionnaire fonctionnaire) {
        if (getSalaireBrut(fonctionnaire) >= 15000 && getSalaireBrut(fonctionnaire) < 22500) {
            return (getSalaireBrut(fonctionnaire) * 0.2 - 3000);
        } else if (getSalaireBrut(fonctionnaire) >= 22500 && getSalaireBrut(fonctionnaire) < 28750) {
            return (getSalaireBrut(fonctionnaire) * 0.12 - 1200);
        } else if (getSalaireBrut(fonctionnaire) >= 28750 && getSalaireBrut(fonctionnaire) < 30000) {
            return (getSalaireBrut(fonctionnaire) * 0.2 - 3500);
        } else if (getSalaireBrut(fonctionnaire) >= 30000 && getSalaireBrut(fonctionnaire) < 120000) {
            System.out.println("======================================");
            return (getSalaireBrut(fonctionnaire) * 0.30 - 6500);
            
        } else {
            return (getSalaireBrut(fonctionnaire) * 0.35 - 12500);
        }

    }
}
