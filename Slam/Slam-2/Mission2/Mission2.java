import java.util.Scanner;
public class Mission2 {
    private static Scanner sc;
    public static void main(String [] args){

        int q = 3;

        sc = new Scanner(System.in);
        AdressePostale v = new AdressePostale("64 Grande Rue","Boisemont","95000");

        Bagage b = new Bagage(12,"Bleu",5 );
        b.afficher();

        Voyageur x = new Voyageur("Heron Thomas",19);
        x.setAdresse(v);
        x.setNumero(b);
        x.afficher();



        System.out.println("Saisissez votre adresse: ");
        String adresse=sc.nextLine();
        v.setAdresse(adresse);

        System.out.println("Saisissez votre ville: ");
        String ville=sc.nextLine();
        v.setVille(ville);

        System.out.println("Saisissez votre code postal: ");
        String codePostal=sc.nextLine();
        v.setcodePostal(codePostal);

        v.afficher();


        System.out.println("Avez vous un bagage ? Si oui 1, si non 0 : ");
        q =sc.nextInt();

        if(q == 1) {
            System.out.println("Saisissez le numéro du bagage: ");
            int numero = sc.nextInt();
            b.setNumero(numero);

            System.out.println("Saisissez la couleur du bagage: ");
            String couleur = sc.next();
            b.setCouleur(couleur);

            System.out.println("Saisissez le poids du bagage: ");
            double poids = sc.nextDouble();
            b.setPoids(poids);

            x.afficher();

            System.out.println("Saisissez la couleur du bagage: ");
            couleur = sc.next();
            b.setCouleur(couleur);

            x.afficher();

        }else{
            x.afficher2();
        }


    }

}
