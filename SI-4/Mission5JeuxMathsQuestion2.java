import java.util.Scanner;
public class Question2JeuxMaths {
    public static void main(String[] args){

        Scanner saisie = new Scanner(System.in);

        int signe;
        int nombre;
        int resultat;
        int somme=0;
        String chaine= "";

        for(int indice=1; indice<=5; indice ++) {


            System.out.println("Saisissez 1 pour addition ou 2 pour soustraction");
            signe = saisie.nextInt();

            Scanner addition1 = new Scanner(System.in);
            System.out.println("Saisissez un nombre");
            nombre = addition1.nextInt();

            if(indice==1){
                chaine= chaine + nombre;
            }
            else {
                if (signe == 1) {
                    chaine = chaine + "+" + nombre;
                    somme = somme + nombre;
                } else {
                    chaine = chaine + "-" + nombre;
                    somme = somme - nombre;
                }
            }

        }
        System.out.println(chaine + "=" + somme);
    }



}
