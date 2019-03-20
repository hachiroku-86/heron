/**
 * Classe: Joueur
 * @author: Thomas HERON
 * @version: 1.0
 */
package Class;

import java.util.Date;

public class Joueur extends Licencie{

    private Equipe equipe;
    private int num;
    private String poste;



    /**
     * Méthode qui initialise un joueur
     */
    public Joueur(int id, String nom, String prenom, Date dateNaissance, String login, String mdp, String licence, Date dateInscription, Equipe equipe, int num, String poste) {
        super(id, nom, prenom, dateNaissance, login, mdp, licence, dateInscription);
        this.equipe = equipe;
        this.num = num;
        this.poste = poste;
    }


    public Joueur() {}

    /**
     * Méthode qui initialise l'équipe du joueur
     * @param equipe équipe du joueur
     */
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    /**
     * Méthode qui initialise le numéro du joueur
     * @param num numéro du joueur
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * Méthode qui initialise le poste du joueur
     * @param poste poste du joueur
     */
    public void setPoste(String poste) {
        this.poste = poste;
    }


    /**
     * Méthode qui récupère l'équipe du joueur
     * @return equipe
     */
    public Equipe getEquipe() {

        return equipe;
    }

    /**
     * Méthode qui récupère le numéro du joueur
     * @return num
     */
    public int getNum() {
        return num;
    }

    /**
     * Méthode qui récupère le poste du joueur
     * @return poste
     */
    public String getPoste() {
        return poste;
    }

    /**
     * Méthode qui permet d'afficher le joueur
     * @return '\n' + "Equipe = "+ equipe + '\n' + "Num = "+ num + '\n' + "Poste = "+ poste + '\n';
     */
    @Override
    public String toString() {
        return "Joueur{" +
                "equipe=" + equipe +
                ", num=" + num +
                ", poste='" + poste + '\'' +
                '}';
    }
}
