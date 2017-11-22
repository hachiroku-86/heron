import java.util.Scanner;
public class Mission6 {
    public static void main(String[] args){


        int Agemin;
        int Agemax;
        double moyAge = 0;
        String categorie[] = new String[5];

        int tabAge [] = new int [5];
        String tabNom [] = new String [5];

        for(int i=0; i<5; i++) {
        Scanner Nom = new Scanner(System.in);
        System.out.println("Entrer votre nom");
        tabNom[i] = Nom.next();





        Scanner Age = new Scanner(System.in);
        System.out.println("Entrer votre age");
        tabAge[i] = Nom.nextInt();


        if(tabAge[i]>0 && tabAge[i]<2){
            categorie[i] = "nourisson";
        }
        else if(tabAge[i]>=2 && tabAge[i]<12){
            categorie[i] = "enfant";
        }
        else if(tabAge[i]>=12 && tabAge[i]<55){
            categorie[i] = "adulte";
        }
        else{
            categorie[i] = "senior";
        }

        moyAge= moyAge + tabAge[i];

        }

        moyAge=moyAge/5;
        Agemin=tabAge[0];
        Agemax=tabAge[0];

        for(int i=0; i<5; i++){
            if(tabAge[i] < Agemin){
                Agemin = tabAge[i];
            }
            if(tabAge[i] > Agemax){
                Agemax = tabAge[i];
            }
        }


        for(int i=0; i<5; i++){
            System.out.println(tabNom[i] + " a " + tabAge[i] + " ans et appartient à la catégorie " + categorie[i] + ".");
        }

        System.out.println("L'âge minimal est " + Agemin + " et l'âge maximal est " + Agemax + ". La moyenne des âges de la liste est de " + moyAge + " ans.");

    }

}
