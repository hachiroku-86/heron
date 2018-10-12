import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainEtape3 {

    public static void main(String[] args){

        JoueurDAO dao = new JoueurDAO();
        Joueur j = new Joueur();

        Scanner sc = new Scanner(System.in);
        System.out.println("Saisir nom joueur : ");
        String nom = sc.next();
        j.setNom(nom);

        System.out.println("Saisir prenom joueur : ");
        String prenom = sc.next();
        j.setPrenom(prenom);

        System.out.println("Saisir poste joueur : ");
        String poste = sc.next();
        j.setPoste(poste);

        System.out.println("Saisir numero joueur : ");
        int numero = sc.nextInt();
        j.setNumero(numero);

        System.out.println("Saisir id joueur : ");
        int id = sc.nextInt();
        j.setId(id);

        System.out.println("Saisir club joueur : ");
        String club = sc.next();
        j.setClub(club);

        System.out.println("Saisir date naissance joueur : ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateN = sc.next();
        Date dateNaissance = null;
        try {
            dateNaissance = sdf.parse(dateN);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        j.setDateN(dateNaissance);

        try {
            dao.insertJoueur(j);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }
}
