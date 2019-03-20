package Panels;

import DAO.DAO;
import Class.Licencie;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class PublicPane extends GridPane{

    public PublicPane(){
        
        this.setAlignment(Pos.CENTER_LEFT);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        Button btnJoueurs = new Button("Voir les joueurs professionnels");
        Button btnClub = new Button("Voir les clubs");
        Button btnRet = new Button("Retour");

        this.add(btnJoueurs, 1, 1);
        this.add(btnClub, 2, 1);
        this.add(btnRet, 1, 2);

        btnJoueurs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.getScene().setRoot(Main.getPanel("publicJoueursProPane"));
            }
        });

        btnClub.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.getScene().setRoot(Main.getPanel("publicClubPane"));
            }
        });

        btnRet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.getScene().setRoot(Main.getPanel("loginPane"));
            }
        });
    }
}
