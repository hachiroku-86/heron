package Panels;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class AccueilJoueurPane extends GridPane{

    public AccueilJoueurPane(){

        Button btnMatch = new Button("Matches");
        this.add(btnMatch, 1,1);

        Button btnEq = new Button("Equipe");
        this.add(btnEq, 1,2);

        Button btnDir = new Button("Dirigeant");
        this.add(btnDir, 1,3);


        btnMatch.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main.getScene().setRoot(Main.getPanel("publicPane"));
            }

        });

        btnEq.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main.getScene().setRoot(Main.getPanel("logPane"));
            }

        });

        btnDir.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main.getScene().setRoot(Main.getPanel("accueilJoueurPane"));
            }

        });

    }
}
