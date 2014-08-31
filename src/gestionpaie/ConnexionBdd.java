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
            connexion = DriverManager.getConnection(url, "root", "");
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

    public void modifierTable(String table, String attribut, String valeur, String condition) {
        String requete = "update " + table + " SET " + attribut + "= '" + valeur + "' where " + condition + "";
        executerRequete(requete);
    }

    public void modifierBarem(Bareme bareme) {
        modifierTable("bareme", "indice_category", bareme.getIndiceCategorie() + "", "categorie_echelon = '" + bareme.getcategorieEchelon() + "'");
        modifierTable("bareme", "indice_echelon", bareme.getIndiceEchelon() + "", "categorie_echelon = '" + bareme.getcategorieEchelon() + "'");

    }
    
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
}
