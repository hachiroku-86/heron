import java.util.Scanner;
public class ProgBonus {
    public static void main(String[] args){



        //Question 1//
        int nombre;

        Scanner saisie = new Scanner(System.in);
        System.out.println("Saisissez un nombre ?");
        nombre= saisie.nextInt();

        if(nombre%2 == 0){
            System.out.println("Votre nombre est pair !");
        }else{
            System.out.println("Votre nombre est impair !");
        }


        //Question 2//
        int nombreA;
        int nombreB;

        Scanner saisieA = new Scanner(System.in);
        System.out.println("Saisissez un premier nombre:");
        nombreA= saisieA.nextInt();

        Scanner saisieB = new Scanner(System.in);
        System.out.println("Saisissez un premier nombre:");
        nombreB= saisieB.nextInt();

        if(nombreA>=0 && nombreB>=0){
            System.out.println("Le produit est positif");
        }else{
            System.out.println("Le produit est négatif");
        }


        //Question 3//
        int nombre1;
        int nombre2;
        int nombre3;

        Scanner nmb1 = new Scanner(System.in);
        System.out.println("Saisissez nombre 1:");
        nombre1= nmb1.nextInt();

        Scanner nmb2 = new Scanner(System.in);
        System.out.println("Saisissez nombre 2:");
        nombre2= nmb2.nextInt();

        Scanner nmb3 = new Scanner(System.in);
        System.out.println("Saisissez nombre 3:");
        nombre3= nmb3.nextInt();

        if(nombre1 < nombre2 && nombre1<nombre3){
            System.out.println("Le plus petit nombre est: " + nombre1);
        }
        else if(nombre2<nombre1 && nombre2<nombre3){
            System.out.println("Le plus petit nombre est: " + nombre2);
        }else{
            System.out.println("Le plus petit nombre est: " + nombre3);
        }


    }

}
