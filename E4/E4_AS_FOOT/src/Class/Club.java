/**
 * Classe: Club
 * @author: Thomas HERON
 * @version: 1.0
 */
package Class;

public class Club {

    private int id;
    private Terrain terrain;
    private String nom;
    private String ville;


    /**
     * Méthode qui initialise un club
     */
    public Club(int id, Terrain terrain, String nom, String ville) {
        this.id = id;
        this.terrain = terrain;
        this.nom = nom;
        this.ville = ville;
    }


    /**
     * Méthode qui récupère l'id du club
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode qui récupère le terrain du club
     * @return terrain
     */
    public Terrain getTerrain() {
        return terrain;
    }

    /**
     * Méthode qui récupère le nom du club
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode qui récupère la ville du club
     * @return nom
     */
    public String getVille() {
        return ville;
    }


    /**
     * Méthode qui initialise l'id du club
     * @param  id id du club
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode qui initialise le terrain du club
     * @param  terrain terrain du club
     */
    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    /**
     * Méthode qui initialise le nom du club
     * @param nom nom du club
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode qui initialise la ville du club
     * @param ville ville du club
     */
    public void setVille(String ville) {
        this.ville = ville;
    }


    /**
     * Méthode qui permet d'afficher le joueur
     * @return "Club{" + "id=" + id + ", terrain=" + terrain + ", nom='" + nom + '\'' + ", ville='" + ville + '\'' + '}';
     * */
    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", terrain=" + terrain +
                ", nom='" + nom + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
