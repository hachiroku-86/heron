import java.util.Scanner;
public class JeuxMaths {
    public static void main(String[] args){

        Scanner saisie = new Scanner(System.in);

        int somme= 0;
        int nmb;
        String chl= "0";

        for(int indice= 1; indice <= 10; indice++) {
            System.out.println("Saisissez un nombre");
            nmb = saisie.nextInt();
            chl=chl + "+" + nmb ;
            somme= somme + nmb;

        }

        System.out.println(chl + "=" + somme);
    }


}
