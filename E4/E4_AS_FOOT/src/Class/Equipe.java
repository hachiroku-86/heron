/**
 * Classe: Equipe
 * @author: Thomas HERON
 * @version: 1.0
 */
package Class;

public class Equipe {

    private int id;
    private Dirigeant entraineur;
    private Categorie categorie;
    private Club club;



    /**
     * Méthode qui initialise une équipe
     */
    public Equipe(int id, Dirigeant entraineur, Categorie categorie, Club club) {
        this.id = id;
        this.entraineur = entraineur;
        this.categorie = categorie;
        this.club = club;
    }

    public Equipe(){}


    /**
     * Méthode qui récupère l'id de l'équipe
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode qui récupère l'entraineur de l'équipe
     * @return entraineur
     */
    public Dirigeant getEntraineur() {
        return entraineur;
    }

    /**
     * Méthode qui récupère la catégorie de l'équipe
     * @return categorie
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * Méthode qui récupère le club de l'équipe
     * @return club
     */
    public Club getClub() {
        return club;
    }


    /**
     * Méthode qui initialise l'id de l'équipe
     * @param id id de l'équipe
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode qui initialise l'entraineur de l'équipe
     * @param entraineur id de l'équipe
     */
    public void setEntraineur(Dirigeant entraineur) {
        this.entraineur = entraineur;
    }

    /**
     * Méthode qui initialise la catégorie de l'équipe
     * @param categorie catégorie de l'équipe
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    /**
     * Méthode qui initialise le club de l'équipe
     * @param club club de l'équipe
     */
    public void setcClub(Club club) {
        this.club = club;
    }

    /**
     * Méthode qui permet d'afficher le joueur
     * @return '\n' + "Id = "+ id + '\n' + "Entraineur = "+ entraineur + '\n' + "Catégorie = "+ categorie + '\n' + "Club = "+ club +'\n';
     */
    @Override
    public String toString() {
        return "Equipe{" +
                "id=" + id +
                ", idEtraineur=" + entraineur +
                ", idCategorie=" + categorie +
                ", club=" + club +
                '}';
    }
}
