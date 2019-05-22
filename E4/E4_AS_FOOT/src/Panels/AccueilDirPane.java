package Panels;

import DAO.EntraineurDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import Class.Entraineur;


public class AccueilDirPane extends GridPane{

    private Entraineur entraineur = null;
    private Text titre = new Text("");


    public Entraineur getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(Entraineur entraineur){
        this.entraineur = entraineur;
        exe();
    }

    public void exe(){

        titre.setText("Bienvenue " + entraineur.getPrenom() + " " + entraineur.getNom() + " !");

    }

    public AccueilDirPane(){

        this.setHgap(35);
        this.setVgap(35);
        this.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("AccueilDirPane");
        scenetitle.setId("scene-title-text");
        this.add(scenetitle, 0, 0);


        MenuBar menuBar = new MenuBar();

        Menu menuJoueur = new Menu("Joueur");
        menuBar.getMenus().add(menuJoueur);

        MenuItem menuJoueur1 = new MenuItem("Mes Joueurs");
        MenuItem menuJoueur2 = new MenuItem("Ajouter un Joueur");
        MenuItem menuJoueur3 = new MenuItem("Supprimer un Joueur");

        menuJoueur.getItems().add(menuJoueur1);
        menuJoueur.getItems().add(menuJoueur2);
        menuJoueur.getItems().add(menuJoueur3);


        Menu menuEquipe = new Menu("Equipe");
        menuBar.getMenus().add(menuEquipe);

        MenuItem menuEquipe1 =new MenuItem("Mes équipes");
        MenuItem menuEquipe2 =new MenuItem("Ajouter une équipe");
        MenuItem menuEquipe3 =new MenuItem("Supprimer une équipe");

        menuEquipe.getItems().add(menuEquipe1);
        menuEquipe.getItems().add(menuEquipe2);
        menuEquipe.getItems().add(menuEquipe3);


        VBox vBox = new VBox(menuBar);
        this.add(vBox,15,0);

        Button btnAcc = new Button("Accueil");
        this.add(btnAcc, 0,2);


        menuJoueur1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                EntraineurDAO eDAO = new EntraineurDAO();
                Entraineur entraineur = eDAO.getEntraineurById(String.valueOf(getEntraineur().getId()));
                DirJoueurPane jPane = (DirJoueurPane) Main.getPanel("dirJoueurPane");
                jPane.setEntraineur(entraineur);
                Main.getScene().setRoot(Main.getPanel("dirJoueurPane"));
            }

        });

        menuJoueur2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                EntraineurDAO eDAO = new EntraineurDAO();
                Entraineur entraineur = eDAO.getEntraineurById(String.valueOf(getEntraineur().getId()));
                NouvJoueurPane jPane = (NouvJoueurPane) Main.getPanel("nouvJoueurPane");
                jPane.setEntraineur(entraineur);
                Main.getScene().setRoot(Main.getPanel("nouvJoueurPane"));
            }

        });

        menuJoueur3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                EntraineurDAO eDAO = new EntraineurDAO();
                Entraineur entraineur = eDAO.getEntraineurById(String.valueOf(getEntraineur().getId()));
                SupJoueurPane jPane = (SupJoueurPane) Main.getPanel("supJoueurPane");
                jPane.setEntraineur(entraineur);
                Main.getScene().setRoot(Main.getPanel("supJoueurPane"));
            }

        });


        btnAcc.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main.getScene().setRoot(Main.getPanel("accueilPane"));
            }

        });

    }
}
