import java.util.Scanner;

public class Mission7 {
    public Mission7() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nom = new String[]{"Pierre", "Robert", "Thomas", "Matis", "Tristan", "Adrien", "Marie", "Paul", "Lucas", "Raphaël"};
        double[][] note = new double[][]{{18.0D, 11.0D, 10.0D}, {4.0D, 7.0D, 5.0D}, {12.0D, 16.0D, 15.0D}, {2.0D, 8.0D, 15.0D}, {7.5D, 15.0D, 9.0D}, {19.0D, 8.0D, 20.0D}, {0.5D, 7.0D, 2.0D}, {12.0D, 13.0D, 9.5D}, {17.0D, 11.0D, 10.0D}, {2.0D, 12.0D, 20.0D}};
        double[] moy = new double[10];
        double mclasse = 0.0D;

        for(int i = 0; i < 10; ++i) {
            double m = 0.0D;
            System.out.println(nom[i]);

            for(int j = 0; j < 3; ++j) {
                System.out.println(note[i][j]);
                m += note[i][j];
            }

            m /= 3.0D;
            moy[i] = m;
            mclasse += m;
            System.out.println("La moyenne de " + nom[i] + " est de " + m);
        }

        mclasse /= 10.0D;
        System.out.println("La moyenne de la classe est de " + mclasse);
        System.out.print("\nDe quel élève cherchez vous les notes ? Entrer son nom ici : ");
        String rech = sc.next();

        for(int i = 0; i < 10; ++i) {
            if (rech.equals(nom[i])) {
                System.out.println(nom[i] + " a obtenu les notes suivantes : " + note[i][0] + ", " + note[i][1] + " et " + note[i][2] + ". Il a une moyenne de " + moy[i] + " et la moyenne de la classe est " + mclasse);
            }
        }

        if (!rech.equals(nom[0]) && !rech.equals(nom[1]) && !rech.equals(nom[2]) && !rech.equals(nom[3]) && !rech.equals(nom[4]) && !rech.equals(nom[5]) && !rech.equals(nom[6]) && !rech.equals(nom[7]) && !rech.equals(nom[8]) && !rech.equals(nom[9])) {
            System.out.println("-1");
        }

    }
}