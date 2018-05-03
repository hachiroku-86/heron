package eu.hautil;

import eu.hautil.mission3.AdressePostale;
import eu.hautil.mission3.Bagage;
import eu.hautil.mission3.Voyageur;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	    //ETAPE 1
        // Créer une adresse postale (no rue xxx, ville, CP)
        // afficher l'adresse postale à l'aide de la méthode "afficher"
        // afficher les informations de l'adresse postales à l'aide des getters
        // modifier une propriété de l'adresse postale
        // réafficher l'adresse pour constater le changement

        AdressePostale ap = new AdressePostale("22 rue des reservoirs", "Triel sur Seine", "78510");
        ap.afficher();

        System.out.println(ap.getAdresse());
        System.out.println(ap.getVille());
        System.out.println(ap.getCP());

        System.out.println("Saisissez votre adresse :");
        Scanner sc = new Scanner (System.in);
        String adresse = sc.next();
        ap.setAdresse(adresse);

        System.out.println("Saisissez votre ville :");
        sc = new Scanner (System.in);
        String ville = sc.next();
        ap.setVille(ville);

        System.out.println("Saisissez votre cp :");
        sc = new Scanner (System.in);
        String cp = sc.next();
        ap.setCP(cp);

        System.out.println(adresse +" " + ville + " " + cp);

        ap.afficher();



        //ETAPE 2
        // créer un bagage (numéro, couleur et poids)
        // afficher le bagage à l'aide de la méthode "afficher"
        // afficher les informations du bagage à l'aide des getters
        // modifier une propriété du bagage
        // réafficher le bagage pour constater le changement

        Bagage b = new Bagage(12,"Bleu",22);
        b.afficher();
        System.out.println(b.getNumero());
        System.out.println(b.getCouleur());
        System.out.println(b.getPoids());

        System.out.println("Saisissez le numero :");
        sc = new Scanner (System.in);
        int numero = sc.nextInt();
        b.setNumero(numero);

        System.out.println("Saisissez la couleur :");
        sc = new Scanner (System.in);
        String couleur = sc.next();
        b.setCouleur(couleur);

        System.out.println("Saisissez le poids :");
        sc = new Scanner (System.in);
        int poids = sc.nextInt();
        b.setPoids(poids);

        b.afficher();


        //ETAPE 3
        // créer un voyageur (nom, age)
        // afficher le voyageur à l'aide de la méthode "afficher" (on constate qu'il manque une adresse !)
        // ajouter une adresse à ce voyageur (celle créée à l'étape 1)
        // réafficher le voyageur à l'aide la méthode "afficher"
        // afficher les propriétés du voyageur à l'aide des getters
        // modifier le nom de ce voyageur
        // modifier la ville de ce voyageur
        // réafficher le voyageur à l'aide la méthode "afficher" pour constater le changement

        Voyageur v = new Voyageur("Raphael",18);
        v.afficher();
        v.setAdresse(ap);
        v.afficher();

        v.setNom("Olivier");
        v.setAdresse(new AdressePostale("22 rue des reservoirs", "Triel sur Oise", "78510"));

        v.afficher();

        //ETAPE 4
        // Compléter le voyageur de l'étape 3
        // ajouter un bagage à ce voyageur (celui créé à l'étape2)
        // afficher le voyageur à l'aide la méthode "afficher"
        // afficher les propriétés du voyageur à l'aide des getters
        // modifier l'âge du voyageur
        // modifier la couleur du bagage du voyageur
        // réafficher le voyageur à l'aide la méthode "afficher" pour constater le changement

        v.setBagage(new Bagage(22,"vert",44));
        v.afficher();

        System.out.println(v.getNom());
        System.out.println(v.getAge());
        System.out.println(b.getNumero() + " " + b.getCouleur() + " " + b.getPoids());
        System.out.println(v.getCategorie());
        System.out.println(ap.getAdresse() + " " + ap.getVille() + " " + ap.getCP());

        v.setAge(44);

        b.setCouleur("Fuchsia");

        v.afficher();



        //ETAPE 5
        // Créer une liste dynamique de 5 voyageurs (nom, age, adresse)
        // afficher tous les voyageurs de la liste à l'aide de la méthode "afficher"

        ArrayList<Voyageur> listeV = new ArrayList<Voyageur>();

        Voyageur v1 = new Voyageur("Bastien",20);
        Voyageur v2 = new Voyageur("Raphael",18);
        Voyageur v3 = new Voyageur("Thomas",20);
        Voyageur v4 = new Voyageur("Valentin", 18);
        Voyageur v5 = new Voyageur("Matis", 18);

        listeV.add(v1);
        listeV.add(v2);
        listeV.add(v3);
        listeV.add(v4);
        listeV.add(v5);

        for(int i = 0; i< listeV.size();i++){
            Voyageur courgette = listeV.get(i);
            courgette.afficher();
        }

        //ETAPE 6 (Recherche)
        // Demander à l'utilisateur de saisir un nom de voyageur
        // Chercher ce voyageur dans la liste de l'étape5
        // afficher le voyageur trouvé ou un message de regret

        System.out.println("Saisissez le nom d'un voyageur que vous voulez voir :");
        String recherche = sc.next();

        for(int i = 0; i < listeV.size(); i++ ){
            if(recherche.equals(listeV.get(i).getNom())){
                listeV.get(i).afficher();
            }
        }

        //ETAPE 7 (recherche + suppression)
        // Demander à l'utilisateur de saisir un nom de voyageur
        // Chercher ce voyageur dans la liste de l'étape5
        // supprimer le voyageur trouvé et afficher un message de confirmation  ou afficher un message de regret
        // réafficher la liste des voyageurs


        System.out.println("Saisissez le nom d'un voyageur que vous voulez supprimer :");
        String rechercheDestruction = sc.next();

        for(int i = 0; i < listeV.size(); i++ ){
            if(rechercheDestruction.equals(listeV.get(i).getNom())){
                listeV.remove(i);
                System.out.println("Utilisateur suprimmé !");
            }
        }

        for(int i = 0; i< listeV.size();i++) {
            Voyageur courgette = listeV.get(i);
            courgette.afficher();
        }
    }
}
