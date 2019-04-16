package DAO;

import java.sql.*;
import java.util.ArrayList;
import Class.Licencie;

public class LicencieDAO extends DAO{

    public ArrayList<Licencie> getAllLicencie() throws ExceptionDAO {
        ArrayList<Licencie> listeLicencie = new ArrayList<Licencie>();
        Connection conn = null;
        try {
            conn = super.getConnexion();
            Statement stmt = conn.createStatement();
            String req = "SELECT * FROM Licencie";
            ResultSet res = stmt.executeQuery(req);
            while (res.next()) {
                Licencie result = new Licencie();
                result.setId(res.getInt(1));
                result.setNom(res.getString(2));
                result.setPrenom(res.getString(3));
                result.setDateNaissance(res.getDate(4));
                result.setLogin(res.getString(5));
                result.setMdp(res.getString(6));
                result.setLicence(res.getString(7));
                result.setDateInscription(res.getDate(8));
                result.setType(res.getString(9));
                listeLicencie.add(result);
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
        return listeLicencie;
    }

    public void insertLicencie(Licencie L)
    {
        try {
            Connection conn = getConnexion();
            String req = "INSERT INTO Licencie VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setInt(1, L.getId());
            pstmt.setString(2, L.getNom());
            pstmt.setString(3, L.getPrenom());
            pstmt.setDate(4, new Date(L.getDateNaissance().getTime()));
            pstmt.setString(5, L.getLogin());
            pstmt.setString(6, L.getMdp());
            pstmt.setString(7, L.getLincence());
            pstmt.setDate(8, new Date(L.getDateInscription().getTime()));
            pstmt.setString(9, L.getType());
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteLicencie(Licencie L)
    {
        try {
            Connection conn = getConnexion();
            String req = "DELETE FROM Licencie WHERE Id = ?";
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setInt(1, L.getId());
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Licencie> getLicencieByLogin() throws ExceptionDAO {
        ArrayList<Licencie> listeLicencie = new ArrayList<Licencie>();
        Connection conn = null;
        try {
            conn = super.getConnexion();
            Statement stmt = conn.createStatement();
            String req = "SELECT * FROM Licencie WHERE Login = ?";
            ResultSet res = stmt.executeQuery(req);
            while (res.next()) {
                Licencie result = new Licencie();
                result.setId(res.getInt(1));
                result.setNom(res.getString(2));
                result.setPrenom(res.getString(3));
                result.setDateNaissance(res.getDate(4));
                result.setLogin(res.getString(5));
                result.setMdp(res.getString(6));
                result.setLicence(res.getString(7));
                result.setDateInscription(res.getDate(8));
                result.setType(res.getString(9));
                listeLicencie.add(result);
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
        return listeLicencie;
    }

}
