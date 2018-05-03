package eu.hautil.mission3;


/** Classe Voyageur
 * @author BastienGre
 * @version 1.0
 */

public class Voyageur{
    /**
     * nom est une chaine de caractères (ex : Bastien)
     */
    private String nom;
    /**
     * age est un entier (ex : 20)
     */
    private int age;
    /**
     * categorie est une chaine de caractères (ex : nourisson)
     */
    private String categorie;
    /**
     * adresse est une AdressePostale (ex : 9 rue de l'enfance 95490 Vaureal)
     */
    private AdressePostale adresse;
    /**
     * bagage est un Bagage (ex : 1 Rouge 20,5)
     */
    private Bagage bagage;

    /**
     * Une méthode qui permet de changer nom
     * @param nom
     */
    public void setNom(String nom){
        if (nom.length()>= 2){
            this.nom=nom;
        }
    }

    /**
     * Une méthode qui récupère le nom
     * @return la chaine de caractère nom
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * Une méthode qui permet de changer age
     * @param age
     */
    public void setAge(int age){
        if (age > 0){
            this.age=age;
            setCategorie();
        }
    }

    /**
     * Une méthode qui récupère l'age
     * @return l'entier age
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Une méthode qui permet de changer categorie
     */
    private void setCategorie(){
        if (age < 2){
            this.categorie="nourisson";
        }
        else if (age >=2 && age <10){
            this.categorie="enfant";
        }
        else if (age >=10 && age<18){
            this. categorie="adolescent";
        }
        else if (age >=18 && age<55){
            this.categorie="adulte";
        }
        else{
            this.categorie="senior";
        }
    }

    /**
     * Une méthode qui récupère categorie
     * @return la chaine de caractere catégorie
     */
    public String getCategorie(){
        return this.categorie;
    }

    /**
     * Un constructeur vide
     */
    public Voyageur(){
        nom = " ";
        age = 0;
        setCategorie();
    }

    /**
     * Un constructeur à deux paramètres, nom et age
     * @param nom
     * @param age
     */
    public Voyageur(String nom, int age){
        this.nom=nom;
        this.age=age;
        setCategorie();
    }

    /**
     * Une méthode qui permet de changer adresse
     * @param adresse
     */
    public void setAdresse(AdressePostale adresse){
        this.adresse=adresse;
    }

    /**
     * Une méthode qui récupère adresse
     * @return l'AdressePostale adresse
     */
    public AdressePostale getAdresse() {
        return this.adresse;
    }

    /**
     * Une méthode qui permet de changer bagage
     * @param bagage
     */
    public void setBagage(Bagage bagage){
        this.bagage=bagage;
    }

    /**
     * Une méthode qui récupère bagage
     * @return le Bagage bagage
     */
    public Bagage getBagage(){
        return this.bagage;
    }

    /**
     * Une méthode qui affiche le descriptif du voyageur, et son adresse si elle est renseignée
     */
    public void afficher () {
        System.out.println ("Descriptif du voyageur :("+nom+","+age+","+categorie+")");
        if (this.adresse != null){
            this.adresse.afficher();
        }
        else{
            System.out.println("Adresse non renseignée.");
        }
        if (this.bagage != null){
            this.bagage.afficher();
        }
        else{
            System.out.println("Bagage non renseigné.");
        }
    }

}
