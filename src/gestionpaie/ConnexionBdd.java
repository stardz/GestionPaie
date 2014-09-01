package gestionpaie;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConnexionBdd {

    private static Connection connexion = null;
    private static Statement statement = null;

    public void connecter() {
        String url = "jdbc:mysql://localhost:3306/paie";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connexion = DriverManager.getConnection(url, "root", "85795544");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur - SQL - lors de la connexion" + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (InstantiationException e) {
            JOptionPane.showMessageDialog(null, "Erreur - Instantiation - lors de la connexion" + e.getMessage(),
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Erreur - Illegal access - lors de la connexion" + e.getMessage(),
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erreur - Class not found - lors de la connexion" + e.getMessage(),
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deconnecter() {
        try {
            connexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur de fermeture de la base de donnees" + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet getResultatRequete(String requete) {
        ResultSet resultat = null;
        try {
            statement = connexion.createStatement();
            resultat = statement.executeQuery(requete);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur de la requete" + e.getMessage(), "Erreur", JOptionPane.OK_OPTION);
        }
        return resultat;
    }

    public void executerRequete(String requete) {
        try {
            statement = connexion.createStatement();
            statement.executeUpdate(requete);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur de la requete" + e.getMessage(), "Erreur", JOptionPane.OK_OPTION);
        }
    }

    public void supprimer(String table, String condition) {
        String requete = "delete from " + table + " where " + condition + " ";
        executerRequete(requete);
    }

    int nombreDeligne(String table, String condition) {
        ResultSet res = getResultatRequete("select count(*) from " + table + "  " + condition + "  ");
        int v = 0;
        try {
            res.first();
            v = res.getInt("count(*)");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return v;
    }

  

    public void modifierTable(String table, String attribut, String valeur, String condition) {
        String requete = "update " + table + " SET " + attribut + "= '" + valeur + "' where " + condition + "";
        executerRequete(requete);
    }
    
    public void modifierBarem(Bareme bareme) {
        modifierTable("bareme", "indice_category", bareme.getIndiceCategorie() + "", "categorie_echelon = '" + bareme.getcategorieEchelon() + "'");
        modifierTable("bareme", "indice_echelon", bareme.getIndiceEchelon() + "", "categorie_echelon = '" + bareme.getcategorieEchelon() + "'");

    }
    /************************************** Insertion **********************************************************/
    public void insertFonctionnaire(Fonctionnaire fonctionnaire, int idBanque) {
        String requete = "INSERT IGNORE INTO fonctionnaire SET NSS='" + fonctionnaire.getNss() + "',"
                + "Nom='" + fonctionnaire.getNomFonctionnaire() + "',"
                + "Prenom='" + fonctionnaire.getPrenomFonctionnaire() + "',"
                + "Sexe='" + fonctionnaire.getSexe() + "',"
                + "situation_conj='" + fonctionnaire.getSituationFamiliale() + "',"
                + "date_recrut='" + Date.valueOf(fonctionnaire.getDateRecrutement()) + "',"
                + "enfant_charg='" + fonctionnaire.getEnfantCharg() + "',"
                + "enfant_scol='" + fonctionnaire.getEnfantScolarise() + "',"
                + "enfant_pdix='" + fonctionnaire.getEnfantPlusDixAns() + "',"
                + "num_mutuel='" + fonctionnaire.getNumMutuelle() + "',"
                + "num_cpt='" + fonctionnaire.getNumCompte() + "',"
                + "rue='" + fonctionnaire.getRue() + "',"
                + "ville='" + fonctionnaire.getVile() + "',"
                + "code_irg='" + fonctionnaire.getVile() + "',"
                + "statut='" + fonctionnaire.getStatus() + "',"
                + "id_banque='" + idBanque + "';";
        executerRequete(requete);              
    }
    public void attribuerBareme(Long nss ,String categorieEchelon,Date date){
        String req="INSERT IGNORE INTO date SET date_date='" + date + "';";
                executerRequete(req);
        String requete="INSERT IGNORE INTO classe SET NSS='" + nss + "',"
                + "categorie_echelon='" + categorieEchelon + "',"
                + "date_date='" + date + "';";
        executerRequete(requete);
    }
    public void attribuerPrime(Long nss,int idPrime){
        String requete="INSERT IGNORE INTO avoir_prime SET NSS='" + nss + "',"               
                + "id_prm='" + idPrime + "';";
        executerRequete(requete);
    }
    public void attribuerIndemnite(Long nss,int idIndimnite){
        String requete="INSERT IGNORE INTO possede_indemnite SET NSS='" + nss + "',"                
                + "id_ind='" + idIndimnite + "';";
        executerRequete(requete);
    }
    public void attribuerRetenu(Long nss,int idRetenu){
        String requete="INSERT IGNORE INTO avoir_retenu SET NSS='" + nss + "',"                
                + "id_retenu='" + idRetenu + "';";
        executerRequete(requete);
    }
    public void attribuerFonction(Long nss,int idFonction,Date date){
        String req="INSERT IGNORE INTO date SET date_date='" + date + "';";
                executerRequete(req);
        String requete="INSERT IGNORE INTO occupe SET NSS='" + nss + "',"
                + "id_fonction='" + idFonction + "',"
                + "date_date='" + date + "';";
        executerRequete(requete);
    }
    public void insertSalaireDu(Long nss,Salaire salaire,Date date){
        String requete="INSERT IGNORE INTO date SET date_date='" + date + "';";
                executerRequete(requete);
                requete="INSERT IGNORE INTO salaire SET id_salaire='" + salaire.getIdSalaire() + "',"
                        +"salaire_base='"+salaire.getSalaire_base()+"',"
                        +"salaire_poste='"+salaire.getSalaire_poste()+"',"
                        +"salaire_imposable='"+salaire.getSalaire_imposable()+"',"
                        +"salaire_net='"+salaire.getSalaire_net()+"';";              
                executerRequete(requete);
                requete="INSERT IGNORE INTO du SET nss='"+nss+"',"
                +"date_date='"+date+"',"
                +"id_salaire='"+salaire.getIdSalaire()+"';";
                executerRequete(requete);
                
    }
    public void insertSalaireRecu(Long nss,Salaire salaire,Date date){
        String requete="INSERT IGNORE INTO date SET date_date='" + date + "';";
                executerRequete(requete);
                requete="INSERT IGNORE INTO salaire SET id_salaire='" + salaire.getIdSalaire() + "',"
                        +"salaire_base='"+salaire.getSalaire_base()+"',"
                        +"salaire_poste='"+salaire.getSalaire_poste()+"',"
                        +"salaire_imposable='"+salaire.getSalaire_imposable()+"',"
                        +"salaire_net='"+salaire.getSalaire_net()+"';";              
                executerRequete(requete);
                requete="INSERT IGNORE INTO percevoir SET nss='"+nss+"',"
                +"date_date='"+date+"',"
                +"id_salaire='"+salaire.getIdSalaire()+"';";
                executerRequete(requete);
    }
    /*********************************** Get All *****************************************/
      public ArrayList<Bareme> getAllBareme() {
        ArrayList<Bareme> retList = new ArrayList<Bareme>();
        String requete = "select * from paie.bareme ;";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
                Bareme bareme = new Bareme(res.getString("categorie_echelon"),
                        res.getInt("indice_category"),
                        res.getInt("indice_echelon"));
                retList.add(bareme);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retList;
    }
      public  ArrayList<Fonctionnaire> getAllFonctionnaire(){
          ArrayList<Fonctionnaire> retList=new ArrayList<Fonctionnaire>();
          String requete = "select * from paie.fonctionnaire ;";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
            //Fonctionnaire( Long numMutuelle, Long numCompte, String rue, String ville, String status) {
       
                Fonctionnaire fonctionnaire = new Fonctionnaire(
                        res.getLong("NSS"),
                        res.getString("Nom"),
                        res.getString("Prenom") ,
                        res.getString("Sexe"),
                        res.getString("situation_conj"),
                         res.getDate("date_recrut").toString(),
                        res.getInt("enfant_charg"),
                        res.getInt("enfant_scol"),
                        res.getInt("enfant_pdix"),
                        new Long(res.getInt("num_mutuel")),
                        new Long(res.getInt("num_cpt")),
                        res.getString("rue"),
                        res.getString("ville"),
                        res.getString("statut"));
                retList.add(fonctionnaire);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retList;
      }
      public ArrayList<Banque> getAllBanque() {
        ArrayList<Banque> retList = new ArrayList<Banque>();
        String requete = "select * from paie.banque ;";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
                Banque banque = new Banque(res.getInt("id_banque"),res.getString("nom_banque"));
                retList.add(banque);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retList;
    }
       public ArrayList<Fonction> getAllFonction() {
        ArrayList<Fonction> retList = new ArrayList<Fonction>();
        String requete = "select * from paie.fonction ;";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
                Fonction fonction = new Fonction(res.getInt("id_fonction"),res.getString("libelle_fonction"));
                retList.add(fonction);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retList;
    }
       public ArrayList<Indemnite> getAllInimnete() {
        ArrayList<Indemnite> retList = new ArrayList<Indemnite>();
        String requete = "select * from paie.indemnite ;";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
                Indemnite indemnite = new Indemnite(res.getInt("id_ind"),res.getInt("taux_ind"),res.getString("libelle_indimnite"));
                retList.add(indemnite);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retList;
    }
       public ArrayList<Retenu> getAllRetenu() {
        ArrayList<Retenu> retList = new ArrayList<Retenu>();
        String requete = "select * from paie.retenu ;";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
                Retenu retenu = new Retenu(res.getInt("id_retenu"),res.getString("libelle_ret"),res.getInt("taux_ret"));
                retList.add(retenu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retList;
    }
        public ArrayList<Prime> getAllPrime() {
        ArrayList<Prime> retList = new ArrayList<Prime>();
        String requete = "select * from paie.prime ;";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
                Prime prime = new Prime(res.getInt(3),res.getInt(2),res.getInt(1),res.getString(4));
                retList.add(prime);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retList;
    }
        /************************  recuperation des informations d'un fonctionnaire************************************************/
         public ArrayList<Bareme> getAllBareme(Long nss) {
        ArrayList<Bareme> retList = new ArrayList<Bareme>();
        String requete = "select * from paie.bareme natural join paie.classe natural join paie.fonctionnaire where paie.fonctionnaire.nss='"+nss+"' order by date_date;";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
                Bareme bareme = new Bareme(res.getString("categorie_echelon"),
                        res.getInt("indice_category"),
                        res.getInt("indice_echelon"));
                retList.add(bareme);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retList;
         }
        public  Fonctionnaire getFonctionnaire(Long nss){
          Fonctionnaire retFonctionnaire=null;
          String requete = "select * from paie.fonctionnaire where nss = '"+nss+"';";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
          
                Fonctionnaire fonctionnaire = new Fonctionnaire(
                        res.getLong("NSS"),
                        res.getString("Nom"),
                        res.getString("Prenom") ,
                        res.getString("Sexe"),
                        res.getString("situation_conj"),
                         res.getDate("date_recrut").toString(),
                        res.getInt("enfant_charg"),
                        res.getInt("enfant_scol"),
                        res.getInt("enfant_pdix"),
                        new Long(res.getInt("num_mutuel")),
                        new Long(res.getInt("num_cpt")),
                        res.getString("rue"),
                        res.getString("ville"),
                        res.getString("statut"));
                retFonctionnaire=fonctionnaire;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retFonctionnaire;
      }
    public Banque getBanque(Long nss) {
        Banque retBanque =null;
        String requete = "select * from paie.banque natural join paie.fonctionnaire;";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
                Banque banque = new Banque(res.getInt("id_banque"),res.getString("nom_banque"));
                retBanque=banque;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retBanque;
    }
    public ArrayList<Fonction> getAllFonction(Long nss) {
        ArrayList<Fonction> retList = new ArrayList<Fonction>();
        String requete = "select * from paie.fonction natural join occupe natural join paie.fonctionnaire where nss='"+nss+"' order by date_date;";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
                Fonction fonction = new Fonction(res.getInt("id_fonction"),res.getString("libelle_fonction"));
                retList.add(fonction);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retList;
    }
    public ArrayList<Indemnite> getAllInimnete(Long nss) {
        ArrayList<Indemnite> retList = new ArrayList<Indemnite>();
        String requete = "select * from paie.indemnite natural join paie.possede_indemnite natural join paie.fonctionnaire where"
                + "nss='"+nss+"';";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
                Indemnite indemnite = new Indemnite(res.getInt("id_ind"),res.getInt("taux_ind"),res.getString("libelle_indimnite"));
                retList.add(indemnite);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retList;
    }
    public ArrayList<Retenu> getAllRetenu(Long nss) {
        ArrayList<Retenu> retList = new ArrayList<Retenu>();
        String requete = "select * from paie.retenu natural join paie.avoir_retenu natural join paie.fonctionnaire where"
                + "nss='"+nss+"';";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
                Retenu retenu = new Retenu(res.getInt("id_retenu"),res.getString("libelle_ret"),res.getInt("taux_ret"));
                retList.add(retenu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retList;
    }
        public ArrayList<Prime> getAllPrime(Long nss) {
        ArrayList<Prime> retList = new ArrayList<Prime>();
        String requete = "select * from paie.prime natural join paie.avoir_prime natural join paie.fonctionnaire where"
                + "nss='"+nss+"';";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
                Prime prime = new Prime(res.getInt(3),res.getInt(2),res.getInt(1),res.getString(4));
                retList.add(prime);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retList;
    }
       public ArrayList<Salaire> getAllSalaireDu(Long nss,Date date) {
        ArrayList<Salaire> retList = new ArrayList<Salaire>();
        String requete = "select * from paie.salaire natural join paie.du natural join paie.fonctionnaire where"
                + " nss='"+nss+"'&& date_date>='"+date+"';";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
                Salaire salaire = new Salaire(
                        res.getInt("id_salaire"),
                        res.getDouble("salaire_base"),
                        res.getDouble("salaire_poste"),
                        res.getDouble("salaire_imposable"),
                        res.getDouble("salaire_net"));
                retList.add(salaire);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retList;
    }
       public ArrayList<Salaire> getAllSalaireRecu(Long nss,Date date) {
        ArrayList<Salaire> retList = new ArrayList<Salaire>();
        String requete = "select * from paie.salaire natural join paie.percevoir natural join paie.fonctionnaire where"
                + " nss='"+nss+"'&& date_date>='"+date+"';";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
                Salaire salaire = new Salaire(
                        res.getInt("id_salaire"),
                        res.getDouble("salaire_base"),
                        res.getDouble("salaire_poste"),
                        res.getDouble("salaire_imposable"),
                        res.getDouble("salaire_net"));
                retList.add(salaire);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retList;
    }
      /************************  recuperation des objet specifies************************************************/
        public Bareme getBareme(String categorieEchelon) {
        Bareme baremeRet = null;
        String requete = "select * from paie.bareme where paie.bareme.categorie_echelon='"+categorieEchelon+"';";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
                Bareme bareme = new Bareme(res.getString("categorie_echelon"),
                        res.getInt("indice_category"),
                        res.getInt("indice_echelon"));
                baremeRet=bareme;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return baremeRet;
         }  
         public Indemnite getInimnete(String libelle) {
        Indemnite retInd = null;
        String requete = "select * from paie.indemnite where "
                + "libelle_indimnite='"+libelle+"';";
        ResultSet res = getResultatRequete(requete);
        try {
            while (res.next()) {
                Indemnite indemnite = new Indemnite(res.getInt("id_ind"),res.getInt("taux_ind"),res.getString("libelle_indimnite"));
                retInd = indemnite;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retInd;
    }
         
}
