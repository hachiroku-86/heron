import java.util.ArrayList;
import java.util.Scanner;
public class Mission4 {
    private static Scanner sc;
    public static void main(String[] args) {

        Bagage b1 = new Bagage(2,"Bleu",22);

        System.out.println(b1);

        ArrayList<Voyageur> ListVoyageur = new ArrayList<>();

        int q = 3;
        int i = 1;
        String code = null;
        String handi = null;


        while (i == 1) {


            sc = new Scanner(System.in);

            System.out.println("Saisissez votre nom:");
            String nom = sc.nextLine();


            System.out.println("Saisissez votre age:");
            int age = sc.nextInt();
            sc.nextLine();
            Voyageur x = new Voyageur(nom, age);


            System.out.println("Saisissez votre adresse: ");
            String adresse = sc.nextLine();

            System.out.println("Saisissez votre ville: ");
            String ville = sc.nextLine();

            System.out.println("Saisissez votre code postal: ");
            String codePostal = sc.nextLine();
            AdressePostale v = new AdressePostale(adresse, ville, codePostal);
            x.setAdresse(v);
            System.out.println(v.toString());

            VoyageurPrivilège vp = new VoyageurPrivilège();

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

                System.out.println(x.toString());

                System.out.println("Couleur du bagage invalide saisissez à nouveau: ");
                couleur = sc.nextLine();
                Bagage b = new Bagage(numero, couleur, poids);
                x.setNumero(b);

                System.out.println(x.toString());

            } else {
                System.out.println(x.toString());
            }

            ListVoyageur.add(x);

            System.out.println("Pour saisir un nouvel utilisateur faites 1 ou faites 0 :");
            i = sc.nextInt();
            sc.nextLine();
        }

        for (Voyageur x : ListVoyageur) {
            System.out.println(x.toString());
        }

        System.out.println("Indiquer le nom d'un voyageur que vous souhaitez voir : ");
        String rechVoyageur = sc.nextLine();

        for (i=0; i<ListVoyageur.size(); i++){
            if(rechVoyageur.equals(ListVoyageur.get(i).getNom())){
                System.out.println(ListVoyageur.get(i).toString());
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
            System.out.println(x.toString());
        }


    }
}
