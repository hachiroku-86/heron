import java.sql.*;
import java.util.Scanner;

public class TestJDBC {
        public static void main(String[] args){
            try{

                int z = 1;

                while (z != 0) {

                int choix = 0;

                Scanner Choix = new Scanner(System.in);
                System.out.println("Entrer 1 pour ajouter un professeur, 2 pour suprimmer un professeur, 3 pour afficher selon l'id, 4 selon spécialité :");
                choix = Choix.nextInt();

                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("driver ok");
                Connection conn= DriverManager.getConnection("jdbc:mysql://sl-us-south-1-portal.9.dblayer.com:25143/TestJDBC","admin", "XIYIAJDHRFPMRSIF");
                System.out.println("connection ok");
                // Création de la requête

                Statement stmt = conn.createStatement();
                // Exécution d’une requête de mise à jour (DELETE, INSERT, UPDATE)
                //String req1 = "INSERT INTO Professeur VALUES (33,'Massat','CultureG')"; int res = stmt.executeUpdate(req1);
                //System.out.println("nb de modifications réalisées : " + res);
                // Exécution d’une requête de sélection (SELECT)
                String req2 = "SELECT Nom, Specialite FROM Professeur";
                ResultSet result = stmt.executeQuery(req2);
                // On affiche les donneés des différentes colonnes
                while(result.next()){
                    System.out.print( "Nom : "+ result.getString(1));
                    System.out.print( "Spécialité : "+ result.getString(2));
                }

                System.out.println("\n");

                    if (choix == 1) {
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Saisissez l'Id du professeur :");
                        int IdP = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Saisissez le nom du professeur :");
                        String NomP = sc.nextLine();

                        System.out.println("Saisissez la specialitée du professeur :");
                        String SpeP = sc.nextLine();

                        // Création de la requête préparée
                        String req3 = "INSERT INTO Professeur VALUES (?,?,?)";
                        PreparedStatement pstmt = conn.prepareStatement(req3);

                        // Préparation de la requête
                        pstmt.setInt(1, IdP);
                        pstmt.setString(2, NomP);
                        pstmt.setString(3, SpeP);

                        // Exécution d’une requête préparée de mise à jour (DELETE, INSERT, UPDATE)
                        int res2 = pstmt.executeUpdate();
                    }

                    if (choix == 2) {
                        Scanner sc1 = new Scanner(System.in);
                        System.out.println("Saisissez l'Id du professeur à supprimer:");
                        int idP1 = sc1.nextInt();
                        sc1.nextLine();

                        String req4 = "DELETE FROM Professeur WHERE Id = ?";
                        PreparedStatement pstmt1 = conn.prepareStatement(req4);

                        pstmt1.setInt(1, idP1);

                        int res4 = pstmt1.executeUpdate();
                        System.out.println(res4 + " Utilisateur à été supprimer !");
                    }

                    if (choix == 3) {
                        Scanner sc2 = new Scanner(System.in);
                        System.out.println("Saisissez le nom du professeur à afficher:");
                        String nomP1 = sc2.next();
                        sc2.nextLine();

                        String req5 = "SELECT * FROM Professeur WHERE Nom = ?";
                        PreparedStatement pstmt2 = conn.prepareStatement(req5);

                        pstmt2.setString(1, nomP1);

                        ResultSet res5 = pstmt2.executeQuery();
                        while (res5.next()) {
                            System.out.print("Id : " + res5.getInt(1));
                            System.out.print("Nom : " + res5.getString(2));
                            System.out.print("Spécialité : " + res5.getString(3));
                        }
                        result.close();
                        stmt.close();
                    }

                    if (choix == 4) {
                        Scanner sc3 = new Scanner(System.in);
                        System.out.println("Saisissez la spécialité du professeur à afficher:");
                        String SpeP1 = sc3.next();
                        sc3.nextLine();

                        String req5 = "SELECT * FROM Professeur WHERE Specialite = ?";
                        PreparedStatement pstmt2 = conn.prepareStatement(req5);

                        pstmt2.setString(1, SpeP1);

                        ResultSet res5 = pstmt2.executeQuery();
                        while (res5.next()) {
                            System.out.print("Id : " + res5.getInt(1));
                            System.out.print("Nom : " + res5.getString(2));
                            System.out.print("Spécialité : " + res5.getString(3));
                        }
                        result.close();
                        stmt.close();
                    }

                    Scanner Z = new Scanner(System.in);
                    System.out.println("Entrer 1 pour effectuer une autre opération, 0 pour arreter :");
                    z = Z.nextInt();
                }

            }catch(Exception e){ e.printStackTrace(); }
    }
}

