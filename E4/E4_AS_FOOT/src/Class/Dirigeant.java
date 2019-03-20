/**
 * Classe: Dirigeant
 * @author: Thomas HERON
 * @version: 1.0
 */
package Class;

import java.util.Date;

public class Dirigeant extends Licencie {

    private String type;
    private Club club;


    /**
     * Méthode qui initialise un dirigeant
     */
    public Dirigeant(int id, String nom, String prenom, Date dateNaissance, String login, String mdp, String licence, Date dateInscription, String type, Club club) {
        super(id, nom, prenom, dateNaissance, login, mdp, licence, dateInscription);
        this.type = type;
        this.club = club;
    }


    public Dirigeant() {}


    /**
     * Méthode qui récupère le type du dirigeant
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Méthode qui récupère le club du dirigeant
     * @return club
     */
    public Club getClub() {
        return club;
    }

    /**
     * Méthode qui initialise le type du dirigeant
     * @param type type du dirigeant
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Méthode qui initialise le club du dirigeant
     * @param club club du dirigeant
     */
    public void setClub(Club club) {
        this.club = club;
    }


    /**
     * Méthode qui permet d'afficher le joueur
     * @return '\n' + "Type = "+ type + '\n' + "Club = "+ club +\n';
     */
    @Override
    public String toString() {
        return "Dirigeant{" +
                "type='" + type + '\'' +
                ", club=" + club +
                '}';
    }
}
