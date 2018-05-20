import java.util.ArrayList;
import java.util.Scanner;
public class Mission3 {
    private static Scanner sc;

    public static void main(String[] args) {

        int q = 3;
        int i = 1;


        ArrayList<Voyageur> ListVoyageur = new ArrayList<>();

        while (i == 1) {

            sc = new Scanner(System.in);

            System.out.println("Saisissez votre nom:");
            String nom = sc.nextLine();


            System.out.println("Saisissez votre age:");
            int age = sc.nextInt();
            sc.nextLine();
            Voyageur x = new Voyageur(nom, age);

            x.afficher();

            System.out.println("Saisissez votre adresse: ");
            String adresse = sc.nextLine();

            System.out.println("Saisissez votre ville: ");
            String ville = sc.nextLine();

            System.out.println("Saisissez votre code postal: ");
            String codePostal = sc.nextLine();
            AdressePostale v = new AdressePostale(adresse, ville, codePostal);
            x.setAdresse(v);
            v.afficher();


            System.out.println("Avez vous un bagage ? Si oui 1, si non 0 : ");
            q = sc.nextInt();

            if (q == 1) {
                System.out.println("Saisissez le numéro du bagage: ");
                int numero = sc.nextInt();
                sc.nextLine();

                System.out.println("Saisissez la couleur du bagage: ");
                String couleur = sc.nextLine();

                System.out.println("Saisissez le poids du bagage: ");
                double poids = sc.nextDouble();
                sc.nextLine();

                x.afficher();

                System.out.println("Couleur du bagage invalide saisissez à nouveau: ");
                couleur = sc.nextLine();
                Bagage b = new Bagage(numero, couleur, poids);
                x.setNumero(b);

                x.afficher();

            } else {
                x.afficher2();
            }

            ListVoyageur.add(x);

            System.out.println("Pour saisir un nouvel utilisateur faites 1 ou faites 0 :");
            i = sc.nextInt();
            sc.nextLine();
        }

        for (Voyageur x : ListVoyageur) {
            x.afficher();
        }

        System.out.println("Indiquer le nom d'un voyageur que vous souhaitez voir : ");
        String rechVoyageur = sc.nextLine();

        for (i=0; i<ListVoyageur.size(); i++){
            if(rechVoyageur.equals(ListVoyageur.get(i).getNom())){
                ListVoyageur.get(i).afficher();
            }
        }


        System.out.println("Indiquer le nom d'un voyageur que vous souhaitez supprimer : ");
        String supVoyageur = sc.nextLine();

        for (i=0; i<ListVoyageur.size(); i++){
            if(supVoyageur.equals(ListVoyageur.get(i).getNom())){
                ListVoyageur.remove(i);
            }
        }

        for (Voyageur x : ListVoyageur) {
            x.afficher();
        }

    }

}

