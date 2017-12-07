import java.util.Scanner;
public class Mission8 {


    public static void DescriptionVoyageurs(String a,int b) {
        System.out.println("Le voyageur " + a + " a " + b + " ans");
    }


    public static void OnAfficheTout(String c,int d) {
            System.out.println(c + ": " + d + " ans");
    }


    public static String Categorie(int b) {

        String a;
        if (b > 0 && b < 2) {
            a = "nourisson";
        } else if (b >= 2 && b < 12) {
            a = "enfant";
        } else if (b >= 12 && b < 55) {
            a = "adulte";
        } else {
            a = "senior";
        }

        return a;
    }


    public static int Moyenne( int []a){

        int moy= 0;

        for(int i=0; i<a.length; i++) {
            moy = moy + a[i];
        }
        moy = moy / a.length;

        return moy;
    }



    static int min(int [] tab){
        int min = tab[0];
        for (int i=0; i<5; i++){
            if (min >= tab[i]){
                min = tab[i];
            }
        }
        return min;
    }

    static int max(int [] tab){
        int max = tab[0];
        for (int i=0; i<5; i++) {
            if (max <= tab[i]) {
                max = tab[i];
            }
        }
        return max;
    }


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

            Mission8.DescriptionVoyageurs(tabNom[i],tabAge[i]);




            categorie[i]=Mission8.Categorie(tabAge[i]);
            System.out.println(categorie[i]);




        }

        moyAge=Mission8.Moyenne(tabAge);


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

        System.out.println("Les voyageurs sont: ");
        for(int i=0; i<5; i++){
            Mission8.OnAfficheTout(tabNom[i],tabAge[i]);
        }

        Mission8.min(tabAge);
        int min = Mission8.min(tabAge);
        Mission8.max(tabAge);
        int max = Mission8.max(tabAge);
        System.out.println("L'âge minimal est " + Agemin + " et l'âge maximal est " + Agemax + ". La moyenne des âges de la liste est de " + moyAge + " ans.");

    }
}
