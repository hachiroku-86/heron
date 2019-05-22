/**
 * Classe: Entrainement
 * @author: Thomas HERON
 * @version: 1.0
 */
package Class;

public class Entrainement {

    private int id;
    private Equipe equipe;
    private Terrain terrain;
    private Entraineur entraineur;
    private double duree;



    /**
     * Méthode qui initialise un entraineur
     */
    public Entrainement(int id, Equipe equipe, Terrain terrain, Entraineur entraineur, double duree) {
        this.id = id;
        this.equipe = equipe;
        this.terrain = terrain;
        this.entraineur = entraineur;
        this.duree = duree;
    }


    /**
     * Méthode qui récupère l'id de l'entrainement
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode qui récupère l'équipe de l'entrainement
     * @return equipe
     */
    public Equipe getEquipe() {
        return equipe;
    }

    /**
     * Méthode qui récupère le terrain de l'entrainement
     * @return terrain
     */
    public Terrain getTerrain() {
        return terrain;
    }

    /**
     * Méthode qui récupère l'entraineur de l'entrainement
     * @return entraineur
     */
    public Entraineur getEntraineur() {
        return entraineur;
    }

    /**
     * Méthode qui récupère la durée de l'entrainement
     * @return entraineur
     */
    public double getDuree() {
        return duree;
    }


    /**
     * Méthode qui initialise l'id de l'entrainement
     * @param id id de l'entrainement
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode qui initialise l'équipe de l'entrainement
     * @param equipe équipe de l'entrainement
     */
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    /**
     * Méthode qui initialise le terrain de l'entrainement
     * @param terrain terrain de l'entrainement
     */
    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    /**
     * Méthode qui initialise l'entraineur de l'entrainement
     * @param entraineur entraineur de l'entrainement
     */
    public void setEntraineur(Entraineur entraineur) {
        this.entraineur = entraineur;
    }

    /**
     * Méthode qui initialise l'id de l'entrainement
     * @param duree durée de l'entrainement
     */
    public void setDuree(double duree) {
        this.duree = duree;
    }

    /**
     * Méthode qui permet d'afficher le joueur
     * @return '\n' + "Id = "+ id + '\n' + "Equipe = "+ equipe + '\n' + "Terrain = "+ terrain + '\n' + "Entraineur = "+ entraineur + '\n' + "Durée = "+ duree +'\n';
     */
    @Override
    public String toString() {
        return "Entrainement{" +
                "id=" + id +
                ", equipe=" + equipe +
                ", terrain=" + terrain +
                ", entraineur=" + entraineur +
                ", duree=" + duree +
                '}';
    }
}
