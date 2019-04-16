package Panels;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class AccueilDirPane extends GridPane{

    public AccueilDirPane(){

        Button btnJoueur = new Button("Joueur");
        this.add(btnJoueur, 1,1);

        Button btnMatch = new Button("Matches");
        this.add(btnMatch, 1,2);

        Button btnTerrain = new Button("Terrains");
        this.add(btnTerrain, 1,3);


        btnJoueur.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main.getScene().setRoot(Main.getPanel("dirJoueurPane"));
            }

        });

        btnMatch.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main.getScene().setRoot(Main.getPanel("accueilDirPane"));
            }

        });

        btnTerrain.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main.getScene().setRoot(Main.getPanel("accueilDirPane"));
            }

        });

    }
}
