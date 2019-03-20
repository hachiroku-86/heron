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
            String req = "SELECT login, Mdp, Nom, Prenom FROM Licencie WHERE Login = ? AND Mdp = ? ";
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setString(1,login);
            pstmt.setString(2,Mdp);
            ResultSet result = pstmt.executeQuery();
            while (result.next()){
                L.setLogin(result.getString(1));
                L.setMdp(result.getString(2));
                L.setNom(result.getString(3));
                L.setPrenom(result.getString(4));
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
