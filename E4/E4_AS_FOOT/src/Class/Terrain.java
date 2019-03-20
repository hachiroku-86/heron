/**
 * Classe: Terrain
 * @author: Thomas HERON
 * @version: 1.0
 */
package Class;

public class Terrain {

    private int id;
    private String nom;
    private double longueur;
    private double largeur;
    private int capacite;



    /**
     * Méthode qui initialise un terrain
     */
    public Terrain(int id, String nom, double longueur, double largeur, int capacite) {
        this.id = id;
        this.nom = nom;
        this.longueur = longueur;
        this.largeur = largeur;
        this.capacite = capacite;
    }

    /**
     * Méthode qui récupère l'id du terrain
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode qui récupère le nom du terrain
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode qui récupère la longueur du terrain
     * @return longueur
     */
    public double getLongueur() {
        return longueur;
    }

    /**
     * Méthode qui récupère la largeur du terrain
     * @return largeur
     */
    public double getLargeur() {
        return largeur;
    }

    /**
     * Méthode qui récupère la capacité du terrain
     * @return capacite
     */
    public int getCapacite() {
        return capacite;
    }


    /**
     * Méthode qui initialise l'id du terrain
     * @param id id du terrain
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode qui initialise le nom du terrain
     * @param nom nom du terrain
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode qui initialise la longueur du terrain
     * @param longueur longueur du terrain
     */
    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    /**
     * Méthode qui initialise la largeur du terrain
     * @param largeur largeur du terrain
     */
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    /**
     * Méthode qui initialise la capacité du terrain
     * @param capacite capacité du terrain
     */
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }


    /**
     * Méthode qui permet d'afficher le joueur
     * @return '\n' + "Id = "+ id + '\n' + "Nom = "+ nom + '\n' + "Longueur = "+ longueur + '\n' + "Entraineur = "+ entraineur + '\n' + "Durée = "+ duree +'\n';
     */
    @Override
    public String toString() {
        return "Terrain{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", longueur=" + longueur +
                ", largeur=" + largeur +
                ", capacite=" + capacite +
                '}';
    }
}
