import java.sql.*;



public class Main {
    public static void main(String[] args){

            Connection conn = null;
            String driver = "org.mariadb.jdbc.Driver";//String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mariadb://sio-hautil.eu:3306/heront";
            String user="heront";
            String pwd = "cresta1jz";
            try{
                Class.forName(driver);
                System.out.println("driver ok");
                conn=	DriverManager.getConnection(url,user,pwd);
                System.out.println("connection ok");

                Statement stmt = conn.createStatement();
                String req1 = "SELECT * FROM SLAM_Y2_JoueurFootM1";
                ResultSet result = stmt.executeQuery(req1);

                while(result.next()){
                    System.out.print(result.getString(1)+" ");
                    System.out.print("\n");
                    System.out.print(result.getString(2)+" ");
                    System.out.print("\n");
                    System.out.print(result.getString(3)+" ");
                    System.out.print("\n");
                    System.out.print(result.getString(4)+" ");
                    System.out.print("\n");
                    System.out.print(result.getString(5)+" ");
                    System.out.print("\n");
                    System.out.print(result.getString(6)+" ");
                    System.out.print("\n");
                    System.out.print(result.getString(7)+" ");
                }
                result.close();
                stmt.close();


            }catch(Exception e){
                e.printStackTrace();
            }


    }
}
