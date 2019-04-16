package DAO;

import Class.Licencie;

import java.sql.*;

public class DAO {

    public Connection getConnexion()throws SQLException, ClassNotFoundException{
        Connection conn = null;
        String driver = "org.mariadb.jdbc.Driver";
        String url = "jdbc:mariadb://sl-us-south-1-portal.34.dblayer.com:56255/E4_AS_FOOT";
        String user = "admin";
        String pwd = "MJZODZCSVZSAMRWE";
        Class.forName(driver);
        System.out.println("driver ok");
        conn = DriverManager.getConnection(url, user, pwd);
        System.out.println("connection ok");

        return conn;

    }


    public Licencie testLog(String login, String Mdp) {
        Licencie L = new Licencie();
        try {
            Connection conn = getConnexion();
            String req = "SELECT * FROM Licencie WHERE Login = ? AND Mdp = ? ";
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setString(1,login);
            pstmt.setString(2,Mdp);
            ResultSet result = pstmt.executeQuery();
            while (result.next()){
                L.setId(result.getInt(1));
                L.setNom(result.getString(2));
                L.setPrenom(result.getString(3));
                L.setDateNaissance(result.getDate(4));
                L.setLogin(result.getString(5));
                L.setMdp(result.getString(6));
                L.setLicence(result.getString(7));
                L.setDateInscription(result.getDate(8));
                L.setType(result.getString(9));

            }

            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return L;
    }
}
