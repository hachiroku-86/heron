package Panels;

import DAO.JoueurDAO;
import DAO.ExceptionDAO;
import Class.Joueur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class PublicPane extends GridPane{


    public PublicPane(){

        this.setHgap(35);
        this.setVgap(35);
        this.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("PublicPane");
        scenetitle.setId("scene-title-text");
        this.add(scenetitle, 0, 0);


        MenuBar menuBar = new MenuBar();

        Menu menuJoueur = new Menu("Joueur");
        menuBar.getMenus().add(menuJoueur);

        MenuItem menuJoueur1 = new MenuItem("Tout les Joueurs");

        menuJoueur.getItems().add(menuJoueur1);


        Menu menuEquipe = new Menu("Equipe");
        menuBar.getMenus().add(menuEquipe);

        MenuItem menuEquipe1 =new MenuItem("Toutes les équipes");

        menuEquipe.getItems().add(menuEquipe1);


        Menu menuEntraineur = new Menu("Entraineur");
        menuBar.getMenus().add(menuEntraineur);

        MenuItem menuEntraineur1 = new MenuItem("Tout les entraineurs");

        menuEntraineur.getItems().add(menuEntraineur1);


        VBox vBox = new VBox(menuBar);
        this.add(vBox,15,0);

        Button btnAcc = new Button("Accueil");
        this.add(btnAcc, 0, 2);


        menuJoueur1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.getScene().setRoot(Main.getPanel("joueurPane"));
            }
        });

        menuEquipe1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.getScene().setRoot(Main.getPanel("equipePane"));
            }
        });

        menuEntraineur1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.getScene().setRoot(Main.getPanel("entraineurPane"));
            }
        });

        btnAcc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.getScene().setRoot(Main.getPanel("accueilPane"));
            }
        });
    }
}
