/**
 * Classe: Dirigeant
 * @author: Thomas HERON
 * @version: 1.0
 */
package Class;

import java.util.Date;

public class Entraineur extends Licencie {

    private Equipe equipe;



    /**
     * Méthode qui initialise un dirigeant
     */
    public Entraineur(int id, String nom, String prenom, Date dateNaissance, String login, String mdp, String licence, Date dateInscription,String type, Equipe equipe) {
        super(id, nom, prenom, dateNaissance, login, mdp, licence, dateInscription, type);
        this.equipe = equipe;
    }


    public Entraineur() {}


    /**
     * Méthode qui récupère l'équipe de l'entraineur
     * @return equipe
     */
    public Equipe getEquipe() {
        return equipe;
    }

    /**
     * Méthode qui récupère l'équipe de l'entraineur
     * @return equipe
     */
    public int getIdEquipe() {
        return equipe.getId();
    }


    /**
     * Méthode qui initialise l'équipe de l'entraineur
     * @param equipe equipe de l'entraineur
     */
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }




    /**
     * Méthode qui permet d'afficher le joueur
     * @return '\n' + "équipe = "+ equipe + '\n'';
     */
    @Override
    public String toString() {
        return "Dirigeant{" +
                "équipe='" + equipe + '\'' +
                '}';
    }
}
