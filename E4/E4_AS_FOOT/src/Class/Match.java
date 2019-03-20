/**
 * Classe: Match
 * @author: Thomas HERON
 * @version: 1.0
 */
package Class;

public class Match {

    private int id;
    private Equipe equipe;
    private  Terrain terrain;



    /**
     * Méthode qui initialise un match
     */
    public Match(int id, Equipe equipe, Terrain terrain) {
        this.id = id;
        this.equipe = equipe;
        this.terrain = terrain;
    }

    /**
     * Méthode qui récupère l'id du match
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode qui récupère l'équipe du match
     * @return equipe
     */
    public Equipe getEquipe() {
        return equipe;
    }

    /**
     * Méthode qui récupère le terrain du match
     * @return terrain
     */
    public Terrain getTerrain() {
        return terrain;
    }


    /**
     * Méthode qui initialise l'id du match
     * @param id id du licencié
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode qui initialise l'équipe du match
     * @param equipe équipe du licencié
     */
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    /**
     * Méthode qui initialise le terrain du match
     * @param terrain terrain du licencié
     */
    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }


    /**
     * Méthode qui permet d'afficher le joueur
     * @return '\n' + "Id = "+ id + '\n' + "Equipe = "+ equipe + '\n' + "Terrain = "+ terrain + '\n';
     */
    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", equipe=" + equipe +
                ", terrain=" + terrain +
                '}';
    }
}
