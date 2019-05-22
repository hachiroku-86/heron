package Panels;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import Class.Joueur;

public class AccueilJoueurPane extends GridPane{

    private Joueur joueur = null;

    private Text idJoueur = new Text("");
    private Text nomJoueur = new Text("");
    private Text prenomJoueur = new Text("");
    private Text dateNaissanceJoueur = new Text("");
    private Text licenceJoueur = new Text("");
    private Text dateInscriptionJoueur = new Text("");
    private Text numeroJoueur = new Text("");
    private Text posteJoueur = new Text("");
    private Text titre = new Text("");


    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur){
        this.joueur = joueur;
        exe();
    }

    private void exe(){

        titre.setText("Bienvenue " + joueur.getPrenom() + " " + joueur.getNom() + " !");
        idJoueur.setText("Id : " + joueur.getId());
        prenomJoueur.setText("Prénom : " + joueur.getPrenom());
        nomJoueur.setText("Nom : " + joueur.getNom());
        dateNaissanceJoueur.setText("Date de naissance : " + joueur.getDateNaissance());
        dateInscriptionJoueur.setText("Date d'inscription : " + joueur.getDateInscription());
        licenceJoueur.setText("Licence : " + joueur.getLincence());
        posteJoueur.setText("Poste : " + joueur.getPoste());
        numeroJoueur.setText("Numéro : " + joueur.getNum());

        VBox vbox = new VBox();
        this.add(vbox, 0, 1);

        vbox.getChildren().add(titre);
        vbox.getChildren().add(idJoueur);
        vbox.getChildren().add(prenomJoueur);
        vbox.getChildren().add(nomJoueur);
        vbox.getChildren().add(posteJoueur);
        vbox.getChildren().add(numeroJoueur);
        vbox.getChildren().add(dateNaissanceJoueur);
        vbox.getChildren().add(dateInscriptionJoueur);
        vbox.getChildren().add(licenceJoueur);




    }

    public AccueilJoueurPane(){

        this.setHgap(35);
        this.setVgap(35);
        this.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("AccuielJoueurPane");
        scenetitle.setId("scene-title-text");
        this.add(scenetitle, 0, 0);

        Button btnRet = new Button("Accueil");
        this.add(btnRet, 0,3);





        btnRet.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main.getScene().setRoot(Main.getPanel("accueilPane"));
            }

        });

    }
}
