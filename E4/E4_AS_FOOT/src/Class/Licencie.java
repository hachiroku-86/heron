/**
 * Classe: Licencie
 * @author: Thomas HERON
 * @version: 1.0
 */
package Class;

import java.util.Date;

public class Licencie {
    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String login;
    private String mdp;
    private String licence;
    private Date dateInscription;
    private String type;



    /**
     * Méthode qui initialise un licencié
     */
    public Licencie(int id, String nom, String prenom, Date dateNaissance, String login, String mdp, String licence, Date dateInscription, String type){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.dateNaissance=dateNaissance;
        this.login=login;
        this.mdp=mdp;
        this.licence=licence;
        this.dateInscription=dateInscription;
        this.type=type;
    }

    public Licencie(){}

    /**
     * Méthode qui récupère l'id du licencié
     * @return id
     */
    public int getId(){ return id;}

    /**
     * Méthode qui récupère le nom du licencié
     * @return nom
     */
    public String getNom(){ return nom;}

    /**
     * Méthode qui récupère le prénom du licencié
     * @return prenom
     */
    public String getPrenom(){ return prenom;}

    /**
     * Méthode qui récupère la date de naissance du licencié
     * @return dateNaissance
     */
    public Date getDateNaissance(){ return dateNaissance;}

    /**
     * Méthode qui récupère le login du licencié
     * @return login
     */
    public String getLogin(){ return login;}

    /**
     * Méthode qui récupère le mot de passe du licencié
     * @return mdp
     */
    public String getMdp(){ return mdp;}

    /**
     * Méthode qui récupère la licence du licencié
     * @return licence
     */
    public String getLincence(){ return licence;}

    /**
     * Méthode qui récupère la date d'inscription du licencié
     * @return dateInscription
     */
    public Date getDateInscription(){ return dateInscription;}

    /**
     * Méthode qui récupère le type du licencié
     * @return type
     */
    public String  getType(){ return type;}


    /**
     * Méthode qui initialise l'id du licencié
     * @param id id du licencié
     */
    public void setId(int id) { this.id = id; }

    /**
     * Méthode qui initialise le nom du licencié
     * @param nom id du licencié
     */
    public void setNom(String nom) { this.nom = nom; }

    /**
     * Méthode qui initialise le prénom du licencié
     * @param prenom prénom du licencié
     */
    public void setPrenom(String prenom) { this.prenom = prenom; }

    /**
     * Méthode qui initialise la date de naissance du licencié
     * @param dateNaissance id du licencié
     */
    public void setDateNaissance(Date dateNaissance) { this.dateNaissance = dateNaissance; }

    /**
     * Méthode qui initialise le login du licencié
     * @param login login du licencié
     */
    public void setLogin(String login) { this.login = login; }

    /**
     * Méthode qui initialise le mot de passe du licencié
     * @param mdp mot de passe du licencié
     */
    public void setMdp(String mdp) { this.mdp = mdp; }

    /**
     * Méthode qui initialise la licence du licencié
     * @param licence licence du licencié
     */
    public void setLicence(String licence) { this.licence = licence; }

    /**
     * Méthode qui initialise la date d'inscription du licencié
     * @param dateInscription date d'inscription du licencié
     */
    public void setDateInscription(Date dateInscription) { this.dateInscription = dateInscription; }

    /**
     * Méthode qui initialise le type du licencié
     * @param type type du licencié
     */
    public void setType(String type) { this.type = type; }


    /**
     * Méthode qui permet d'afficher le joueur
     * @return '\n' + "Id = "+ id + '\n' + "Nom = "+ nom + '\n' + "Prénom = "+ prenom + '\n' + "Date de naissance = "+ dateNaissance + '\n' + "Login = "+ login +'\n + "Mot de passe = "+ mdp +'\n + "Licence = "+ licence +'\n + "Date d'inscription = "+ dateInscrition +'\n + "Type ="+ type';
     */
    @Override
    public String toString() {
        return  "Licencie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ", licence='" + licence + '\'' +
                ", dateInscription=" + dateInscription + '\''+
                ", type=" + type + '\''+
                '}';
    }
}
