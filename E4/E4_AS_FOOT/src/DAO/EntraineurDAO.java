package DAO;

import Class.Entraineur;
import Class.Equipe;

import java.sql.*;
import java.util.ArrayList;

public class EntraineurDAO extends DAO{

    public ArrayList<Entraineur> getAllEntraineur() throws ExceptionDAO {
        ArrayList<Entraineur> listeEntraineur = new ArrayList<Entraineur>();
        Connection conn = null;
        try {
            conn = super.getConnexion();
            Statement stmt = conn.createStatement();
            String req = "SELECT * FROM Licencie, Equipe WHERE Licencie.type = 'Entraineur' AND Licencie.Id = Equipe.IdEntraineur;";
            ResultSet res = stmt.executeQuery(req);
            while (res.next()) {
                Entraineur ent = new Entraineur();
                Equipe e = new Equipe();

                ent.setId(res.getInt(1));
                ent.setNom(res.getString(2));
                ent.setPrenom(res.getString(3));
                ent.setDateNaissance(res.getDate(4));
                ent.setLogin(res.getString(5));
                ent.setMdp(res.getString(6));
                ent.setLicence(res.getString(7));
                ent.setDateInscription(res.getDate(8));
                ent.setType(res.getString(9));
                e.setId(res.getInt(10));

                ent.setEquipe(e);

                listeEntraineur.add(ent);
            }
            res.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e){
            ExceptionDAO ex = new ExceptionDAO("problème SQL", e);
            throw ex;
        }catch (ClassNotFoundException e){
            ExceptionDAO ex = new ExceptionDAO("problème de driver", e);
            throw ex;
        }finally {
            try {
                conn.close();
            }catch (SQLException e){
                ExceptionDAO ex = new ExceptionDAO("problème SQL", e);
                throw ex;
            }
        }
        return listeEntraineur;
    }

    public Entraineur getEntraineurById(String login){
        Entraineur ent = new Entraineur();
        Connection conn;
        try{
            conn = super.getConnexion();
            String req = "SELECT * FROM Licencie, Entraineur WHERE Entraineur.Id = Licencie.Id AND Entraineur.Id = ?;";
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setString(1,login);
            ResultSet result = pstmt.executeQuery();
            while (result.next()){
                ent.setId(result.getInt(1));
                ent.setNom(result.getString(2));
                ent.setPrenom(result.getString(3));
                ent.setDateNaissance(result.getDate(4));
                ent.setLogin(result.getString(5));
                ent.setMdp(result.getString(6));
                ent.setLicence(result.getString(7));
                ent.setDateInscription(result.getDate(8));
                ent.setType(result.getString(9));

            }
            pstmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ent;
    }

    /*public Entraineur getJoueurByEntraineur(String login){
        Entraineur ent = new Entraineur();
        Connection conn;
        try{
            conn = super.getConnexion();
            String req = "SELECT * FROM Licencie, Entraineur, Joueur, Equipe WHERE Joueur.Id = Licencie.Id AND Entraineur.IdEquipe = Equipe.Id AND Joueur.IdEquipe = Equipe.Id AND Entraineur.Id = ?;";
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setString(1,login);
            ResultSet result = pstmt.executeQuery();
            while (result.next()){
                ent.setId(result.getInt(1));
                ent.setNom(result.getString(2));
                ent.setPrenom(result.getString(3));
                ent.setDateNaissance(result.getDate(4));
                ent.setLogin(result.getString(5));
                ent.setMdp(result.getString(6));
                ent.setLicence(result.getString(7));
                ent.setDateInscription(result.getDate(8));
                ent.setType(result.getString(9));
            }
            pstmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ent;
    }*/

    public ArrayList<Entraineur> getJoueurByEntraineur(int idEntraineur) throws ExceptionDAO {
        ArrayList<Entraineur> listeEntraineur = new ArrayList<Entraineur>();
        Connection conn;
        try{
            conn = super.getConnexion();
            String req = "SELECT * FROM Licencie, Entraineur, Joueur, Equipe WHERE Joueur.Id = Licencie.Id AND Entraineur.IdEquipe = Equipe.Id AND Joueur.IdEquipe = Equipe.Id AND Entraineur.Id = ?;";
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setInt(1,idEntraineur);
            ResultSet result = pstmt.executeQuery();
            while (result.next()){
                Entraineur ent = new Entraineur();

                ent.setId(result.getInt(1));
                ent.setNom(result.getString(2));
                ent.setPrenom(result.getString(3));
                ent.setDateNaissance(result.getDate(4));
                ent.setLogin(result.getString(5));
                ent.setMdp(result.getString(6));
                ent.setLicence(result.getString(7));
                ent.setDateInscription(result.getDate(8));
                ent.setType(result.getString(9));

                listeEntraineur.add(ent);
            }
            pstmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listeEntraineur;
    }
}
