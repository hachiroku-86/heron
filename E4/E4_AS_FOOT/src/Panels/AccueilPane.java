package Panels;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class AccueilPane extends GridPane{

    public AccueilPane(){

        Button btnPublic = new Button("Public");
        this.add(btnPublic, 1,1);

        Button btnLog = new Button("Se connecter");
        this.add(btnLog, 1,2);

        btnPublic.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main.getScene().setRoot(Main.getPanel("publicPane"));
            }

        });

        btnLog.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main.getScene().setRoot(Main.getPanel("logPane"));
            }

        });

    }
}
