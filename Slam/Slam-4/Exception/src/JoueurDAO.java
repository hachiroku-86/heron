import java.sql.*;
import java.util.ArrayList;

public class JoueurDAO {
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        String driver = "org.mariadb.jdbc.Driver";
        String url = "jdbc:mariadb://sio-hautil.eu:3306/heront";
        String user = "heront";
        String pwd = "cresta1jz";
        Class.forName(driver);
        System.out.println("driver ok");
        conn = DriverManager.getConnection(url, user, pwd);
        System.out.println("connection ok");

        return conn;
    }


    public void insertJoueur(Joueur j) throws DaoException{
        Connection conn = null;
        try{
            conn = getConnection();
            String req1 = "INSERT INTO SLAM_Y2_JoueurFootM1 VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(req1);

            pstmt.setString(1, j.getNom());

            pstmt.setString(2, j.getPrenom());

            pstmt.setString(3, j.getPoste());

            pstmt.setInt(4, j.getNumero());

            pstmt.setInt(5, j.getId());

            pstmt.setString(6, j.getClub());

            pstmt.setDate(7, new Date(j.getDateN().getTime()));


            int res1 = pstmt.executeUpdate();
            System.out.println("Nombre de lignes modifiées : " + res1);
        }catch (SQLException e){
            DaoException ex = new DaoException("problème SQL", e);
            throw ex;
        }catch (ClassNotFoundException e){
            DaoException ex = new DaoException("problème de driver", e);
            throw ex;
        }finally {
            try {
                conn.close();
            }catch (SQLException e){
                DaoException ex = new DaoException("problème SQL", e);
                throw ex;
            }
        }
    }

    public void deleteJoueur(Joueur j) throws DaoException {
        Connection conn = null;
        try {
            conn = getConnection();
            String req1 = "DELETE FROM SLAM_Y2_JoueurFootM1 WHERE nom = ?";
            PreparedStatement pstmt = conn.prepareStatement(req1);

            pstmt.setString(1, j.getNom());

            int res = pstmt.executeUpdate();
            System.out.println("Nombre de lignes modifiées : " + res);
        } catch (SQLException e) {
            DaoException ex = new DaoException("problème SQL", e);
            throw ex;
        } catch (ClassNotFoundException e) {
            DaoException ex = new DaoException("problème de driver", e);
            throw ex;
        }finally {
            try {
                conn.close();
            }catch (SQLException e){
                DaoException ex = new DaoException("problème SQL", e);
                throw ex;
            }
        }
    }

    public ArrayList getJoueurByPoste(String x) throws DaoException{
        ArrayList<Joueur> list = new ArrayList<>();
        Joueur res = null;
        Connection conn = null;
        try{
            conn = getConnection();
            String req = "SELECT * FROM SLAM_Y2_JoueurFootM1 WHERE poste = ?";
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setString(1, x);
            ResultSet result = pstmt.executeQuery();
            while(result.next()){
                res = new Joueur();
                res.setId(result.getInt(1));
                res.setNom(result.getString(2));
                res.setPrenom(result.getString(3));
                res.setPoste(result.getString(4));
                res.setNumero(result.getInt(5));
                res.setClub(result.getString(6));
                res.setDateN(result.getDate(7));
                list.add(res);
            }
        }catch (SQLException e) {
            DaoException ex = new DaoException("problème SQL", e);
            throw ex;
        }catch (ClassNotFoundException e) {
            DaoException ex = new DaoException("problème de driver", e);
            throw ex;
        }finally {
            try {
                conn.close();
            }catch (SQLException e){
                DaoException ex = new DaoException("problème SQL", e);
                throw ex;
            }
        }
        return list;
    }

    public ArrayList getJoueurs() throws DaoException{
        ArrayList<Joueur> list = new ArrayList<>();
        Joueur res;
        Connection conn = null;
        try{
            conn = getConnection();
            Statement stmt = conn.createStatement();
            String req = "SELECT * FROM SLAM_Y2_JoueurFootM1";
            ResultSet result = stmt.executeQuery(req);
            while(result.next()){
                res = new Joueur();
                res.setId(result.getInt(1));
                res.setNom(result.getString(2));
                res.setPrenom(result.getString(3));
                res.setPoste(result.getString(4));
                res.setNumero(result.getInt(5));
                res.setClub(result.getString(6));
                res.setDateN(result.getDate(7));
                list.add(res);
            }
        }catch (SQLException e) {
            DaoException ex = new DaoException("problème SQL", e);
            throw ex;
        }catch (ClassNotFoundException e) {
            DaoException ex = new DaoException("problème de driver", e);
            throw ex;
        }finally {
            try {
                conn.close();
            }catch (SQLException e){
                DaoException ex = new DaoException("problème SQL", e);
                throw ex;
            }
        }
        return list;
    }
}
