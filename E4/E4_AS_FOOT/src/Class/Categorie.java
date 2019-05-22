/**
 * Classe: Catégorie
 * @author: Thomas HERON
 * @version: 1.0
 */
package Class;

public class Categorie {

    private int id;
    private String nom;
    private int ageMin;
    private int ageMax;
    private String code;


    public Categorie() {}

    /**
     * Méthode qui initialise une catégorie
     */
    public Categorie(int id, String nom, int ageMin, int ageMax, String code) {
        this.id = id;
        this.nom = nom;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.code = code;

    }

    /**
     * Méthode qui récupère l'id de la catégorie
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode qui récupère le nom de la catégorie
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode qui récupère l'age minimum pour appartenir à la catégorie
     * @return ageMin
     */
    public int getAgeMin() {
        return ageMin;
    }

    /**
     * Méthode qui récupère l'age minimum pour appartenir à la catégorie
     * @return ageMax
     */
    public int getAgeMax() {
        return ageMax;
    }

    /**
     * Méthode qui récupère le code de la catégorie
     * @return code
     */
    public String getCode() {
        return code;
    }


    /**
     * Méthode qui initialise l'id de la catégorie
     * @param  id id de la catégorie
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode qui initialise le nom de la catégorie
     * @param  nom nom de la catégorie
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode qui initialise l'age minimum pour appartenir à la catégorie
     * @param  ageMin ageMin dees joueurs de la catégorie
     */
    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    /**
     * Méthode qui initialise l'age maximum pour appartenir à la catégorie
     * @param  ageMax ageMax des jouers de la catégorie
     */
    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }

    /**
     * Méthode qui initialise le code de la catégorie
     * @param  code code de la catégorie
     */
    public void setCode(String code) {
        this.code = code;
    }


    /**
     * Méthode qui permet d'afficher le joueur
     * @return '\n' + "Id = "+ id + '\n' + "Nom = "+ nom + '\n' + "AgeMin = "+ ageMin + '\n' + "AgeMax = "+ agemax + '\n' + "Code = "+ code +'\n';
     */
    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", ageMin=" + ageMin +
                ", ageMax=" + ageMax +
                ", code='" + code + '\'' +
                '}';
    }
}
