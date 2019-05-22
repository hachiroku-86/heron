package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Class.Club;
import Class.Equipe;
import Class.Licencie;
import Class.Categorie;

public class EquipeDAO extends DAO {

    public ArrayList<Equipe> getAllEquipe() throws ExceptionDAO {
        ArrayList<Equipe> listeEquipe = new ArrayList<Equipe>();
        Connection conn = null;
        try {
            conn = super.getConnexion();
            Statement stmt = conn.createStatement();
            String req = "SELECT * FROM Equipe, Club, Licencie, Categorie WHERE Equipe.IdClub = Club.Id AND Equipe.IdEntraineur = Licencie.Id AND Equipe.IdCategorie = Categorie.Id";
            ResultSet res = stmt.executeQuery(req);
            while (res.next()) {
                Equipe eq = new Equipe();
                Club c = new Club();
                Licencie l = new Licencie();
                Categorie cat = new Categorie();

                eq.setId(res.getInt(1));
                cat.setNom(res.getString(20));
                c.setNom(res.getString(8));
                l.setNom(res.getString(11));

                eq.setEntraineur(l);
                eq.setCategorie(cat);
                eq.setClub(c);
                listeEquipe.add(eq);

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
        return listeEquipe;
    }

}