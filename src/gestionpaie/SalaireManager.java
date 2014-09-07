/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpaie;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    /* static int grilleSalaire[][] = {
     /*1  {200, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120},
     /*2  {219, 11, 22, 33, 44, 55, 66, 77, 88, 99, 110, 120, 131},
     /*3  {240, 12, 24, 36, 48, 60, 72, 84, 96, 108, 120, 132, 144},
     /*4  {263, 13, 26, 39, 53, 66, 79, 92, 105, 118, 132, 145, 158},
     /*5  {288, 14, 29, 43, 58, 72, 86, 101, 115, 130, 144, 158, 173},
     /*6  {315, 16, 32, 47, 63, 79, 95, 110, 126, 142, 158, 173, 189},
     /*7  {348, 17, 35, 52, 70, 87, 104, 122, 139, 157, 174, 191, 209},
     /*8  {379, 19, 38, 57, 76, 95, 114, 133, 152, 171, 190, 208, 225},
     /*9  {418, 21, 42, 63, 84, 105, 125, 146, 167, 188, 209, 230, 251},
     /*10 {453, 23, 45, 68, 91, 113, 136, 159, 181, 204, 227, 249, 272},
     /*11 {498, 25, 50, 75, 100, 125, 149, 174, 199, 224, 249, 274, 299},
     /*12 {537, 27, 54, 81, 107, 134, 161, 188, 215, 242, 269, 295, 322},
     /*13 {578, 29, 58, 87, 116, 145, 173, 202, 231, 260, 289, 318, 347},
     /*14 {621, 31, 62, 93, 124, 155, 186, 217, 248, 279, 311, 342, 373},
     /*15 {666, 33, 67, 100, 133, 167, 200, 233, 266, 300, 333, 366, 400},
     /*16 {713, 36, 71, 107, 143, 178, 214, 250, 285, 321, 357, 392, 428},
     /*17  {762, 38, 76, 114, 152, 191, 229, 267, 305, 343, 381, 419, 457},};*/
  //  static Bareme baremTest=new Bareme("12/7",537,133);
    // static Fonction fonctionTest=new Fonction(1,"Ingénieur informatique");
    static Salaire calculerSalaire(Fonctionnaire fonctionnaire, ConnexionBdd cnx) {
        Salaire salaire = new Salaire();
        double somme = 0;
        double diff = 0;
        //     salaire.setIdSalaire();
        salaire.setSalaire_base(getSalaireDeBase(fonctionnaire.getNss(), cnx));
        ArrayList<Retenu> retenuList;
        // Le calcul du salaire du poste
        ArrayList<Indemnite> indemniteList = cnx.getAllInimnete(fonctionnaire.getNss(), 1, 1);
        for (Indemnite indem : indemniteList) {
            if (indem.getLibelle_indemnite().equals("I.E.P")) {
                somme+=getIEP(fonctionnaire, cnx);
                salaire.getIndemniteVal().get(0).put(indem.getLibelle_indemnite(), getIEP(fonctionnaire, cnx));
            } else {
                if (indem.getTaux_indemnite() > 200) {
                    somme+=Double.valueOf(indem.getTaux_indemnite() + "");
                    salaire.getIndemniteVal().get(0).put(indem.getLibelle_indemnite(), Double.valueOf(indem.getTaux_indemnite() + ""));
                } else {
                    somme+=Double.valueOf((salaire.getSalaire_base() * indem.getTaux_indemnite()) + "");
                    salaire.getIndemniteVal().get(0).put(indem.getLibelle_indemnite(), Double.valueOf((salaire.getSalaire_base() * indem.getTaux_indemnite()) + ""));
                }
            }
        }
        salaire.setSalaire_poste(salaire.getSalaire_base()+somme);
        // Salaire imposable
        somme=0;
        retenuList=cnx.getAllRetenu(fonctionnaire.getNss(),1);
        for (Retenu retenu : retenuList) {
            if(retenu.getLibelleRetenu().equals("R.S.S")){
                diff+=(salaire.getSalaire_poste()*retenu.getTauxRetenu()/100);
                salaire.getRetenuVal().get(0).put(retenu.getLibelleRetenu(), salaire.getSalaire_poste()*retenu.getTauxRetenu());
            }else{
                if(retenu.getTauxRetenu()>200){
                  diff+=retenu.getTauxRetenu();  
                  salaire.getRetenuVal().get(0).put(retenu.getLibelleRetenu(), Double.valueOf(""+retenu.getTauxRetenu()));
           
                }else{
                  diff+=salaire.getSalaire_base()*retenu.getTauxRetenu();
                  salaire.getRetenuVal().get(0).put(retenu.getLibelleRetenu(), salaire.getSalaire_poste()*retenu.getTauxRetenu());
                }               
            }
        }
        indemniteList = cnx.getAllInimnete(fonctionnaire.getNss(), 1, 0);
        for (Indemnite indem : indemniteList) {
            
                if (indem.getTaux_indemnite() > 200) {
                    somme+=Double.valueOf(indem.getTaux_indemnite() + "");
                    salaire.getIndemniteVal().get(1).put(indem.getLibelle_indemnite(), Double.valueOf(indem.getTaux_indemnite() + ""));
                } else {
                    somme+=Double.valueOf((salaire.getSalaire_base() * indem.getTaux_indemnite()) + "");
                    salaire.getIndemniteVal().get(1).put(indem.getLibelle_indemnite(), Double.valueOf((salaire.getSalaire_base() * indem.getTaux_indemnite()) + ""));
                }
            
        }
        salaire.setSalaire_imposable(salaire.getSalaire_poste()+somme-diff);
        // Calcul du salaire net
        somme=0;
        diff=0;
        retenuList=cnx.getAllRetenu(fonctionnaire.getNss(),0);
        for (Retenu retenu : retenuList) {
            if(retenu.getLibelleRetenu().equals("I.R.G")){
                diff+=calculerIrg(salaire.getSalaire_imposable());
                salaire.getRetenuVal().get(1).put(retenu.getLibelleRetenu(), calculerIrg(salaire.getSalaire_imposable()));
            }else{
                if(retenu.getTauxRetenu()>200){
                  diff+=retenu.getTauxRetenu();  
                  salaire.getRetenuVal().get(1).put(retenu.getLibelleRetenu(), Double.valueOf(""+retenu.getTauxRetenu()));
           
                }else{
                  diff+=salaire.getSalaire_base()*retenu.getTauxRetenu();
                  salaire.getRetenuVal().get(1).put(retenu.getLibelleRetenu(), salaire.getSalaire_poste()*retenu.getTauxRetenu());
                }               
            }
        }
        indemniteList = cnx.getAllInimnete(fonctionnaire.getNss(), 0, 0);
        for (Indemnite indem : indemniteList) {
            
                if (indem.getTaux_indemnite() > 200) {
                    somme+=Double.valueOf(indem.getTaux_indemnite() + "");
                    salaire.getIndemniteVal().get(2).put(indem.getLibelle_indemnite(), Double.valueOf(indem.getTaux_indemnite() + ""));
                } else {
                    somme+=Double.valueOf((salaire.getSalaire_base() * indem.getTaux_indemnite()) + "");
                    salaire.getIndemniteVal().get(2).put(indem.getLibelle_indemnite(), Double.valueOf((salaire.getSalaire_base() * indem.getTaux_indemnite()) + ""));
                }          
        }
        salaire.setSalaire_net(salaire.getSalaire_imposable()+somme-diff);
        salaire.setIdSalaire(cnx.getAllSlaire().size());
        return salaire;
    }

    static void imprimerFichePaie(Fonctionnaire fonctionnaire,Salaire salaire,ConnexionBdd cnx) throws IOException, BiffException, WriteException {

         Workbook existingWorkbook = Workbook.getWorkbook(new File("fichepaie.xls"));
         WritableWorkbook workbookCopy = Workbook.createWorkbook(new File("cpy.xls"), existingWorkbook);
         WritableSheet sheetToEdit = workbookCopy.getSheet("fp");
         WritableCell cell;
         Label l;
        
         // L'entet
         DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
	   //get current date time with Date()
	   Date date = new Date();
	   System.out.println(dateFormat.format(date));
         l = new Label(5,17, dateFormat.format(date));
         cell = (WritableCell) l;
         sheetToEdit.addCell(cell);
         
         l = new Label(2,23, fonctionnaire.getNomFonctionnaire());
         cell = (WritableCell) l;
         sheetToEdit.addCell(cell);
        
         l = new Label(6,23, fonctionnaire.getPrenomFonctionnaire());
         cell = (WritableCell) l;
         sheetToEdit.addCell(cell);
        
         l = new Label(2,24, fonctionnaire.getNss()+"");
         cell = (WritableCell) l;
         sheetToEdit.addCell(cell);
        
         l = new Label(2,25,cnx.getAllBareme(fonctionnaire.getNss()).get(cnx.getAllBareme(fonctionnaire.getNss()).size()-1).getCategorie()+"");
         cell = (WritableCell) l;
         sheetToEdit.addCell(cell);
        
         l = new Label(6,25,cnx.getAllBareme(fonctionnaire.getNss()).get(cnx.getAllBareme(fonctionnaire.getNss()).size()-1).getEchelon()+"");
         cell = (WritableCell) l;
         sheetToEdit.addCell(cell);
        
         l = new Label(2,26,cnx.getAllFonction(fonctionnaire.getNss()).get(cnx.getAllFonction(fonctionnaire.getNss()).size()-1).getLibelleFonction());
         cell = (WritableCell) l;
         sheetToEdit.addCell(cell);
         // Les compasant de la paie
         l = new Label(6,30,salaire.getSalaire_base()+"");
         cell = (WritableCell) l;
             cell.setCellFormat(sheetToEdit.getCell("H31").getCellFormat());
         sheetToEdit.addCell(cell);
        
         l = new Label(6,39,salaire.getSalaire_poste()+"");
         cell = (WritableCell) l;
             cell.setCellFormat(sheetToEdit.getCell("H31").getCellFormat());
         sheetToEdit.addCell(cell);
        
         l = new Label(6,49,salaire.getSalaire_imposable()+"");
         cell = (WritableCell) l;
             cell.setCellFormat(sheetToEdit.getCell("H31").getCellFormat());
         sheetToEdit.addCell(cell);
        
         l = new Label(5,60,salaire.getSalaire_net()+"");
         cell = (WritableCell) l;
             cell.setCellFormat(sheetToEdit.getCell("H31").getCellFormat());
         sheetToEdit.addCell(cell);
         int i=31;
         for(String key :salaire.getIndemniteVal().get(0).keySet()){
             l = new Label(2,i,key+"");
             cell = (WritableCell) l;
             sheetToEdit.addCell(cell);
             
            l = new Label(6,i,salaire.getIndemniteVal().get(0).get(key)+"");
             cell = (WritableCell) l;
             sheetToEdit.addCell(cell);
             i++;
         }
         i=40;
         for(String key :salaire.getIndemniteVal().get(1).keySet()){
             l = new Label(2,i,key+"");
             cell = (WritableCell) l;
             sheetToEdit.addCell(cell);
            
            l = new Label(6,i,salaire.getIndemniteVal().get(1).get(key)+"");
             cell = (WritableCell) l;
             sheetToEdit.addCell(cell);
             i++;
         }
         for(String key :salaire.getRetenuVal().get(0).keySet()){
             l = new Label(2,i,key+"");
             cell = (WritableCell) l;
             sheetToEdit.addCell(cell);
             
            l = new Label(6,i,salaire.getRetenuVal().get(0).get(key)+"");
             cell = (WritableCell) l;
             sheetToEdit.addCell(cell);
             i++;
         }
         i=50;
         for(String key :salaire.getIndemniteVal().get(2).keySet()){
             l = new Label(2,i,key+"");
             cell = (WritableCell) l;
             sheetToEdit.addCell(cell);
             
            l = new Label(6,i,salaire.getIndemniteVal().get(2).get(key)+"");
             cell = (WritableCell) l;
             sheetToEdit.addCell(cell);
             i++;
         }
         for(String key :salaire.getRetenuVal().get(1).keySet()){
             l = new Label(2,i,key+"");
             cell = (WritableCell) l;
             sheetToEdit.addCell(cell);
            
            l = new Label(6,i,salaire.getRetenuVal().get(1).get(key)+"");
             cell = (WritableCell) l;
             sheetToEdit.addCell(cell);
              i++;
         }
         
         workbookCopy.write();
         workbookCopy.close();
         existingWorkbook.close();
        // Desktop.getDesktop().print(new File("cpy.xls"));
    }

    static void calculerRappel(Fonctionnaire fonctionnaire, Date dateDebut) {

    }

    static void imprimerFicheRappel(Fonctionnaire fonctionnaire, Date dateDebut) {

    }

    static double getSalaireDeBase(Long nss, ConnexionBdd connexion) {
        // barem test <- le bareme du fonctionnaire

        Bareme bareme = connexion.getAllBareme(nss).get(connexion.getAllBareme(nss).size() - 1);

        return (bareme.getIndiceCategorie() + bareme.getIndiceEchelon()) * 45;

    }

    // Les indimnités
    static double getIEP(Fonctionnaire fonctionnaire, ConnexionBdd connexion) {

        // barem test <- le bareme du fonctionnaire
        int nbAnne = Calendar.getInstance().get(Calendar.YEAR) - Integer.valueOf(fonctionnaire.getDateRecrutement().split("-")[0]);
        return nbAnne * getSalaireDeBase(fonctionnaire.getNss(), connexion) / 100;

    }

    static double getIFC(Long nss, ConnexionBdd cnx) {
        Bareme bareme = cnx.getAllBareme(nss).get(cnx.getAllBareme(nss).size() - 1);

        if (bareme.getCategorie() >= 1 && bareme.getCategorie() <= 6) {
            return 3200;
        } else if (bareme.getCategorie() >= 7 && bareme.getCategorie() <= 8) {
            return 2500;
        } else if (bareme.getCategorie() >= 9 && bareme.getCategorie() <= 10) {
            return 2000;
        } else {
            return 1500;
        }
    }

    static double getSalaireBrut(Fonctionnaire fonctionnaire) {
        // sb + les indimnités
        //  return getSalaireDeBase(fonctionnaire.getNss()) + getIEP(fonctionnaire) + getIFC(fonctionnaire);
        return 0;
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

    static double calculerIrg(double somme) {
        if (somme >= 15000 && somme < 22500) {
            return (somme * 0.2 - 3000);
        } else if (somme >= 22500 && somme < 28750) {
            return (somme * 0.12 - 1200);
        } else if (somme >= 28750 && somme < 30000) {
            return (somme * 0.2 - 3500);
        } else if (somme >= 30000 && somme < 120000) {
            
            return (somme * 0.30 - 6500);

        } else {
            return (somme * 0.35 - 12500);
        }

    }
}
