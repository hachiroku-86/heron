import java.util.Scanner;
class SLAM_Mission1 {
    private static Scanner sc;
    public static void main( String args [] ) {
        sc = new Scanner(System.in);

        Voyageur[] tabVoyageur=new Voyageur[5];
        tabVoyageur[0]= new Voyageur("Robert", 34);
        tabVoyageur[1]= new Voyageur("Lucie", 18);
        tabVoyageur[2]= new Voyageur("Michou", 19);
        tabVoyageur[3]= new Voyageur("Lucas", 56);
        tabVoyageur[4]= new Voyageur("Sebastien", 90);
        Voyageur nv = new Voyageur ();
        Voyageur v = new Voyageur ();
        System.out.println("Quel est votre nom ? ");
        String nom = sc.next();
        nv.setNom(nom);
        System.out.println("Quel est votre âge ? ");
        int age = sc.nextInt();
        nv.setAge(age);
        nv.afficher();
        v.afficher();
        for (int i=0; i<5; i++){
            tabVoyageur[i].afficher();
        }
    }
}
