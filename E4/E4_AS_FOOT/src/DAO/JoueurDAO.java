package DAO;

import java.sql.*;
import java.util.ArrayList;
import Class.Joueur;
import Class.Licencie;
import Class.Equipe;

public class JoueurDAO extends DAO {

    public ArrayList<Joueur> getAllJoueur() throws ExceptionDAO {
        ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
        Connection conn = null;
        try {
            conn = super.getConnexion();
            Statement stmt = conn.createStatement();
            String req = "SELECT * FROM Joueur, Equipe, Licencie WHERE Joueur.IdEquipe = Equipe.Id AND Joueur.Id = Licencie.Id";
            ResultSet res = stmt.executeQuery(req);
            while (res.next()) {
                Joueur J = new Joueur();
                Equipe eq = new Equipe();

                J.setId(res.getInt(1));
                eq.setId(res.getInt(2));
                J.setNum(res.getInt(3));
                J.setPoste(res.getString(4));
                J.setNom(res.getString(10));
                J.setPrenom(res.getString(11));
                J.setDateInscription(res.getDate(16));

                J.setEquipe(eq);
                listeJoueur.add(J);

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
        return listeJoueur;
    }

    public Joueur getJoueurById(String login){
        Joueur j = new Joueur();
        Equipe eq = new Equipe();
        Connection conn;
        try{
            conn = super.getConnexion();
            String req = "SELECT * FROM Licencie, Joueur, Equipe WHERE Joueur.Id = Licencie.Id AND Joueur.IdEquipe = Equipe.Id AND Joueur.Id = ?;";
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setString(1,login);
            ResultSet result = pstmt.executeQuery();
            while (result.next()){
                j.setId(result.getInt(1));
                j.setNom(result.getString(2));
                j.setPrenom(result.getString(3));
                j.setDateNaissance(result.getDate(4));
                j.setLogin(result.getString(5));
                j.setMdp(result.getString(6));
                j.setLicence(result.getString(7));
                j.setDateInscription(result.getDate(8));
                j.setType(result.getString(9));
                j.setMdp(result.getString(11));
                j.setNum(result.getInt(12));
                j.setPoste(result.getString(13));
            }
            pstmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return j;
    }



    public ArrayList<Joueur> getJoueurByEquipe(int idEquipe) throws ExceptionDAO {
        ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
        Connection conn;
        try{
            conn = super.getConnexion();
            String req = "SELECT * FROM Licencie, Joueur WHERE Licencie.Id = Joueur.Id AND Joueur.IdEquipe = ?;";
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setInt(1,idEquipe);
            ResultSet result = pstmt.executeQuery();
            while (result.next()){
                Joueur j = new Joueur();

                j.setNom(result.getString(2));
                j.setPrenom(result.getString(3));
                j.setDateInscription(result.getDate(8));
                j.setNum(result.getInt(12));
                j.setPoste(result.getString(13));

                listeJoueur.add(j);
            }
            pstmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listeJoueur;
    }

    public ArrayList<Joueur> getJoueurByEntraineur(int idEntraineur) throws ExceptionDAO {
        ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
        Connection conn;
        try{
            conn = super.getConnexion();
            String req = "SELECT * FROM Licencie, Entraineur, Joueur, Equipe WHERE Joueur.Id = Licencie.Id AND Entraineur.IdEquipe = Equipe.Id AND Joueur.IdEquipe = Equipe.Id AND Entraineur.Id = ?;";
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setInt(1,idEntraineur);
            ResultSet result = pstmt.executeQuery();
            while (result.next()){
                Joueur j = new Joueur();

                j.setNom(result.getString(2));
                j.setPrenom(result.getString(3));
                j.setDateInscription(result.getDate(8));
                j.setNum(result.getInt(14));
                j.setPoste(result.getString(15));

                listeJoueur.add(j);
            }
            pstmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listeJoueur;
    }

}



