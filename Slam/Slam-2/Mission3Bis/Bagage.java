package eu.hautil.mission3;

/** Classe Bagage
 * @author BastienGre
 * @version 1.0
 */

public class Bagage {
    /**
     * numero est un entier (ex : 1)
     */
    private int numero;
    /**
     * couleur est une chaine de caractère (ex : Rouge)
     */
    private String couleur;
    /**
     * poids est un réel (ex : 19,5)
     */
    private double poids;

    /**
     * Un constructeur par défaut
     */
    public Bagage(){

    }

    /**
     * Un constructeur à trois paramètres, une chaine, un entier, un réel
     * @param numero
     * @param couleur
     * @param poids
     */
    public Bagage(int numero, String couleur, double poids){
        this.numero=numero;
        this.couleur=couleur;
        this.poids=poids;
    }

    /**
     * Une méthode qui permet de changer le numéro
     * @param numero
     */
    public void setNumero(int numero){
        this.numero=numero;
    }

    /**
     * Une méthode qui récupère le numero
     * @return l'entier numero
     */
    public int getNumero(){
        return this.numero;
    }

    /**
     * Une méthode qui permet de changer la couleur
     * @param couleur
     */
    public void setCouleur(String couleur){
        this.couleur=couleur;
    }

    /**
     * Une méthode qui récupère la couleur
     * @return la chaine de caractères couleur
     */
    public String getCouleur(){
        return this.couleur;
    }

    /**
     * Une méthode qui permet de changer le poids
     * @param poids
     */
    public void setPoids(double poids){
        this.poids=poids;
    }

    /**
     * Une méthode qui récupère le poids
     * @return le réel poids
     */
    public double getPoids(){
        return this.poids;
    }

    /**
     * Une méthode qui affiche le numéro, la couleur et le poids
     */
    public void afficher() {
        System.out.println("Descriptif du bagage : "+numero+" "+couleur+" "+poids+"kg");
    }
}
