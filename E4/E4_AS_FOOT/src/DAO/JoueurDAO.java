package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Class.Joueur;
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
                J.setDateNaissance(res.getDate(12));
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

    public ArrayList<Joueur> getJoueurByDir() throws ExceptionDAO {
        ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
        Connection conn = null;
        try {
            conn = super.getConnexion();
            Statement stmt = conn.createStatement();
            String req = "SELECT * FROM Joueur, Equipe, Licencie, Dirigeant WHERE Joueur.IdEquipe = Equipe.Id AND Joueur.Id = Licencie.Id AND Dirigeant.Id = Equipe.IdEntraineur ";
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
                J.setDateNaissance(res.getDate(12));
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

}
