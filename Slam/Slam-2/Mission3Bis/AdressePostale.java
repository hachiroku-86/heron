package eu.hautil.mission3;

/** Classe AdressePostale
 * @author BastienGre
 * @version 1.0
 */
public class AdressePostale {
    /**
     * adresse est une chaine de caractères (ex : 9 rue de l'enfance)
     */
    private String adresse;
    /**
     * ville est une chaine de caractères (ex : Vaureal)
     */
    private String ville;
    /**
     * cp est une chaine de caractères (ex : 95490)
     */
    private String cp;

    /**
     * Un constructeur par défaut(ne fait rien)
     */
    public AdressePostale(){

    }

    /**
     * Un constructeur avec trois chaines en paramètres
     * @param adresse
     * @param ville
     * @param cp
     */
    public AdressePostale(String adresse, String ville, String cp){
        this.adresse=adresse;
        this.ville=ville;
        this.cp = cp;
    }

    /**
     * Une méthode qui permet de changer adresse
     * @param adresse
     */
    public void setAdresse(String adresse){
        this.adresse=adresse;
    }

    /**
     * Une méthode qui récupère l'adresse
     * @return la chaine de caractères adresse
     */
    public String getAdresse(){return this.adresse;}

    /**
     * Une méthode qui permet de changer la ville
     * @param ville
     */
    public void setVille(String ville){
        this.ville=ville;
    }

    /**
     * Une méthode qui récupère la ville
     * @return la chaine de caractères ville
     */
    public String getVille(){return this.ville;}

    /**
     * Une méthode qui permet de changer cp
     * @param cp
     */
    public void setCP(String cp){
        this.cp = cp;
    }

    /**
     * Une méthode qui récupère le code postal
     * @return la chaine de caractères cp
     */
    public String getCP(){return this.cp;}

    /**
     * Une méthode qui affiche l'adresse, la ville et le cp
     */
    public void afficher () {System.out.println("Adresse complète : "+adresse+" "+ville+" "+ cp);}
}
