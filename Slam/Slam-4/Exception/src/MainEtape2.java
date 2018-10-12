import java.sql.*;

public class MainEtape2 {
    public static void main(String[] args) {

        Joueur j = new Joueur();

        Connection conn = null;
        String driver = "org.mariadb.jdbc.Driver";//String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mariadb://sio-hautil.eu:3306/heront";
        String user = "heront";
        String pwd = "cresta1jz";
        try {
            Class.forName(driver);
            System.out.println("driver ok");
            conn = DriverManager.getConnection(url, user, pwd);
            System.out.println("connection ok");

            Statement stmt = conn.createStatement();
            String req1 = "SELECT * FROM SLAM_Y2_JoueurFootM1";
            ResultSet result = stmt.executeQuery(req1);

            while(result.next()){
                System.out.println("Nom : " + result.getString(1));
                System.out.println("Prénom : " + result.getString(2));
            }
            result.close();


        }catch(Exception e){
            e.printStackTrace();
        }

    }

}