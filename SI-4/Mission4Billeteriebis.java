import java.util.Scanner;

public class Mission4Billeteriebis {

    public static void main (String[] args){

        String categorie= null;
        double prix = 0;
        float spectacle1;
        float spectacle2;
        float spectacle3;
        float spectacle4;
        int continuer=0;
        double prixtotal=0;

        Scanner Continuer = new Scanner(System.in);
        System.out.println("Souhaitez vous acheter ou quitter ?");
        continuer= Continuer.nextInt();

        while (continuer == 1) {


            Scanner Age = new Scanner(System.in);
        System.out.println("Saisissez votre age");
        int age= Age.nextInt();

        while (age < 0){
            System.out.println("Vous êtes con");
            System.out.println("Saisissez votre age");
            age = Age.nextInt();
        }

        Scanner Choix = new Scanner(System.in);
        System.out.println("Choisissez votre spectacle");
        int choix= Choix.nextInt();


        while (choix < 0 || choix > 4 ) {
            System.out.println("Vous êtes con");
            System.out.println("Choisissez votre spectacle");
            choix = Choix.nextInt();

        }


        if (age <= 3){
            System.out.println("nourisson"+ " " + age);
            categorie="nourisson";
        }
        else if (age > 3 && age <= 12){
            System.out.println("enfant"+ " " + age);
            categorie="enfant";
        }
        else if (age > 12 && age <= 18){
            System.out.println("adolescent"+ " " + age);
            categorie="adolescent";
        }
        else if (age > 18 && age <= 55){
            System.out.println("adult"+ " " + age);
            categorie="adult";
        }
        else if (age > 55 ){
            System.out.println("senior"+ " " + age);
            categorie="senior";
        }


        if(choix == 1){
            prix=10;
        }

        else if(choix == 2){
            prix=20;
        }

        else if(choix == 3){
            prix=30;
        }

        else if(choix == 4){
            prix=40;
        }



        if(categorie.equals("nourisson")){
            prix= 5;
            System.out.println(prix + "€");
        }

        else if(categorie.equals("enfant")){
            prix= prix*0.3;
            System.out.println(prix + "€");
        }

        else if(categorie.equals("adolescent")){
            prix= prix;
            System.out.println(prix + "€");
        }

        else if(categorie.equals("adult")){
            prix= prix;
            System.out.println(prix + "€");
        }

        else if(categorie.equals("senior")){
            prix= prix*0.5;
            System.out.println(prix + "€");
        }


        prixtotal= prixtotal + prix;

        Scanner Recommencer = new Scanner(System.in);
        System.out.println("Souhaitez vous continuer vos achats ? 1 pour continuer 2 pour quitter.");
        continuer= Continuer.nextInt();



        }

        System.out.println(prixtotal);

    }


}


