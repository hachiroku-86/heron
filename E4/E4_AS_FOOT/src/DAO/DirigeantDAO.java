package DAO;

import Class.Dirigeant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DirigeantDAO extends DAO{

    public ArrayList<Dirigeant> getAllDirigeant() throws ExceptionDAO {
        ArrayList<Dirigeant> listeDirigeant = new ArrayList<Dirigeant>();
        Connection conn = null;
        try {
            conn = super.getConnexion();
            Statement stmt = conn.createStatement();
            String req = "SELECT * FROM Licencie, Dirigeant WHERE Licencie.Id = Dirigeant.Id";
            ResultSet res = stmt.executeQuery(req);
            while (res.next()) {
                Dirigeant D = new Dirigeant();

                D.setId(res.getInt(1));
                D.setType(res.getString(10));
                D.setNom(res.getString(2));
                D.setPrenom(res.getString(3));
                D.setDateNaissance(res.getDate(4));
                D.setDateInscription(res.getDate(8));


                listeDirigeant.add(D);

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
        return listeDirigeant;
    }
}
