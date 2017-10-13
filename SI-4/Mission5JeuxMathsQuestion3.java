import java.util.Scanner;
public class Question3JeuxMaths {
    public static void main(String[] args){

    int random = 0 + (int) (Math.random() * ((100-0) + 1));
    int nombre;
    int bananes=12;

    for(int indice=1; indice<=12; indice++) {
        Scanner saisie = new Scanner(System.in);
        System.out.println("Rentrez un nombre, vous avez " + bananes + " bananes pour trouver le singe !");
        nombre = saisie.nextInt();

        bananes= bananes - 1;

        if(nombre<random){
            System.out.println("Votre nombre est trop petit");
        }
        if(nombre>random){
            System.out.println("Votre nombre est trop grand");
        }
        if(nombre==random){
            System.out.println("Congratulation vous avez trouvé le singe en " + indice + " bananes :)");
            break;
        }
        if(indice==12){
            System.out.println("Vous avez utilisé vos 12 bananes :(");
        }
    }

    }
}
