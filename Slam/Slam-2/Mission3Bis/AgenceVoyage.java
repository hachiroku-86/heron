package eu.hautil.mission3;


import java.util.ArrayList;
import java.util.Scanner;

/** Classe AgenceVoyage
 * @author BastienGre
 * @version 1.0
 */

public class AgenceVoyage {
    /**
     * créé un scanner
     */
    private static Scanner sc;
    /**
     * nom est une chaine de caractère (ex : AvenTour)
     */
    private String nom;
    /**
     * adresse est une AdressePostale (ex : 9 rue de l'enfance 95490 Vaureal)
     */
    private AdressePostale adresse;
    /**
     * listeV est une liste de Voyageur
     */
    private ArrayList<Voyageur> listeV;

    /**
     * v1, v2, v3, v4, v5 sont des Voyageur
     */
    Voyageur v1 = new Voyageur("Bastien",20);
    Voyageur v2 = new Voyageur("Raphael",18);
    Voyageur v3 = new Voyageur("Thomas",20);
    Voyageur v4 = new Voyageur("Valentin", 18);
    Voyageur v5 = new Voyageur("Matis", 18);

    /**
     * Une méthode qui permet d'ajouter un voyageur a la liste
     * @param x
     */
    public void addVoyageur(Voyageur x){
        listeV.add(x);
    }

    /**
     * Une méthode qui cherche dans la liste le nom d'un voyageur et l'affiche
     * @param nom
     */
    public void search(String nom){
        String sea = nom;
        for (int i=0; i<listeV.size(); i++) {
            if (sea.equals(listeV.get(i).getNom())) {
                listeV.get(i).afficher();
            }
        }
    }

    /**
     * Une méthode qui supprime une personne de la liste suite à une confirmation
     * @param nom
     */
    public void del(String nom){
        for (int i=0; i<listeV.size(); i++){
            if (nom.equals(listeV.get(i).getNom())){
                listeV.get(i).afficher();
                System.out.println("Voulez-vous vraiment le supprimer ? Entrez 1 pour oui, 0 pour non");
                int testdel = sc.nextInt();
                if (testdel == 1){
                    listeV.remove(i);
                }
            }
        }
    }

    /**
     * Une méthode qui permet de changer le nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *  Une méthode qui récupère le nom
     * @return la chaine de caractère nom
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Une méthode qui permet de changer l'adresse
     * @param adresse
     */
    public void setAdresse(AdressePostale adresse) {
        this.adresse = adresse;
    }

    /**
     * Une méthode qui récupère l'adresse
     * @return l'AdressePostale adresse
     */
    public AdressePostale getAdresse() {
        return this.adresse;
    }

    /**
     * Une méthode qui ajoute à la liste les voyageurs créés précédemment
     */
    public AgenceVoyage(){
        listeV = new ArrayList<Voyageur>();
        listeV.add(v1);
        listeV.add(v2);
        listeV.add(v3);
        listeV.add(v4);
        listeV.add(v5);
    }

    /**
     * Un constructeur à deux paramètres, nom et adresse
     * @param nom
     * @param adresse
     */
    public AgenceVoyage(String nom, AdressePostale adresse){
        this.nom=nom;
        this.adresse=adresse;
    }

    /**
     * Une méthode qui permet d'afficher le nom de l'agence de voyage, son adresse ainsi que la liste de Voyageur
     */
    public void afficher(){
        System.out.println("Vous êtes dans l'agence de voyage "+nom+" qui se situe à l'adresse suivante: ");
        adresse.afficher();
        System.out.println("La liste des voyageurs est : ");
        for (int i=0; i<listeV.size(); i++){
            listeV.get(i).afficher();
        }
    }
}
